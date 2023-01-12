# 이것이 자바다[개정판] - TCP 채팅 프로그램

### TCP 채팅 프로그램

| 클래스       | 용도                                                         |
| ------------ | ------------------------------------------------------------ |
| ChatServer   | - 채팅 서버 실행 클래스<br />- ServerSocket을 생성하고 50001에 바인딩<br />- ChatClient 연결 수락 후 SocketClient 생성 |
| SocketClient | - ChatClient와 1:1로 통신                                    |
| ChatClient   | - 채팅 클라이언트 실행 클래스<br />- ChatServer에 연결 요청<br />- SocketClient와 1:1로 통신 |



### 구현 사진

![image-20230112110010996](C:\Users\SSAFY\Desktop\JAVA\This is JAVA\assets\image-20230112110010996.png)



##### 오류해결

- 인터넷에서 찾은 json 라이브러리를 인식하지 못해서

  try catch를 끝도없이 요구하는 문제 발생

  ㄴ 이것이 자바다[개정판] 소스코드를 다운받아 json라이브러리를 복사, 사용하니 해결됨