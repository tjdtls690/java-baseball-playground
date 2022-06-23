# 기능 구현 목록

## 입력
- [ ] 컴퓨터에게 3개의 랜덤 숫자를 입력받는다.  Computer#createRandomNumber()
  - [x] 3개의 숫자가 모두 달라야 한다.  Judgment#isDifferent()
  - [x] 1 ~ 9 까지의 숫자만 들어와야 한다.  BallNumber#new Ball()
- [ ] 사용자에게 3개의 숫자를 입력받는다.  InputView#inputNumber()
  - [x] 3개의 숫자가 모두 달라야 한다.  Judgment#isDifferent()
  - [x] 1 ~ 9 까지의 숫자만 들어와야 한다.  BallNumber#new Ball()
  
## 도메인
- [x] 숫자를 하나 vs 하나로 비교해서 답 반환하기
  - [x] 낫싱 : 같은 숫자가 아예 없는 경우  Ball#play()
  - [x] 스트라이크 : 같은 숫자, 같은 위치  Ball#play()
  - [x] 볼 : 같은 숫자, 다른 위치  Ball#play()
- [x] 숫자를 리스트 vs 하나로 비교해서 답 반환하기
  - [x] 낫싱 : 같은 숫자가 아예 없는 경우  Balls#isMatchUp()
  - [x] 스트라이크 : 같은 숫자, 같은 위치  Balls#isMatchUp()
  - [x] 볼 : 같은 숫자, 다른 위치  Balls#isMatchUp()
- [x] 숫자를 리스트 vs 리스트로 비교해서 답 반환하기
  - [x] 낫싱 : 0 스트라이크 0 볼  
  - [x] +1스트라이크 : 같은 숫자, 같은 위치  
  - [x] +1볼 : 같은 숫자, 다른 위치  
- [x] 컴퓨터 숫자와 플레이어 숫자를 비교해서 결과값을 도출한다.  Referee#compare()
  - [x] 결과값을 통해 정답 여부를 판단한다.  Referee#isCorrect()
    - [x] 정답 : 3 strike  
    - [x] 오답 : not 3 strike

## 출력
- [ ] 반환된 결과값을 통해 결과를 출력한다.  ResultView#resultPrint()
- [ ] 정답 후 다시 시작 선택 여부 묻는 출력  ResultView#reStartPrint()