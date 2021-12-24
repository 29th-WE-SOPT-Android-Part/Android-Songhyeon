# 목차
1주차 과제는 1주차 브랜치에 있음!  
[2주차 필수과제](#2주차-필수-과제)  
[3주차 필수과제](#3주차-과제)  
[4주차 필수 과제](#4주차-과제)  
[7주차 필수 과제](#7주차-과제)  


# 4주차 과제 

(엄청난 뒷북입니다,,,,,)

## POSTMAN 테스트

### 1. 회원가입
![ㅇㅇㅇ](https://user-images.githubusercontent.com/81518783/146979803-60126646-6ec2-45ea-b556-2f39c78d90ae.png)




### 2. 로그인
![ㅇㅇㅇ](https://user-images.githubusercontent.com/81518783/146979839-7f28d3e3-8d72-4b23-a14f-b975cf868354.png)




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


![ㅇㅇㅇ](https://user-images.githubusercontent.com/81518783/146979726-60817fab-2a19-4f4c-9aec-5f3de344d909.png)




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



  
# 7주차 과제

###  구현한 로직(코드)을 설명하는 내용  


#### 1-1. 온보딩 : SignInActivity 화면으로 전환 시 HostActivity는 finish()로 종료

```kotlin
binding.btnNext.setOnClickListener {
    startActivity(Intent(context, SignInActivity::class.java))
    requireActivity().finish()
}
```

## 1-2 : 자동 로그인 및 해제

- 로그인 버튼 클릭 -> 자동 로그인
- 로그아웃 -> 자동 로그인 해제 및 로그인 창으로 이동



## 1-3 Util

###  1. ToastUtil

```kotlin
package com.example.a29th_first_semina.util

import android.content.Context
import android.widget.Toast

object ToastUtil {

    fun Context.makeToast(message : String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
}
```

- Util 만드는 게 처음이라서 실습 겸으로 세미나에 있는 걸 그대로 썼습니다.



### 2. IntentUtil

```kotlin
package com.example.a29th_first_semina.util
import android.content.Context
import android.content.Intent

object IntentUtil {
    fun moveActivity(context: Context?, activity: Class<*>){
        val intent = Intent(context,activity)
        context?.startActivity(intent)
    }
}
```

####  만든 이유

1. 매번 intent를 각각 만든 후 startActivity 코드 까지 작성해야하는게 귀찮아서 만들었습니다
2. 그 다음 버튼 클릭 시 함수 안에 또 만들어야하는게 귀찮았습니다.



#### 🤦🏻‍♀️IntentUtil 사용 전

```kotlin
    private fun clickSignUpEvent() {
        binding.tvSignup.setOnClickListener {
            moveSignUpActivity()
        }

    }


 private fun moveSignUpActivity() {
        val signupIntent = Intent(this, SignUpActivity::class.java)
        startActivity(signupIntent)
}
```



#### 🙆🏻‍♀️IntentUtil 사용 후

```kotlin
private fun clickSignUpEvent() {
	binding.tvSignup.setOnClickListener {
            IntentUtil.moveActivity(this, HomeActivity::class.java)
        }
}
```

한결 간결해져서 만족스럽습니다.



## 패키징 방식

![image-20211224174814851](C:\Users\PS42\AppData\Roaming\Typora\typora-user-images\image-20211224174814851.png)

- Util과 ui로 나눔
- ui
- ![image-20211224174939152](C:\Users\PS42\AppData\Roaming\Typora\typora-user-images\image-20211224174939152.png)
- 각 뷰별로 패키징함
- 안에 data, di, SheredPreference, view로 나눔
  - data : 서버에 필요한 RequestData , ReponseData
  - ui : 서버 연동에 필요한 서비스 객체
  - SheredPreference : 동일
  - view : Acitivity, Fragment
  - adpter : adpter



- 이유
  - 같은 뷰를 작업할 시엔 클릭을 여러번 하면서 이동하기가 번거로움
  - 그래서 관련된 것들은 모두 같은 뷰에 넣은 후 다시 종류별로 패키징함



### 이번 과제를 통해 배운내용 및 성장한 내용

1. 온보딩을 한 번도 해본 적이 없었는데 재밌었습니다!
2. 버튼을 액티비티에 넣어서 액티비티 내에서 전환처리를 해보잔 생각이 들었습니다
3. Util을 막상 만드니 재밌고, 한결 간결해져서 보기 좋았습니다


### 시연연상
https://user-images.githubusercontent.com/81518783/147325216-40873039-81ee-4c6e-ac4a-4fe9deef169f.mp4

