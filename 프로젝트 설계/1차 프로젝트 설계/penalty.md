# 22.01.12 

### 퇴장시 패널티에 대한 논의

* 기존에 퇴장시 패널티를 부여하기로 한 이유는 본래 서비스 의도와 상이한 목적을 가진 사용자가 여러 세션을 자유롭게 옮겨다니는 것을 방지하기 위함이었다.
  * 처음에는 이 패널티를 '다음 식사까지 최소 남은 시간' 등의 단어 선택으로 '정상적인 사용자들의 부정적 감정을 최소화' 하고자 했다. (돌이켜보니 굉장히 불합리한 방향성)
  * 하지만 논의를 거친 결과 소셜 로그인을 지원하는 서비스 특성상 계정을 여러개 동원하는 것 만으로 패널티는 충분히 우회가 가능했다.
  * 오히려 극소수의 비정상적 이용자들을 걱정하여 모든 사용자에게 불편함을 야기시키는 기능이라는 결론이 나오게 되어 패널티를 제거하게 되었다.







이하 글은 결론이 나오기까지의 논의 내용을 간단하게 정리한 내용이다.





일단 컨설턴트님께서 말씀해주신 내용은 2가지이다.

1. 미친놈을 만나서 신고하고 나가는 등의 경우엔 패널티가 없어야 하지 않을까
2. 가중처벌시 패널티 타이머를 변동시키는게 생각보다 쉽지 않을 것이다.





유저 유형 예상

* a. 정상적인 이용자 (이하 클린유저)

* b. 비정상적 이용자 (이하 불량유저)

  * b-1. 신고가 누적되는 유저 (보통 혐오, 불쾌감 조성일 것으로 예상)

  * b-2. 이유없이 신고를 남발하는 유저

  * b-3. 외적으로 마음에 드는 사람을 발견할 때까지 세션을 옮기는 유저

    (겉으로 의도를 나타내느냐 마느냐에 따라 신고 누적 정도가 다를 것으로 예상)





패널티 여부

1. 무조건 패널티

   장점 : 불량유저의 자유로운 세션 이동을 방해할 수 있다.

   단점 : 불량유저를 피해 퇴장한 클린유저까지도 패널티를 받게 된다. (사용자 경험 저하)

   

2. 패널티 제거

   장점 : 클린유저가 자유롭게 세션 이동이 가능하다.

   단점 : 불량유저 역시 자유롭게 세션 이동이 가능하다.

   

3. 조건적 패널티 (예 : 신고하고 퇴장하는 경우)

   장점 : 클린유저가 패널티를 피할 수 있다.

   단점 : 불량유저가 악용할 여지가 있다. 불량유저의 악용으로 인해 신고당하는 클린유저 발생

   보완책 의견1 : 클린유저 신고 누적을 방지하기 위해 운영자가 신고를 접수하여 처리하자.

   ​	반려 : 사실상 패널티가 없는 상태에서 추가인력만 필요한 상황이 될 듯

   보완책 의견2 : 패널티 면제 횟수 제한을 두자

   

   

가중패널티 여부

2 - 패널티를 제거할 경우 논의할 필요가 없어짐.

1, 3 - 가중처벌 (나가기 1회시 10분 / 2회시 30분 / 3회시 60분)

​	가중패널티 여부에 따라 타이머 변동시키는게 생각보다 쉽지 않다고 하셨음.

​	1안 - 변동 잘 구현하기

​	2안 - 패널티 시간 하나로 통일하기 (10분/15분)





이후 유저 유형, 패널티 여부, 가중패널티 여부 등등의 장단점을 고려해보고 어떤 방식의 서비스를 구현할지 고민하는 와중, 본인인증 없이 소셜 로그인을 통해 여러 계정을 사용할 수 있도록 설계한 서비스 특성상, 불량유저가 정성스럽게 여러 계정을 사용하면 패널티를 우회할 수 있다는 점이 발견되었다.

결국 불량유저를 저지하기 위해 만들었던 패널티는 불량유저를 저지하는 본래 기능은 잘 수행하지 못하고 정상적인 서비스 이용자들에게 불편함만을 발생시킨다는 결론에 이르러 패널티를 제거하기로 하였다.