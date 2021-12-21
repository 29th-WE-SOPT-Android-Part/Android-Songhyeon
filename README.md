# Android-Songhyeon
![github_김송현_ver1-5](https://user-images.githubusercontent.com/70698151/135753442-ab5a944a-7ebf-4aa5-bb12-aada0e7b7106.png)

# 필수 과제
( 도전 과제는 나중에 올릴게용!)

### SignIpActivity
1. 아이디, 비밀번호에 입력된 값이 있는지 체크한다
2. 입력된 값이 있을 경우
3. 입력된 값을 String 값으로 받아준다
4. Intent를 통해 SignInAcivity -> SignUnActivity로 전환. 함수 사용
5. SignInActivity로 이동

### 과제를 통해 성장한 점
1. 지난 28기 과제와 비교했을 때 코드가 더 깔끔해진 점
2. 지난 28기 때 겪었던 문제들을 모두 해결한 점
3. YB들을에게 어느정도 알려줄 수 있을 정도가 된 것


  

https://user-images.githubusercontent.com/81518783/136696727-91285e7f-6e5e-4948-9936-5f54235739fe.mp4



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





