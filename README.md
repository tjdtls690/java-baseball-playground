# 기능 구현 목록

## 게임 플레이
- [ ] 각 객체들을 이용해서 게임을 플레이한다. Application#playGame()

## 입력
- [x] 컴퓨터에게 1 ~ 9 까지의 3자리 랜덤 숫자를 입력받는다.  Computer#getRanNum()
  - [x] 1 ~ 9 까지의 '숫자'임을 검증  Math.random()
  - [x] 전부 서로 다른 수임을 검증  
- [x] 사용자에게 1 ~ 9 까지의 3자리 랜덤 숫자를 입력받는다.  InputView#inputNum()
  - [x] 이 중 하나라도 만족 못한다면, 다시 입력 받기
    - [x] 1 ~ 9 까지의 '숫자'임을 검증  BallNumber#생성자
    - [x] 전부 서로 다른 수임을 검증

## 출력
- [x] 반환받은 결과값을 출력  ResultView#resultPrint()
- [ ] 정답일 시, 축하 메시지와 재시작 선택 여부 출력  ResultView#restartAsk()
- [ ] 다시 시작 선택값 반환  ResultView#restartSelectNum()
    
## 도메인
- [x] 하나 vs 하나로 숫자 비교 후 결과 반환  Ball#play()
  - [x] nothing : 0 ball 0 strike  (enum)BallStatus#NOTHING
  - [x] ball : 같은 숫자, 다른 위치  (enum)BallStatus#BALL
  - [x] strike : 같은 숫자, 같은 위치  (enum)BallStatus#STRIKE
- [x] 리스트 vs 하나로 숫자 비교 후 결과 반환  Balls#play()
  - [x] nothing : 0 ball 0 strike
  - [x] ball : 같은 숫자, 다른 위치
  - [x] strike : 같은 숫자, 같은 위치
- [x] 리스트 vs 리스트로 숫자 비교 후 결과 반환  Balls#play()
  - [x] nothing : 0 ball 0 strike
  - [x] ball : 같은 숫자, 다른 위치
  - [x] strike : 같은 숫자, 같은 위치
- [x] 결과값을 저장  Judgment
  - [x] 정답 여부 판단  Judgment#isGameEnd()


기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

같은 수가 같은 자리에 있으면 스트라이크, 
다른 자리에 있으면 볼, 
같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고, 
그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.


e.g. 상대방(컴퓨터)의 수가 425일 때, 123을 제시한 경우 : 1스트라이크, 456을 제시한 경우 : 1볼 1스트라이크, 789를 제시한 경우 : 낫싱
위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게 임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.