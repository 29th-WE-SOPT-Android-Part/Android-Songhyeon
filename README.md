
# 4주차 과제 

(엄청난 뒷북입니다,,,,,)

## POSTMAN 테스트

### 1. 회원가입

![image-20211222031942799](C:\Users\PS42\AppData\Roaming\Typora\typora-user-images\image-20211222031942799.png)



### 2. 로그인

![image-20211222032053562](C:\Users\PS42\AppData\Roaming\Typora\typora-user-images\image-20211222032053562.png)



## 회원가입 API

```kotlin
        val requsetSignupData = RequsetSignUpdata(
            email = binding.etId.text.toString(),
            password =  binding.etPwd.toString(),
            name = binding.etName.toString()
        )

        val call : Call<ResponseSignUpData> = ServiceCreater.service.postSignup(requsetSignupData)

        call.enqueue(object : Callback<ResponseSignUpData>{
            override fun onResponse(
                call: Call<ResponseSignUpData>,
                response: Response<ResponseSignUpData>
            ) {
                if(response.isSuccessful){
                    val data = response.body()?.data
                    Log.d("서버통신 상태", response.body()?.status.toString())
                    finish()
                }

                else{
                    Log.d("서버통신 상태", response.body()?.status.toString())
                }
            }

            override fun onFailure(call: Call<ResponseSignUpData>, t: Throwable) {
                Log.d("서버통신 상태", "실패")
            }
        })


    
```



## 로그인 API

```kotlin
 val requsetLoginData = RequsetLoginData(
            email = binding.etId.text.toString(),
            password = binding.etPwd.text.toString()
        )

        val call : retrofit2.Call<ResponseLoginData> = ServiceCreater.service.postLogin(requsetLoginData)

        call.enqueue(object : Callback<ResponseLoginData>{
            override fun onResponse(
                call: retrofit2.Call<ResponseLoginData>,
                response: Response<ResponseLoginData>
            ) {
                if(response.isSuccessful){
                    val data = response.body()?.data
                    moveHomeActivity()
                    Log.d("서버통신 상태",response.body()?.status.toString())
                }
                else {
                    Toast.makeText(
                        this@SignInActivity,
                        response.body()?.status.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.d("서버통신 상태", response.body()?.status.toString())
                }
            }

            override fun onFailure(call: retrofit2.Call<ResponseLoginData>, t: Throwable) {
                Log.d("로그인통신 실패","실패임")
            }
        })
```



- 알아보기 쉽게 Log문으로 status 값을 띄웠습니다.

- 실행결과 둘 다 200이 뜹니다.

  

## 실행 결과

![image-20211222031542596](C:\Users\PS42\AppData\Roaming\Typora\typora-user-images\image-20211222031542596.png)



## 시연 영상
https://user-images.githubusercontent.com/81518783/146979540-880e143c-df8a-4d41-8477-cdaf8c903f63.mp4




# 3차 뒷북입니다
# 3주차 과제

굉장히 뒷북입니다,,,,,,,,,죄송합니다,,,,,,



### ProfileFragment 내 repository btn, follower btn 클릭 시 fragment 대체

```kotlin
   childFragmentManager.beginTransaction().add(R.id.frg_list, FollowerFragment()).commit()
        binding.btnFollower.isSelected = true
        binding.btnRepogitory.isSelected = false



        binding.btnFollower.setOnClickListener {
            binding.btnFollower.isSelected = true
            binding.btnRepogitory.isSelected = false

            childFragmentManager.beginTransaction()
                .replace(R.id.frg_list, FollowerFragment())
                .commit()
        }

        binding.btnRepogitory.setOnClickListener {
            binding.btnFollower.isSelected = false
            binding.btnRepogitory.isSelected = true

            childFragmentManager.beginTransaction()
                .replace(R.id.frg_list, RepositoryFragment())
                .commit()
        }
    }
```

- childFragmentManager를 사용했습니다
- button 클릭 시 button 및 text 의 color가 바뀔 수 있게 isSelected 속성을 바꿨습니다





### 이미지 Circle 적용

```kotlin
private fun initImage() {
        Glide.with(this)
            .load(R.drawable.me)
            .circleCrop()
            .into(binding.ivPhoto)
    }
```

- Glide를 사용 했습니다



### 시연연상
https://user-images.githubusercontent.com/81518783/146917797-7f5af776-3d7a-4b30-88c2-932a3e5c3062.mp4







# 2주차 필수 과제
( 도전 과제는 나중에 올릴게용!)

### 📚패키징
![패키징사진](https://user-images.githubusercontent.com/81518783/138344343-f7f31ae8-2cf3-472d-ae43-b97d59efc217.png)


이번에 파일이 많아져서 UI-VIEW- 각 뷰별 패키지를 만들어 보기 편하게 정리했습니다.

### Fragment
<pre><code>
private var _binding : FragmentRepoBinding ?= null
    private val binding get() = _binding ?: error("뷰 참조를 위해 바인딩이 초기화되지 않음")
    </code></pre>
    
<pre><code>
       override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
</code></pre>
    
Fragment는 Activity와 생명주기가 다르다. 특히 Fragment는 좀비뷰가 생길 수 있기 때문에 Destory 될 떄 null 처리해주어 이를 방지했습니다


#### 버튼 클릭 시 프래그멘트 교체
<pre><code>
  binding.btnFollower.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frg_list, followerFragment).commit()
        }

        binding.btnRepogitory.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frg_list, repositoryFragment).commit()
        }
</code></pre>

각 버튼 클릭 리스너가 일어날 때 프래그멘트를 교체했습니다


### Recylerview
<pre><code>

  androidx.recyclerview.widget.RecyclerView
        android:id="@+id/rcv_follower"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layoutManager="androidx.recyclerview.widget.GridLayoutManager"
        tools:listitem="@layout/item_follower_list"
        app:spanCount="2"
        
        
</code></pre>

각 Fragment xml에 RecylerView를 넣어줬습니다. 팔로워뷰는 GridLayout으로 설정했습니다. 한 줄에 두 개의 Grid가 나올 수 있게 spanCount를 2로 설정했습니다


### maxLine, epllisize

<pre><code>
  android:textSize="20sp"
        android:maxLines="1"
        android:ellipsize="end"
</code></pre>
레포리토리 아이템뷰에 maxLiines, ellipsize 설정을 주어 text가 긴 경우 끝에서 **...** 처리했습니다.




### 과제를 통해 배운 내용, 성장한 내용
1. 앱잼 때 배웠던 효율적인 패키징을 적용한 것
2. Fragment와 Activity의 생명주기 차이점



  
