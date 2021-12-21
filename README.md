# 필수 과제
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



  