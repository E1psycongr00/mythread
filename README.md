# mythread
멀티 쓰레드와 동시성 문제에 대해 공부한 내용입니다. 간단한 클래스와 테스트 코드가 있습니다.

</br>

# 다루는 동시성 문제

1. 공유되는 자원의 동작 순서가 중요한 경우
2. 하나의 쓰레드가 쓰고 동안 최신화된 데이터를 계속 얻어와야하는 경우 (one Publisher, many subscriber)
3. 공유되는 자원을 쓰레드가 긴 시간동안 가지고 활용하는 동안 Thread Safe해야 할 때

</br>

# Multi Thread의 동시성 문제를 해결하기 위해 JAVA에서 지원하는 기능

1. synchronized
2. volatile
3. ThreadLocal
