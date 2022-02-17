package Pack01;

import java.io.*; // *은 java.io 하위에 있는 클래스를 모두 선택
import java.lang.reflect.Constructor;
//import java.io.FileWriter;
//import java.io.Writer;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/*
// ex)

public class Hello {
	public static void main(String[] args) {
		

		
	}
}
*/


//ex91) 네트워크 프로그래밍

public class Hello {
	public static void main(String[] args) {
		

		
	}
}



/*
//ex90-8) UI : 다른 클래스(World)와 함께 사용
public class Hello {
	public static void main(String[] args) {
		
		System.out.println("헬로");
		Scanner sc = new Scanner(System.in);
		sc.nextInt();
		System.out.println("헬로 종료");
		
	}
}
*/

/*
//ex90-7) UI : 이벤트의 스레드를 따로 클래스로 빼서 사용하기
class Tiger extends Thread{
	
	Hello hello;
	Button btn;
	
	Tiger(Button btn){
		this.btn = btn;
	}
	
	Tiger(Hello hello){
		this.hello = hello;
	}
	
	@Override
	public void run() {
		System.out.println("스레드 시작");
		
		// btn1
//		Platform.runLater(()->{
//			
//			btn.setText("호랑이");
//			
//		});

		// btn3, btn4
		Platform.runLater(()->{
			
			hello.btn3.setText("호랑이");
			hello.btn4.setText("코끼리");
			
		});
		
		System.out.println("스레드 종료");
	}
}
public class Hello extends Application {
	Button btn3;
	Button btn4;
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub

		HBox root = new HBox();
		root.setPrefSize(400, 300);
		root.setSpacing(10);
		
		// ---배치 영역---
		
//		Button btn1 = new Button("버튼1");
//		
//		btn1.setOnAction(new EventHandler<ActionEvent>() {
//			
//			@Override
//			public void handle(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				// 스레드를 따로 클래스로 빼서 코드가 깔끔해진다.
//				// => 문제점 : 클래스 내부에서 컨트롤 객체에 접근이 불가능하다.
//				// => 해결 : 생성자를 통해 내부 필드에 지정해준다.
//				Tiger t1 = new Tiger(btn1);
//				t1.start();
//			}
//		});
//		
//		root.getChildren().addAll(btn1);
		
		// 스레드를 통해서 제어할 요소가 많은 경우
		btn3 = new Button("버튼3");
		btn4 = new Button("버튼4");
		
		btn3.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				// 만약 요소가 많다면?
				// => 생성자에 오버로드로 수십개를 보낼 수 없다.
				// => hello 클래스 전체를 보내버린다. (this)
				Tiger t1 = new Tiger(Hello.this);
				t1.start();
			}
		});
		
		root.getChildren().addAll(btn3, btn4);
		
		// ---배치 영역---
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("호랑이");
		stage.show();
		
	}
	public static void main(String[] args) {
		System.out.println("Start");
		launch();
		
		System.out.println("Exit");
		
	}
}
*/

/*
//ex90-6) UI : 이벤트에 스레드 사용 시 주의점
public class Hello extends Application {
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub

		HBox root = new HBox();
		root.setPrefSize(400, 300);
		root.setSpacing(10);
		
		// ---배치 영역---
		
		Button btn1 = new Button("버튼1");
		
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Thread() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						System.out.println("스레드 시작");
//						btn1.setText("호랑이"); // 스레드에서 에러가 난다.
						
						// (주의!)스레드에선 반드시 클래스에 넣어서 컨트롤 상태를 변경해야한다.
						Platform.runLater(()->{
							
							btn1.setText("호랑이");
							
						});
						System.out.println("스레드 종료");
					}
				}.start();
			}
		});
		root.getChildren().addAll(btn1);
		
		// ---배치 영역---
		
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.setTitle("호랑이");
		arg0.show();
		
	}
	public static void main(String[] args) {
		System.out.println("Start");
		launch();
		
		System.out.println("Exit");
		
	}
}
*/

/*
//ex90-5) UI : 버튼 보이게/안보이게, 비활성화
public class Hello extends Application {
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub

		HBox root = new HBox();
		root.setPrefSize(400, 300);
		root.setSpacing(10);
		
		// ---배치 영역---
		
		Button btn1 = new Button("버튼1");
		Button btn2 = new Button("버튼2");
		
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				btn2.setText("홍길동"); // 다른 컨트롤러를 제어할 수 있다.
			}
		});
		
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
//				btn1.setVisible(false); // 안보이게
				btn1.setVisible( !btn1.isVisible() ); 
				
				btn1.setDisable(true); // 비활성화
			}
		});
		root.getChildren().addAll(btn1, btn2);
		
		// ---배치 영역---
		
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.setTitle("호랑이");
		arg0.show();
		
	}
	public static void main(String[] args) {
		System.out.println("Start");
		launch();
		
		System.out.println("Exit");
		
	}
}
*/

/*
//ex90-4) UI :
public class Hello extends Application {
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub

		VBox root = new VBox();
		root.setPrefSize(400, 300);
		root.setSpacing(10);
		
		// ---배치 영역---

		Button btn1 = new Button("버튼1");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("호랑이---");
				
			}
		});
		
		
		TextArea textArea = new TextArea();
		
		TextField textField = new TextField();
		textField.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String s = textField.getText();
//				System.out.println(s); // 엔터 입력 시 출력됟다.

				textField.setText("");
				
				textArea.appendText(s + "\n");
				
			}
		});
		
		root.getChildren().addAll(btn1, textArea, textField);
		
		// ---배치 영역---
		
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.setTitle("호랑이");
		arg0.show();
		
	}
	public static void main(String[] args) {
		System.out.println("Start");
		launch();
		
		System.out.println("Exit");
		
	}
}
*/


/*
//ex90-3) UI : 버튼 이벤트 함수
// 버튼 이벤트 함수 원리 예제
//interface A<T>{
//	void f1();
//}
//class Tiger {
//	void f2(A<Integer> a) {
//		a.f1();
//	}
//}
public class Hello extends Application {
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub

		HBox root = new HBox();
		root.setPrefSize(400, 300);
		root.setSpacing(10);
		
		// ---배치 영역---

		// 버튼 이벤트 함수 원리 예제
//		Tiger t1 = new Tiger();
//		t1.f2(new A<Integer>() {
//			@Override
//			public void f1() {
//				// TODO Auto-generated method stub
//				System.out.println();
//			}
//		});
		
		Button btn1 = new Button("버튼1");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("호랑이---");
				
			}
		});
		
		Button btn2 = new Button("버튼2");
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("코끼리");
				
			}
		});
		root.getChildren().addAll(btn1, btn2);
		
		// ---배치 영역---
		
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.setTitle("호랑이");
		arg0.show();
		
	}
	public static void main(String[] args) {
		System.out.println("Start");
		launch();
		
		System.out.println("Exit");
		
	}
}
*/



/*
//ex90-2) UI : 
public class Hello extends Application {
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub

//		VBox root = new VBox();
		HBox root = new HBox(); // Horizontal
		root.setPrefSize(400, 300);
		root.setSpacing(10); // 각 컨트롤 간의 간격 (px)
		
		// ---배치 영역---

		// 배치 방법 1.단일 배치
//		Button btn1 = new Button("버튼1"); // 객체 생성
//		root.getChildren().add(btn1); // 객체 배치
//		
//		Button btn2 = new Button("버튼2"); // 객체 생성
//		root.getChildren().add(btn2); // 객체 배치
		
		// 배치 방법 2. 일괄 배치 (주로 사용)
		Button btn1 = new Button("버튼1"); // 객체 생성
		Button btn2 = new Button("버튼2"); // 객체 생성
		Button btn3 = new Button("버튼3"); // 객체 생성
		
		root.getChildren().addAll(btn1, btn2, btn3); // 객체 일괄 배치
		
		// ---배치 영역---
		
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.setTitle("호랑이");
		arg0.show();
		
	}
	public static void main(String[] args) {
		System.out.println("Start");
		launch();
		
		System.out.println("Exit");
		
	}
}
*/


/*
//ex90-1-1) launch는 static인데, 어떻게 오버라이딩 일반 함수인 start를 불러올 수 있는가?
//			 => 자체 객체 생성 후 메소드 찾음
abstract class MyApplication{
	static void launch() {
		
//		Hello h = new Hello();
//		h.start();
		// 실제론 클래스명을 알 수 없기 때문에 위처럼 정적으로 만들지 않고
		// 동적으로 아래와 같이 클래스명을 찾게 한다.
		
		try {
			// 클래스 찾기
			Class<?> cls = Class.forName("Pack01.Hello");
			System.out.println(cls);
			
			// 객체 생성
			Constructor<?> constructor = cls.getConstructor();
			Object obj = constructor.newInstance();
			
			// 메소드 찾기
			Method m = cls.getMethod("start");
//			Method m = cls.getMethod("start", String.class); // 인수가 있는 함수의 경우
			System.out.println(m);
			
			// start 함수 호출
			m.invoke(obj);
//			m.invoke(obj, "호랑이"); // 인수가 있는 함수의 경우
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	abstract void start();
//	abstract void start(String s); // 인수가 있는 함수의 경우
}

public class Hello extends MyApplication {
	public void start() {
		System.out.println(100);
	}
//	public void start(String s) { // 인수가 있는 함수의 경우
//		System.out.println(s);
//	}
	public static void main(String[] args) {
		
		launch();
		
	}
}
*/


/*
//ex90-1) UI : swing -> JavaFx (잘안씀)
// 메인 클래스에 Application을 상속 받아야한다.
// https://gluonhq.com/products/javafx/ 에서 다운로드
// swing이랑 충돌 일어날 수 있으므로 조심
public class Hello extends Application {
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		// UI는 코드 프로그래밍적이지 않는게 좋은 UI이다.
		// 드래그 드롭으로 많은 걸 할 수 있어야 한다. (JavaFx는 코드 프로그래밍적이어서 나락갔다.)

		// 레이아웃 설정
		VBox root = new VBox(); // Vertical Box
		// 창 크기 설정 (적용X)
		root.setPrefSize(400, 300);
		
		// ------
		//
		// root 하위로 요소들이 배치된다.
		//
		// ------
		
		// 실제로 보여질 클래스 안에 눈에 보이지 않는 배치를 등록한다.
		// 창 크기 적용
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.setTitle("호랑이"); // 프로그램 상단 제목 설정
		arg0.show(); // 씬으로 등록된 것을 화면에 출력
		
	}
	public static void main(String[] args) {
		System.out.println("Start");
		launch(); // (첫글자 소문자) 내부의 start 함수 호출, static 함수 (static에선 static만)
		// 블로킹
		
		System.out.println("Exit"); // 창이 닫히고 나서야 출력이 된다.
		
	}
}
*/

/*
//ex89) Thread 사용법5 : 클래스를 이용한 스레드 사용
class Tiger extends Thread{
	public void run() {
		System.out.println(1);
	}
}

public class Hello {
	public static void main(String[] args) {
		
		// 1. 일반적인 스레드 사용
		Tiger t1 = new Tiger();
		t1.start();
		
		// 2. 업캐스팅으로 스레드 사용
		Thread t2 = new Tiger();
		t2.start();
		
		// 3. 익명 클래스 선언해서 스레드 사용
		Thread t3 = new Thread() {
			public void run() {
				System.out.println(2);
			}
		};
		t3.start();
		
		// 4. 익명 클래스를 선언하지 않고 스레드 사용
		new Thread() {
			public void run() {
				System.out.println(3);
			}
		}.start();
	}
}
*/

/*
//ex88) Thread 사용법4 : 제어권 분배 예제
class Lion extends Thread{
	public void run() {

		// 블로킹
		new Scanner(System.in).nextInt();
		System.out.println("독수리");
	}
}
class Tiger extends Thread{
	public void run() {
		Lion t2 = new Lion();
		t2.start();
		
		// 블로킹
		new Scanner(System.in).nextInt();
		System.out.println("코끼리");
	}
}
public class Hello {
	public static void main(String[] args) {
		
		Tiger t1 = new Tiger();
		t1.start(); // 
		
		// 블로킹
		new Scanner(System.in).nextInt();
		System.out.println("호랑이");
		
		
		// 블로킹 입력 코드 다음 바로 출력코드가 나올거라고 예상하는 것은 위험하다.
		// 출력 결과1 >> 블로킹 입력 코드와 출력 코드가 교차로 나온 경우
		//  1
		//  코끼리
		//  2
		//  호랑이
		//  3
		//  독수리
		
		// 출력 결과2 >> 블로킹 입력 코드가 연속으로 나온 경우
		//  1
		//	코끼리
		//	2
		//	3
		//	독수리
		//	호랑이
		
	}
}
*/

/*
//ex87) Thread 사용법3 : 제어권 분배 예제
class Tiger extends Thread{
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("호랑이 : " + i);
			// sleep(0) : OS가 생각할 때 가장 짧다고 생각되는 시간만큼 쉰다. (안쉬는 것 X)
			try { Thread.sleep(0); } catch (Exception e) { } 
		}
	}
}
public class Hello {
	public static void main(String[] args) {
		
		Tiger t1 = new Tiger();
		t1.start();
		
		for (int i = 0; i < 10; i++) {
			System.out.println("코끼리 : " + i);
			// sleep(0) : OS가 생각할 때 가장 짧다고 생각되는 시간만큼 쉰다. (안쉬는 것 X)
			try { Thread.sleep(0); } catch (Exception e) { } 
		}
	}
}
*/

/*
//ex86) Thread 사용법2 : 제어권 분배
// 스레드는 스코프를 벗어나면 종료된다. (주로 while문에서 많이 씀)
// 스레드는 고유의 번호를 가지고 생성된다.
// ex85와 같은 형식
class Tiger extends Thread{
	public void run() {
		System.out.println("thread start");
		System.out.println("call");
		System.out.println("thread end");
	}
}
public class Hello {
	public static void main(String[] args) {
		
		// ex85와 같은 형식
		// Tiger에 start가 없지만, 사용할 수 있다. => 부모인 Thread 클래스에 있다.
		Tiger t1 = new Tiger();
		t1.start(); // start가 되는 순간, run 함수의 "thread start"와 출력"호랑이"가 같은 선상에 놓이게 된다.
					// 둘 중 무엇이 먼저 실행할 지(제어권을 누가 먼저 받을지)는 오로지 운영체제의 선택이므로 알 수 없다.
		System.out.println("호랑이");
		
	}
}
*/

/*
//ex85) Thread 사용법1 : 사전 지식 
// 부모의 함수를 몰라도 자식의 구성과 함수의 동작을 통해 유추할 수 있어야한다.
class A {
	void start() {
		System.out.println("start call");
		run();
	}
	void run() {
		System.out.println("A class Run Call");
	}
	
}
class B extends A{
	@Override
	void run() {
		System.out.println("B class Run Call");
	}
}
public class Hello {
	public static void main(String[] args) {
		
		A t1 = new B();

		t1.start(); // start call, B class Run Call
		// B만 봐서는 자신에게 start가 없다. => 부모에게 있다.
		// 부모의 start를 실행시키니, 자식의 run이 실행되었다. => start에 run을 실행시키는 코드가 있다.
		
	}
}
*/

/*
//ex84) 키 입력 : Scanner 와 블로킹 함수
// 블로킹 함수 : 약속된 특정 조건이 만족될 때까지 프로그램이 더이상 진행하지 못하는 함수
// ex : nextInt(), sleep()
public class Hello {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요.");
		
		// 입력
		int num = sc.nextInt(); // nextInt() : 블로킹 함수
		System.out.println(num);

		int num2 = sc.nextInt();
		System.out.println(num2);
		
		System.out.println(num + num2);
		
		
		// 여러 번 입력
		for (int i = 0; i < 100; i++) {
			System.out.println("숫자를 입력하세요.");
			int num3 = sc.nextInt();
			
			// for문으로 인해 객체 생성에 비용이 많이 든다.
			// Resource leak: '<unassigned Closeable value>' is never closed
//			int num3 = new Scanner( System.in).nextInt();
			
			// 위와 같이, 랜덤 클래스도 매번 생성하지 않고,
			// 한 번 생성한 객체에서 nextInt()로 값을 받아올 수 있다.
//			Random rnd = new Random();
//			int random = new Random().nextInt(100);
			
			System.out.println(num3);
			if(num3 == 999) {
				break;
			}
		}

		System.out.println("프로그램을 종료합니다.");
	}
}
*/

/*
//ex83-2) Generic 사용법 : 클래스2
class Book{
	String title;
	String author;
	String publisher;
	int price;
	
	public Book(String title, String author, String publisher, int price) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", publisher=" + publisher + ", price=" + price + "]";
	}
	
	
	
}
public class Hello {
	public static void main(String[] args) {
		
		LinkedList<Book> mm = new LinkedList<>();
		
		// CREATE
//		mm.add(100); // 에러 : Book 클래스만 들어갈 수 있다.
		mm.add(new Book("자바를 배운다", "홍길동", "열심히출판사1", 100));
		mm.add(new Book("늦잠 자는 법", "게으름", "열심히출판사2", 150));
		mm.add(new Book("교육이 힘들어요", "아무게", "열심히출판사3", 200));
		mm.add(new Book("집에 일찍 가고 싶어요", "을지문", "열심히출판사4", 1000));
		System.out.println(mm.get(0).toString()); // Book [title=자바를 배운다, author=홍길동, publisher=열심히출판사, price=100]
		System.out.println(mm.size()); // 4
		
		// READ
		// 1. 전체
		for (Book book : mm) {
			System.out.println(book);
		}System.out.println();
		
		// 2. 검색
		Book oneBook = mm.get(2);
		System.out.println(oneBook);
		
		System.out.println("------");
		
		// UPDATE
		mm.set(1, new Book("일찍 일어나는 법", "이동현", "열심히출판사5", 2000));
		for (Book book : mm) {
			System.out.println(book);
		}System.out.println();
		
		System.out.println("------");
		
		// DELETE
		mm.remove(0);
		for (Book book : mm) {
			System.out.println(book);
		}System.out.println();
		
		// 검색
		// 일반적으로 함수를 만들어서 사용한다.
		Book findBook = search(mm, "을지문");
		if(findBook != null) {
			System.out.println("찾았다.");
			System.out.println(findBook);
		}else {
			System.out.println("그런 책 없음.");
		}
	}
	
	static Book search(LinkedList<Book> mm, String name) {
		for (Book book : mm) {
			if(book.author.equals(name)) {
				return book;
			}
		}
		return null;
	}
}
*/

/*
//ex83-1) Generic 사용법 : 클래스
class Tiger{
	
}
class Lion<T>{
	T age;
	void setAge(T age) {
		this.age = age;
	}
}
public class Hello {
	public static void main(String[] args) {
		
		// Generic에는 클래스가 들어갈 수 있다.
		Lion<Tiger> t1 = new Lion<>();
		
		
	}
}
*/

/*
//ex82-2) LinkedList 검색 제거 예제
public class Hello {
	public static void main(String[] args) {
		
		LinkedList<Integer> mm = new LinkedList<>();
		for (int i = 0; i < 10; i++) {
			mm.add(i * 10 + i);
		}
		System.out.println(mm); // [0, 11, 22, 33, 44, 55, 66, 77, 88, 99]

		mm.add(101);
		mm.add(102);
		mm.add(104);
		System.out.println(mm); // [0, 11, 22, 33, 44, 55, 66, 77, 88, 99, 101, 102, 104]
		
		// 짝수 제거 예제
		// 잘못된 코드
		for (int i = 0; i < mm.size(); i++) {
			if(mm.get(i)%2 == 0) {
				mm.remove(i);
			}
		}
		System.out.println(mm); // [11, 33, 55, 77, 99, 101, 104] => 짝수 104가 남아있다.
								// => 인덱스는 증가하는데, 데이터양은 줄어든다.
								// => 제거 이후, index를 새로 조정해줘야한다.

		// 데이터 초기화
		mm = new LinkedList<>();
		for (int i = 0; i < 10; i++) {
			mm.add(i * 10 + i);
		}

		mm.add(101);
		mm.add(102);
		mm.add(104);
		System.out.println(mm); // [0, 11, 22, 33, 44, 55, 66, 77, 88, 99, 101, 102, 104]

		// 올바른 코드
		for (int i = 0; i < mm.size();) {
			if(mm.get(i)%2 == 0) {
				mm.remove(i);
			}else {
				i++;
			}
		}
		System.out.println(mm); // [11, 33, 55, 77, 99, 101]

	}
}
*/

/*
//ex82-1) LinkedList 검색 제거
public class Hello {
	public static void main(String[] args) {
		
		LinkedList<Integer> mm = new LinkedList<>();
		
		for (int i = 0; i < 10; i++) {
			mm.add(i * 10 + i);
		}
		System.out.println(mm); // [0, 11, 22, 33, 44, 55, 66, 77, 88, 99]

		// 검색 후 제거
		for (int i = 0; i < mm.size(); i++) {
			if(mm.get(i) == 55) {
				mm.remove(i);
				break;
			}
		}
		System.out.println(mm); // [0, 11, 22, 33, 44, 66, 77, 88, 99]


	}
}
*/

/*
// 자료구조
//ex81) 콜렉션 - LinkedList CRUD
// 1. 콜렉션 클래스를 내가 만들 수 있는가? => 자료구조. (C / C++)
// 2. 이미 제작된 것을 잘 사용하는가? => (JAVA 등 나머지 계열)
//  => 이미 만들어진 걸 사용하기 때문에 자바는 자료구조가 없다. (자바 철학 : 만들어진 것을 잘 사용하자)
public class Hello {
	public static void main(String[] args) {
		
		LinkedList<Integer> mm = new LinkedList<>();
		// CRUD + 검색, 정렬 되는지 확인
		
		// CREATE
		System.out.println(mm.size()); // 데이터 넣기 전 0
		mm.add(100);
		System.out.println(mm.size()); // 데이터 넣은 후 1
		
		for (int i = 0; i < 10; i++) {
			mm.add(i * 10 + i);
		}
		System.out.println(mm.size()); // 데이터 넣은 후 11
	
		// READ
		// 1. 데이터를 보기만 할 뿐, 활용도가 떨어진다.
		System.out.println(mm); // [100, 0, 11, 22, 33, 44, 55, 66, 77, 88, 99] // .toString() 생략
		
		// 2. 데이터에 하나씩 접근할 수 있어서, 데이터를 활용할 수 있다. 
		for (int i = 0; i < mm.size(); i++) {
			System.out.print(mm.get(i) * 2 + " "); // 200 0 22 44 66 88 110 132 154 176 198 
		}System.out.println();
		
		// 3-1. for문의 간략화된 형식(슈가 코드) : forEach 문
		// data (혹은 item, value) : 실제 데이터 or Index 인지 확인해야됨.
		for (Integer data : mm) { // (받을 데이터 타입 : 객체) => 모든 데이터에 접근 후 종료
			System.out.print(data + " "); // 100 0 11 22 33 44 55 66 77 88 99 => 실제 데이터
		}System.out.println();
		
		// 3-2. 배열 forEach
		int[] arr = {10, 20, 30};
		for (int item : arr) {
			System.out.print(item + " "); // 10 20 30 
		}System.out.println();
		
		// 3-3. 문자열 forEach => 자바 X
//		String s = "무궁화꽃이피었습니다";
//		for (int value : s) { // 지원 안됨 (다른 언어에선 지원 됨)
//			System.out.println(value);
//		}
		
		// UPDATE
		System.out.println(mm); // [100, 0, 11, 22, 33, 44, 55, 66, 77, 88, 99]
		mm.set(5, 99); // index 5의 값을 99로 변경
		System.out.println(mm); // [100, 0, 11, 22, 33, 99, 55, 66, 77, 88, 99]

		// DELETE
		System.out.println(mm); // [100, 0, 11, 22, 33, 99, 55, 66, 77, 88, 99]
		mm.remove(4); // index 4의 값을 제거
		System.out.println(mm); // [100, 0, 11, 22, 99, 55, 66, 77, 88, 99]

		// 검색
		// 6-1. forEach (못 찾은 경우를 추가하려면, 외부 변수가 필요함)
		for (Integer data : mm) {
			if( data == 77 ) {
				System.out.println("find");
				break;
			}
		}System.out.println();
		
		// 6-2. for
		for (int i = 0; i < mm.size(); i++) {
			Integer value = mm.get(i);
			if(value == 77) {
				System.out.println(i + " : find");
				break;
			}
			
			if(i == mm.size() - 1) {
				System.out.println("Not found");
			}
		}
	}
}
*/

/*
//ex80) Generic 사용법
class Tiger{
	private int data;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
}
class Lion{
	private String data;
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
}
class Cat{
	private float data;
	
	public float getData() {
		return data;
	}
	
	public void setData(float data) {
		this.data = data;
	}
	
}

// Generic : 타입(T)은 객체를 생성할 때 정해진다.
// <> : '컨테이너'라고 칭함
class Dog<T>{
	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
class Bird<T, K>{
	private T data1;
	private K data2;
	

	public T getData1() {
		return data1;
	}
	public K getData2() {
		return data2;
	}

	public void setData(T data1, K data2) {
		this.data1 = data1;
		this.data2 = data2;
	}
	@Override
	public String toString() {
		return "Bird [data1=" + data1 + ", data2=" + data2 + "]";
	}
	
}

public class Hello {
	public static void main(String[] args) {
		
		// 아래 코드들은 타입만 다르고 모양은 같은 코드다.
		// => Generic으로 클래스를 합쳐준다.
		Tiger t1 = new Tiger();
		t1.setData(100);
		System.out.println(t1.getData());
		
		Lion t2 = new Lion();
		t2.setData("사자");
		System.out.println(t2.getData());
		
		Cat t3 = new Cat();
		t3.setData(3.14f);
		System.out.println(t3.getData());
		
		// Generic 예제
		// 클래스만 지원하므로, 원시 타입은 기본형을 사용해야한다. (Dog<int> => X, Dog<Integer> => O) 
		Dog<Integer> t4 = new Dog<Integer>();
//		Dog<Integer> t4 = new Dog<>(); // 뒤쪽은 <> 안이 생략 가능하다.
		t4.setData(100);
		System.out.println(t1.getData());
		
		Dog<Float> t5 = new Dog<Float>();
		t5.setData(100.0f);
		System.out.println(t5.getData());
		
		Bird<Integer, Float> t6 = new Bird<Integer, Float>();
		t6.setData(1, 0.2f);
		System.out.println(t6);
	}
}
*/

/*
//ex79) File 읽기
// bmp 파일을 read, 직접 만들 수 있으면 File에 대해선 고급 프로그래밍한다고 볼 수 있다.
public class Hello {
	public static void main(String[] args) {
		
		try {
			Reader reader = new FileReader("sample.txt");
//			Reader reader = new FileReader("s.txt");
			
			while(true) {
				
				// int java.io.Reader.read() throws IOException
				int readData = reader.read();
				if(readData == -1) {
					System.out.println("파일끝까지 모두 읽음");
					break;
				}
				
				System.out.print((char)readData);
			}
			
			reader.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(); // 에러 : 1. 경로, 2. 오타
		}
		System.out.println("출력");
		
	}
}
*/

/*
//ex78) File 입출력 예제
public class Hello {
	public static void main(String[] args) {
		
		// O X O X O X
		// X O X O X O
		// O X O X O X
		// X O X O X O
		// O X O X O X

		try {
			// Open
			Writer write = new FileWriter("sample.txt"); // 파일을 생성하는데, 존재한다면 덮어씌운다.
		
			int width = 6, height = 5;
			for (int i = 0; i < height; i++) { // 세로

				for (int j = 0; j < width; j++) { // 가로

					write.write(((i + j) % 2 == 0) ? "O " : "X ");
//					((i + j) % 2 == 0) ? write.write("O ") : write.write("X ");
					
				}
				write.write("\n");
			}
			
			// Close
			write.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
*/

/*
//ex77) File 입출력
public class Hello {
	public static void main(String[] args) {
		System.out.println(1);
		
		try {
			
			// 파일 입출력 == 펜 사용
			// 열고, 쓰고, 닫는 작업이 필요.
			// 파일을 닫지 않으면, 다른 프로그램에서 접근 불가능하다. -> 치명적인 오류 발생 가능
			
			// Open
			// Unhandled Exception
			// write(조상) = FileWriter(손자) => 업캐스팅
			Writer write = new FileWriter("sample.txt"); // 파일을 생성하는데, 존재한다면 덮어씌운다.
			
			write.write("apple");
			write.write("\n"); // 줄바꿈 (Carriage Return)
			write.write("호랑이");
			
			// Close
			write.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println(2);
	}
}
*/

/*
//ex76) finally 사용법 및 사용이유
public class Hello {
	static int m1() {
		return 100;
	}
	
	// 2. finally를 사용하는 이유 
	static void m2(int a, int b) {
		System.out.println("호랑이1");
		if(a > b) {
			System.out.println("호랑이2");
		} else {
			return; // 호랑이3을 출력하지 않는다.
		}
		System.out.println("호랑이3"); // return으로 인해 출력되지 않는다.
	}
	static void m3(int a, int b) {
		try {
			System.out.println("호랑이1");
			if(a > b) {
				System.out.println("호랑이2");
			} else {
				return; // 무조건 finally 쪽으로 가게 되어있다.
						// 호랑이3이 출력되게 된다.
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			System.out.println("호랑이3"); // return을 거쳐도 출력되게 된다.
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println(m1());
		
		try {
			System.out.println(2 / 0);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("catch"); // 출력됨
		} finally { // 쓸 수도 있고, 안쓸 수도 있음
			// catch에 들어가든, 들어가지않든, 무조건 실행
			// => 그럼 try 외부에 선언한 것과 같지 않는가? 
			// => m2, m3 차이
			System.out.println("finally"); // 출력됨
		}
		System.out.println("출력"); // 출력됨
		
	}
}
*/

/*
//ex75) Exception 발생시키는 표준 메소드
public class Hello {
	public static void main(String[] args) {

		for (int i = 0; i < 4; i++) {
			System.out.println(i);
			// 자체적으로 Exception을 발생시킨다. == try/catch가 필요하다.
			// 보통 단줄 처리한다.
			try { Thread.sleep(1000); } catch (Exception e) {} // 1000 ms == 1초
		
		}
			
	}
}
*/

/*
//ex74) throw 사용법
class Tiger{
	// 방법 1
	void f1() {
		System.out.println("함수 1");
		
		try {
			throw new Exception(); // Exceiption을 발생시키는 코드
			// throw로 Exceiption을 발생시키면 반드시 받아주는 코드가 있어야 함.
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	// 방법 2 : Exception 떠넘기기 (주로 사용한다. 다뤄야할 Exception의 종류가 많으므로 호출한 쪽에서 제어하도록 한다.)
	// 함수를 호출한 곳에서 Exception을 받도록 한다.
	// 발생하는 Exception의 종류가 다양하므로, 한 함수에서 모든 Exception을 제어하기 보단, 호출한 쪽에서 제어하도록 한다.
	void f2() throws Exception {
		System.out.println("함수 2");
		
		throw new Exception();
	}
}
public class Hello {
	public static void main(String[] args) throws Exception { // main Exception은 운영체제가 받는다. (잘 사용 X : 보통 어떻게 다룰지 생각하고 사용한다.)
		Tiger t1 = new Tiger();
		
		// 1. Exception 발생시키기
		t1.f1();
		System.out.println("호랑이");

		// 2. Exception 떠넘기기
		// Unhandled exception
//		t1.f2(); // Exception을 받아줄 코드가 필요하다.
		
		// try/catch로 받아준다.
		try {
			t1.f2(); // Exception을 받아줄 코드가 필요하다.
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("발생");
		}
		System.out.println("호랑이2");
		
		// 3. main Exception
		// Exception은 어떻게 다룰지 미리 생각하기 때문에, 잘 사용하지 않는다.
	}
}
*/

/*
//ex73) Exception과 try / catch 사용법
// 실제로 try / catch를 사용하지는 않는다.
public class Hello {
	public static void main(String[] args) {

		// Exception : 에러가 발생했으니 그에 맞게 개발자가 대응하라는 의미 (프로그램을 종료하라는 의미 X)
		
		// 1-1. ArrayIndexOutOfBoundsException
		int[] ar = new int[3]; // 0 1 2
		System.out.println("사자1"); // 출력 됨
//		ar[3] = 10; // 에러 : java.lang.ArrayIndexOutOfBoundsException
		// Exception이 발생하면 프로그램이 중단된다.
		System.out.println("사자2"); // 출력 안됨
		
		// 1-2. Exception을 다루는 방식
		System.out.println("호랑이1"); // 출력 됨
		try {
			// Exception이 발생할 가능성이 있는 코드
			ar[3] = 10; // 에러 : java.lang.ArrayIndexOutOfBoundsException
		} catch (Exception e) {
			// TODO: handle exception
			// Exception이 발생하면 catch문으로 들어오게 된다.
			System.out.println("발생"); // 출력 됨
			e.printStackTrace(); // Exception이 발생한 이유 출력
		}
		System.out.println("호랑이2"); // 출력 안됨
		
		
		
		// 2-1. ArithmeticException
//		System.out.println(5 / 0); // 에러 : java.lang.ArithmeticException
		System.out.println("독수리1"); // 출력 안됨 
		
		// 2-2.
		try {
			System.out.println(5 / 0);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("발생"); // 출력 됨
		}
		System.out.println("고양이"); // 출력 됨
		
		
		
		// 3-1. NullPointerException
		String s = null;
//		s.length(); // 에러 : NullPointerException
		
		// 3-2. 
		try {
			s.length();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("발생");
		}
		System.out.println("강아지");
		
		// 4. 방어적인 프로그램
		// 장점 : 미래지향적, 안정적
		// 단점 : 코드가 길어진다.
		if( s != null ) { // 만일을 대비해 조건을 걸어준다.
			s.length();
		}
	}
}
*/

/*
//ex72)
interface Aaa{
	void f1();
}
interface Bbb{
	void f1(int num);
}
interface Ccc{
	int f1();
}
interface Ddd{
	String f1(String s, int n);
}
public class Hello {
	public static void main(String[] args) {
		
		// 1. 인수를 사용하지 않는 람다 함수
		Aaa t1 = ()->{
			System.out.println(1);
		};
		t1.f1();

		// 2. 인수를 사용하는 람다 함수
		Bbb t2 = (n)->{
			System.out.println(n);
		};
		t2.f1(100);
		
		// 3. 리턴이 있는 람다 함수
		Ccc t3 = ()->{
			return 200;
		};
		System.out.println(t3.f1());
		
		// 4. 인수와 리턴이 있는 람다 함수
		Ddd t4 = (s, n)->{
			return s + n;
		};
		System.out.println(t4.f1("호랑이", 3000));
		
		// 5. 리턴 코드 1줄만 있는 경우, return과 {}를 생략할 수 있다. (별개만 생략 X)
		Ccc t5 = ()-> 200;
		System.out.println(t5.f1());
		
		Ddd t6 = (s, n)-> s + n;
		System.out.println(t6.f1("맘모스", 4000));
	}
}
*/

/*
//ex71)
interface Tiger{
	void f1();
}

class Lion{
	// 원래 인터페이스는 생성이 안되지만(Tiger t = new Tiger() X), 익명으로 만들어서 전달하라는 의미 (다형성)
	void f1(Tiger t) { 
		t.f1();
	}
}
public class Hello {
	public static void main(String[] args) {
		
		Lion lion = new Lion();
//		lion.f1(); // 에러가 난다.
		
		lion.f1(new Tiger() { // 익명 클래스로 만들어서 추상 메소드를 정의해서 전달하게 되면 사용가능 (다형성)
			
			@Override
			public void f1() {
				// TODO Auto-generated method stub
				System.out.println("호랑이");
			}
		});
		
		lion.f1(new Tiger() { // 실행 시 이전과 다른 값을 전달하여 결과값을 얻을 수 있다.(다형성)
			
			@Override
			public void f1() {
				// TODO Auto-generated method stub
				System.out.println("독수리");
			}
		});

		Tiger t1 = new Tiger() {
			@Override
			public void f1() {
				// TODO Auto-generated method stub
				System.out.println("앵무새");
			}
		};
		
		// 위 코드의 약식 표기법 : 람다 함수
		Tiger t2 = ()->{ // -> : 애로우
			System.out.println("앵무새");
		};
		
		// 첫 코드의 람다 함수 사용 예시
		lion.f1(()->{
			System.out.println("앵무새");
		});
		
	}
}
*/

/*
//ex70)
interface Tiger {
	void f1();
}
class Lion implements Tiger{
	public void f1() {}
}
public class Hello {
	public static void main(String[] args) {
		// 객체를 생성시킬 수 없다.
		
		// 인터페이스 사용1
		Lion t1 = new Lion();
		Tiger t2 = new Lion(); // 업캐스팅
		
		// 인터페이스 사용2
//		Tiger t3 = new Tiger(); // 원래 사용할 수 없음
		
		// 익명 클래스를 사용해서 추상 클래스를 구현하면, 인터페이스를 사용할 수 있다.
		Tiger t3 = new Tiger() {
			
			@Override
			public void f1() {
				System.out.println("호랑이");
			}
		
		};
		t3.f1();
		
		// 인터페이스 사용3 : 사용2에서 선언부분 제거
		// 익명 객체
		new Tiger() {
			@Override
			public void f1() {
				// TODO Auto-generated method stub
				System.out.println("앵무새");
			}
		}.f1(); // 즉시 실행 함수
		
	}
}
*/

/*
//ex69) 의존 주입(DI)
// Aaa와 Bbb는 서로 의존적이고, Bbb와 Ccc는 서로 의존적이다.
class Aaa{
	Bbb bbb;
	Aaa(Bbb bbb){ // 주입
		this.bbb = bbb;
	}
	void f2() {
		bbb.f1();
	}
}

interface Bbb{
	void f1();
}

class Ccc implements Bbb{
	public void f1() { System.out.println("의존 주입"); }
}

public class Hello {
	public static void main(String[] args) {
		
		Aaa t = new Aaa(new Ccc());
		t.f2();
		
	}
}
*/

/*
//ex68)
class Baduk{
	Baduk(){
		System.out.println("대국을 시작합니다.");
	}
	void play(Ai ai) {
		ai.play();
	}
	void stop(Ai ai) {
		ai.stop();
	}
	
	// 함수는 되도록 인수전달을 줄인다.
	// 함수의 인수전달을 줄이기 위해 필드 생성
	Ai ai;
	// 생성자는 주입(injection)을 받고 있다.
	Baduk(Ai ai){
		this.ai = ai;
		System.out.println("대국을 시작합니다.");
	}
	void play() {
		ai.play();
	}
	void stop() {
		ai.stop();
	}
}

interface Ai{
	void play();
	void stop();
}

//아마존
class AlphaGo implements Ai{
	public void play() {
		System.out.println("인공지능은 알파고입니다.");
	}
	public void stop() {
		System.out.println("알파고가 점수를 계산합니다.");
	}
}
//마이크로소프트
class BetaGo  implements Ai{
	public void play() {
		System.out.println("인공지능은 베타고입니다.");
	}
	public void stop() {
		System.out.println("베타고가 점수를 계산합니다.");
	}
}

public class Hello {
	public static void main(String[] args) {
		
		Baduk baduk = new Baduk();
		// 객체를 계속 생성할 필요 없지만, 그냥 넘어가도록 한다.
		baduk.play(new AlphaGo());
		baduk.play(new BetaGo());
		baduk.stop(new AlphaGo());
		baduk.stop(new BetaGo());
		
		System.out.println("------");

		Baduk baduk1 = new Baduk(new AlphaGo());
		baduk1.play();
		baduk1.stop();
		
		System.out.println("------");
		
		Baduk baduk2 = new Baduk(new BetaGo());
		baduk2.play();
		baduk2.stop();
		
	}
}
*/

/*
//ex67-3) 미구현 클래스(Ai)가 존재하는 것이 문제 -> 추상화
class Baduk{
	Baduk(){
		System.out.println("대국을 시작합니다.");
	}
	// 업캐스팅 다형성을 이용해서 함수를 하나로 통일한다.
	void play(Ai alphaGo) {
		alphaGo.play();
	}
}

//class Ai{
//	void play() {};
//}
// 추상 클래스화
//abstract class Ai{
//	abstract void play();
//}
// 인터페이스화
interface Ai{
	void play();
}

//아마존
class AlphaGo implements Ai{
	public void play() {
		System.out.println("인공지능은 알파고입니다.");
		
	}
}
//마이크로소프트
class BetaGo  implements Ai{
	public void play() {
		System.out.println("인공지능은 베타고입니다.");
		
	}
}

public class Hello {
	public static void main(String[] args) {
		
		Baduk baduk = new Baduk();
		baduk.play(new AlphaGo());
		baduk.play(new BetaGo());
	}
}
*/

/*
//ex67-2) 다른 인공지능으로 수정될 때마다 클래스에 함수를 추가해야 한다.
class Baduk{
	Baduk(){
		System.out.println("대국을 시작합니다.");
	}
	void play(AlphaGo alphaGo) {
//		System.out.println("인공지능은 알파고입니다.");
		alphaGo.play();
	}
	void play(BetaGo betaGo) {
//		System.out.println("인공지능은 알파고입니다.");
		betaGo.play();
	}
}
// 아마존
class AlphaGo{
	void play() {
		System.out.println("인공지능은 알파고입니다.");
		
	}
}
// 마이크로소프트
class BetaGo{
	void play() {
		System.out.println("인공지능은 베타고입니다.");
		
	}
}

public class Hello {
	public static void main(String[] args) {
		
		Baduk baduk = new Baduk();
		baduk.play(new AlphaGo());
		baduk.play(new BetaGo());
	}
}
*/

/*
//ex67-1) 인공지능이 수정된 경우
class Baduk{
	Baduk(){
		System.out.println("대국을 시작합니다.");
	}
	void play() {
		System.out.println("인공지능은 알파고입니다.");
	}
}

public class Hello {
	public static void main(String[] args) {
		
		Baduk baduk = new Baduk();
		baduk.play();
	}
}
*/

/*
//ex66) Final
class Tiger{
	// 1. 필드 Final( 값을 초기화하는 곳이 여기가 마지막이다.) = 상수화
	// const
	final int NUM = 10;
	void f1() {
//		this.NUM = 20; // 에러 : final로 인해 값 초기화 할 수 없음
	}
	
	// 1-2. 필드에서 초기화하지 않은 경우, 생성자에서 초기화 가능하다.
	final int NUM1;
	Tiger() {
		this.NUM1 = 20; // 필드에서 초기화하지 않아서 초기화 가능하다.
	}
	
	// 1-3. final 변수는 일반적으로 대문자로 써준다.
}

// 2. 클래스 Final
class Aaa{
	
}
// final 클래스의 경우 더이상 상속할 수 없다.
final class Bbb extends Aaa{
	
}
//class Ccc extends Bbb{ // final 클래스에 의해서 상속받을 수 없음
//	
//}

// 2-2. 표준 클래스 상속 여부
//class Ddd extends String {} // final로 인해 상속 받을 수 없음
class Eee extends Thread {} // 상속 받을 수 있음

// 3. 오버라이딩 fianl
// 상속하는 클래스에 함수가 너무 많아서 중복되는 함수명이 발생할 경우를 대비한다.
class Fff{
	final void f1() {} // fianl 메소드는 오버라이딩 안된다.
	void f2() {
		f1(); // 자신의 메소드여서 사용가능
	}
}
class Ggg extends Fff{
//	void f1() {}	// final에 의해서 오버라이딩할 수 없다.
}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
//		t1.num = 20; // 에러 : final로 인해 값 초기화 할 수 없음
//		Math.PI = 20; // 에러
		
	}
}
*/

/*
// ex65-2) 인터페이스가 없어도 되는 클래스여도 추가하는 이유
//굳이 안만들어도 되지만, 추후 업캐스팅할 경우를 위해서 미리 추가한다.
interface ParentsTiger{ 
	void f1();
}

class Tiger implements ParentsTiger{
	public void f1() {
		
	}
}
class Lion implements ParentsTiger{
	public void f1() {
		
	}
}
*/

/*
//ex65)
class Aaa{
	void f1() {}
}
interface Bbb{
	void f2();
}
interface Ccc{
	void f3();
}

// 인터페이스는 다중 상속이 가능하다.
class Ddd extends Aaa implements Bbb, Ccc{
	@Override
	public void f2() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void f3() {
		// TODO Auto-generated method stub
		
	}
}

@FunctionalInterface // 해당 인터페이스에는 미구현 메소드가 1개 있다. (2개 이상일 경우, 에러가 뜸)
interface Eee{
	void f1();
}

public class Hello {
	public static void main(String[] args) {
		
		String s; // 인터페이스 5개 
		Thread th; // 인터페이스 1개
		StringBuffer sb; // 상속 1개, 인터페이스 3개
	}
}
*/

/*
//ex64)
// 인터페이스 예시1 : 클래스로 구현한 인터페이스
// 단, 클래스는 다중 상속이 안된다.
abstract class Aaa{
	// 아래의 함수들을 반드시 구현하도록 명시
	abstract void f1(); // 인터페이스 : 실질적인 내용은 없지만, 해당 틀을 바탕으로 구현하세요.
	abstract void f2();
}
class Bbb extends Aaa{
	@Override
	void f1() {
		// TODO Auto-generated method stub
		
	}
	@Override
	void f2() {
		// TODO Auto-generated method stub
		
	}
}

//인터페이스 예시2
abstract class 스마트폰{
	// 아래의 함수들을 반드시 구현하도록 명시
	abstract void 메세지(); // 인터페이스 : 실질적인 내용은 없지만, 해당 틀을 바탕으로 구현하세요.
	abstract void 전화();
}
class 안드로이드 extends 스마트폰{
	@Override
	void 메세지() {
		// TODO Auto-generated method stub
		
	}
	@Override
	void 전화() {
		// TODO Auto-generated method stub
		
	}
}

// 인터페이스 예시3
// 다중 상속이 가능하다.
interface Ccc{
	// 아래의 함수들을 반드시 구현하도록 명시
	void f1(); // abstract를 생략해도 됨
	void f2();
}
class Ddd implements Ccc{ // 인터페이스는 상속이 아닌 구현으로 표기한다.
	public void f1() { // 인터페이스 메소드는 앞에 public을 붙인다.
		
	}
	public void f2() {
		
	}
}

public class Hello {
	public static void main(String[] args) {
		
	}
}
*/

/*
//ex63)
public class Hello {
	public static void main(String[] args) {
		
		int a = 23;
		
		System.out.println(a * 800); // a를 800번 더한다.
		System.out.println(800 * a); // 800을 a번 더한다. -> a의 값에 따라서 성능이 달라진다.
		System.out.println((a << 9) + (a << 8) + (a << 5)); // 위보다 800배 빠르다.
		
		// 만약, 비트가 겹치는 값이 없을 경우, + 대신 |를 사용하는게 더 빠르다. ( 예시 : Integer.reverseBytes() )
		// 아래 예제는 +의 결과값(18400)과 |의 결과값(16352)이 달라서 +를 |로 대체하지 못한다.
		System.out.println((a << 9) | (a << 8) | (a << 5));
		
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				
				System.out.println(a * 800); // a를 800번 더한다.
				System.out.println(800 * a);
				System.out.println((a << 9) + (a << 8) + (a << 5)); // 성능이 가장 빠르다.
				
			}
		}
		

		
	}
}
*/

/*
//ex62)
public class Hello {
	
	static String hexaToBinary(int n) {
		String s = Integer.toBinaryString(n);
		
		while(s.length() < 32)
			s = "0" + s;
		
		StringBuffer sb = new StringBuffer(s);
		for (int i = 0; i < 7; i++)
			sb.insert((7 - i) * 4, " ");

		return sb.toString();
	}
	
	public static void main(String[] args) {
		int n1 = 0x1234abcd;
		// 1. & : 내가 원하는 특정 정보만 걸러서 얻고 싶은 경우 주로 사용
		System.out.println(n1 & 0xFFFF0000); // 305397760
		System.out.println(hexaToBinary(n1)); // 0001 0010 0011 0100 1010 1011 1100 1101
		System.out.println(hexaToBinary(0xFFFF0000)); // 1111 1111 1111 1111 0000 0000 0000 0000 (마스크 데이터)
		System.out.println(hexaToBinary(n1 & 0xFFFF0000)); // 0001 0010 0011 0100 0000 0000 0000 0000

		// 2. | : 데이터 bit끼리 합성 시 주로 사용 
		System.out.println(n1 | 0xFFFF0000); // -21555
		System.out.println(hexaToBinary(n1)); // 0001 0010 0011 0100 1010 1011 1100 1101
		System.out.println(hexaToBinary(0xFFFF0000)); // 1111 1111 1111 1111 0000 0000 0000 0000 (마스크 데이터)
		System.out.println(hexaToBinary(n1 | 0xFFFF0000)); // 1111 1111 1111 1111 1010 1011 1100 1101
		
		// 2-2. | 예제
		int a = 0xF3;
		int b = 0x3600;
		int c = 0xEC0000;

//		int a = 0x000000F3;
//		int b = 0x00003600;
//		int c = 0x00EC0000;
		
		int d = a | b | c;
		System.out.println(hexaToBinary(d)); // 0000 0000 1110 1100 0011 0110 1111 0011
											 // 0    0    E    C    3    6    F    3
		System.out.println("------");
		
		// 3. 비트 연산
		int e = 0xf09;
		
		// 3-1. <<
		System.out.println(hexaToBinary(e << 4)); // 0000 0000 0000 0000 1111 0000 1001 0000
		System.out.println(hexaToBinary(e)); 	  // 0000 0000 0000 0000 0000 1111 0000 1001
		System.out.println(hexaToBinary(e >> 4)); // 0000 0000 0000 0000 0000 0000 1111 0000

		System.out.println("------");
		
		// 3-2. >>
		System.out.println(hexaToBinary(e << 1)); // 0000 0000 0000 0000 0001 1110 0001 0010
		System.out.println(hexaToBinary(e)); 	  // 0000 0000 0000 0000 0000 1111 0000 1001
		System.out.println(hexaToBinary(e >> 1)); // 0000 0000 0000 0000 0000 0111 1000 0100
		
		System.out.println("------");
		
		// 3-3. 특정 비트 가져오기 (&)
		int data = 0xabcd;
		System.out.println(hexaToBinary(data)); 	   // 0000 0000 0000 0000 1010 1011 1100 1101
													   // 0000 0000 0000 0000 0000 0000 0001 1111 (마스킹 데이터)
		System.out.println(hexaToBinary(data & 0x1f)); // 0000 0000 0000 0000 0000 0000 0000 1101
		System.out.println(data & 0x1f);   	           // 13
		
		System.out.println( (data & 0x7e0) >> 5);	   // 30
		
		System.out.println(hexaToBinary(0x7e0));
		
		System.out.println("---");
		System.out.println(hexaToBinary(0x0000f800));
		System.out.println(hexaToBinary((data & 0x0000f800 >> 11)));
		System.out.println((data & 0x0000f800 >> 11));
		
		System.out.println("---");

		// 3-4. 비트 반전 (~)
		System.out.println(hexaToBinary(data));
		System.out.println(hexaToBinary(~data));
		
		System.out.println("---");
		
		// 3-5. 비트 XOR (^)
		// 주로 영상처리에서 반전시킬 때 많이 사용됨
		System.out.println(hexaToBinary(data));
		System.out.println(hexaToBinary(0x0000ffff));
		System.out.println(hexaToBinary(data^0x0000ffff));
	}
}
*/

/*
// ex61)
class Tiger {
	
}

public class Hello {
	
	static String hexaToBinary(int n) {
		String s = Integer.toBinaryString(n);
//		System.out.println(s); // 1100011110011100111101111001101
//		System.out.println(s.length()); // 31
		
		// 32bit에 해당하는 문자열을 만드는 작업
		while(s.length() < 32) {
			s = "0" + s; // s는 새로 만들어지는 객체
		}
//		System.out.println(s.length()); // 32
//		System.out.println(s); // 01100011110011100111101111001101
		
		StringBuffer sb = new StringBuffer(s);
//		System.out.println(sb); // 01100011110011100111101111001101
		
		// StringBuffer : insert(" ")
		// String에서는 데이터 자체를 변형하지 않기 떄문에 insert가 없음		
		for (int i = 0; i < 7; i++) {
//			System.out.println((7 - i) * 4);
			sb.insert((7 - i) * 4, " ");
		}
//		System.out.println(sb); // 0110 0011 1100 1110 0111 1011 1100 1101

		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		// 내가 원하는 포맷으로 2진수 출력
		int num = 0x63CE7BCD;
		System.out.println(hexaToBinary(num)); // 0110 0011 1100 1110 0111 1011 1100 1101

		System.out.println(hexaToBinary(0xab)); // 0000 0000 0000 0000 0000 0000 1010 1011

		int num2 = 100;
		System.out.println(hexaToBinary(num2)); // 0000 0000 0000 0000 0000 0000 0110 0100
		// 실제 메모리에서 전구가 어떻게 꺼지고 켜지는 지 2진법을 통해 알 수 있다.
		
		System.out.println(hexaToBinary(0x7fffffff)); // 0111 1111 1111 1111 1111 1111 1111 1111
		
		System.out.println(hexaToBinary(0x80000000)); // 1000 0000 0000 0000 0000 0000 0000 0000

	}
}
*/

/*
//ex60) 16진법
class Tiger {

}

public class Hello {
	public static void main(String[] args) {
		
		int num1 = 100;
		System.out.println(num1); // 100
		
		int num2 = 0x100; // 0x : 16진법 표기
		System.out.println(num2); // 256
		
		int num3 = 0xABCD;
		System.out.println(num3); // 43981
		
		// 16진수는 4자리, 각 자리마다 0, 1만 들어갈 수 있다.
		// 따라서, 각 자리는 1bit, 16진수 1개는 4bit
		// 
		// int는 최대 4byte 이므로, 4byte를 넘을 수 없다. (FF FF FF FF)
		int num4 = 0x63ce7bcd;
		System.out.println(num4); // 1674476493
		
		// 0 ~ 80 00 00 00(16진법 중간) ~ FF FF FF FF
		System.out.println(Integer.toBinaryString(num4)); // 16진수로 만들어진 문자열을 2진수로 반환
		// 1100011110011100111101111001101
		
		int num5 = 0xab;
		System.out.println(Integer.toBinaryString(num5));
		// 10101011
		// 0000 0000 0000 0000 0000 0000 1010 1011 (자주 사용하게 되는 표현)
		
	}
}
*/

/*
//ex59) 진법( bit 연산 ) : 2(컴), 10(사람), 16(컴, 사람 절충)
class Tiger {
	// 16진법
	// 10 = a
	// 11 = b
	// 12 = c
	// 13 = d
	// 14 = e
	// 15 = f
}

public class Hello {
	public static void main(String[] args) {
		
		Tiger t1 = new Tiger();
		
	}
}*/

/*
//ex58) String 유용한 함수의 사용법
class Tiger {

}

public class Hello {
	public static void main(String[] args) {
		
		String s1 = "무궁화꽃이피었습니다"; // '무' = index 0
		
		// 1. int java.lang.String.length()
		System.out.println(s1.length()); // 문자열 길이를 반환값으로 출력할 수 있다.
		
		// 2. char java.lang.String.charAt(int index)
		System.out.println(s1.charAt(3)); // 해당하는 인덱스 값을 불러온다.
		
		// 3. int java.lang.String.indexOf(String str) 
		System.out.println(s1.indexOf("이피었")); // 문자열을 검색해서 인덱스 값을 불러온다.
		
		// 3-2.
		System.out.println(s1.indexOf("섭니다")); // 검색 실패 시 음수 혹은 -1을 반환한다.
		
		// 3-2. 예제
		if(s1.indexOf("섭니다") == -1) {
			System.out.println("검색실패");
		}else {
			System.out.println("검색성공");
		}
		
		// 4.
		// 클래스 사용 시 원본 데이터를 변경하는지 꼭 확인할 것
		// String replace(
		//		CharSequence target, 
		//		CharSequence replacement
		// )
		String s2 = s1.replace("꽃이", "나무가"); // String 클래스는 원본 데이터를 절대 변경하지 않는다.
		System.out.println(s1);
		s1 = "호랑이"; // s1의 메모리가 삭제된 후(객체 삭제), 재할당을 받는다(객체 생성). 즉, 원본 데이터가 변경된 것이 아니다.
		System.out.println(s1);
		
		// 만약, 원본을 변경하고 싶다면, StringBuffer 클래스를 이용해야한다.
		System.out.println(s2);
//		System.out.println(s1.replace("꽃이", "식물이"));
		
		// 5. String java.lang.String.substring(int beginIndex)
		s1 = "무궁화꽃이피었습니다";
		System.out.println(s1.substring(3));
		System.out.println(s1.substring(3, 5)); // start ~ (end -1)
		// 3, 4로 표현하지 않고, 3, 5로 표현하는 이유
		// 코드 내부적으로 잘라낸 개수를 계산할 때를 위해서 
		// (end - start + 1로 계산하지 않고, end - start 로 바로 계산할 수 있다.)
		
		// 6. 대소문자 변경
		// 단어 검색을 위해서 대소문자를 통일시키는 경우에도 사용 (Apple, apple, aPPLe)
		s1 = "Apple";
		System.out.println(s1.toLowerCase());
		System.out.println(s1.toUpperCase());
		
		// 7. 공백 제거
		s1 = "  A p p l e  ";
		System.out.print(s1);
		System.out.println(1000);
		System.out.print(s1.trim()); // 앞뒤 공백을 제거한다. "A p p l e"
		System.out.println(2000);
						
	}
}
*/

/*
//ex57)
// 4. 추상함수를 가지는 클래스는 반드시 추상클래스 이어야 한다.
abstract class Aaa {
	// 1. 오버라이딩을 목표로 작성된 메소드이지만,
	// 2. 부모 메소드에는 작성할 생각이 없는 경우
	// 3. 스코프를 제거하고 세미콜론을 찍는 순간 미완성 코드(추상)가 된다.
	abstract void f1();
}
class Bbb extends Aaa{
	
	// 5. 상속 받은 클래스는 반드시 완성시켜야 한다.
	@Override
	void f1() {
		System.out.println(1);
	}
}

public class Hello {
	public static void main(String[] args) {
				
//		Aaa t = new Aaa(); // 추상 클래스는 미완성 클래스이므로 객체를 생성시킬 수 없다.
		// 객체를 생성시키고 싶다면 업캐스팅을 이용해야한다.
		Aaa a = new Bbb();
		a.f1();
		
	}
}
*/

/*
//ex56**중요**) 다형성
class Animal {
	void cry() {System.out.println("소리 내지 못함");}
}
class Tiger extends Animal {
	void cry() {System.out.println("어흥");}
}
class Cat extends Animal {
	void cry() {System.out.println("야옹");}
}
class Dog extends Animal {
	void cry() {System.out.println("멍멍");}
}
class Snake extends Animal {
}
class Zoo {
//	void sound(Tiger t) {
//		t.cry();
//	}
//	void sound(Cat t) {
//		t.cry();
//	}
//	void sound(Dog t) {
//		t.cry();
//	}
//	void sound(Snake t) {
//		t.cry();
//	}

	// 업캐스팅을 활용해서 메소드를 묶을 수 있다.
	// 들어오는 타입의 종류에 따라서 결과가 다양하게 나올 수 있다. (다형성)
	// Animal를 상속받는 새로운 클래스가 추가되어도 sound 메소드는 굳이 수정할 필요가 없다.
	// (개방 폐쇄의 원칙, SOLID 중 OCP)
	void sound(Animal t) {
		t.cry();
	}
}

public class Hello {
	public static void main(String[] args) {
		
		Zoo zoo = new Zoo();
		zoo.sound(new Tiger());
		zoo.sound(new Cat());
		zoo.sound(new Dog());
		zoo.sound(new Snake());
		
	}
}
*/

/*
//ex55)
class Animal {
	void cry() {
		System.out.println("소리를 낼 수 없다.");
	}
}
class Tiger extends Animal {
	@Override
	void cry() {
		System.out.println("어흥");
	}
}
class Cat extends Animal {
	@Override
	void cry() {
		System.out.println("야옹");
	}
}
class Snake extends Animal {
}

public class Hello {
	public static void main(String[] args) {
		
		Random rnd = new Random();
		Tiger t0 = new Tiger();	
		Cat t1 = new Cat();	
		Snake t2 = new Snake();
		
		for (int i = 0; i < 6; i++) {
			
			switch(rnd.nextInt(3)) {
			case 0:
				t0.cry();
				break;
			case 1:
				t1.cry();
				break;
			case 2:
				t2.cry();
				break;
			}
			
		}
		System.out.println("---배열과 업캐스팅을 이용해서 switch 문을 대체할 수 있다.---");
		
//		Animal[] ani = new Animal[3];
//		ani[0] = new Tiger();
//		ani[1] = new Cat();
//		ani[2] = new Snake();
		
		Animal[] ani = new Animal[] {new Tiger(), new Cat(), new Snake()};
		for (int i = 0; i < 6; i++) {
			ani[rnd.nextInt(3)].cry();
		}
		
	}
}
*/

/*
//ex54)
class Animal {
	void cry() {
		System.out.println("소리를 낼 수 없다.");
	}
}
class Tiger extends Animal {
	@Override
	void cry() {
		System.out.println("어흥");
	}
}
class Cat extends Animal {
	@Override
	void cry() {
		System.out.println("야옹");
	}
}
class Snake extends Animal {
}


public class Hello {
	public static void main(String[] args) {
		
		Animal t1 = new Tiger();
		t1.cry();
		Animal t2 = new Cat();
		t2.cry();
		Animal t3 = new Snake();
		t3.cry();

		
		Tiger t4 = new Tiger();
		t4.cry();
		Cat t5 = new Cat();
		t5.cry();
		Snake t6 = new Snake();
		t6.cry();
		
		
//		String s0, s1, s2, s3;
//		s0 = "호랑이";
//		s1 = "호랑이";
//		s2 = "호랑이";
//		s3 = "호랑이";
		
//		String[] ar = new String[4]; // 객체가 실제로 생성된 것이 아니라, 객체를 생성할 수 있는 변수 4개를 만든 것
//		ar[0] = "호랑이0";
//		ar[1] = "호랑이1";
//		ar[2] = "호랑이2";
//		ar[3] = "호랑이3";
		
		String[] ar = new String[] {"호랑이0", "호랑이1", "호랑이2", "호랑이3"}; // 객체가 실제로 생성된 것이 아니라, 객체를 생성할 수 있는 변수 4개를 만든 것
		for (int i = 0; i < ar.length; i++) {
			System.out.println(ar[i]);
		}
		
//		Test[] br = new Test[4]; // 객체가 실제로 만들어진 것이 아니라, 클래스를 받을 수 있는 변수가 4개 만들어진 것
//		br[0] = new Test();
//		br[1] = new Test();
//		br[2] = new Test();
//		br[3] = new Test();
		
		Test[] br = new Test[] {new Test(), new Test(), new Test(), new Test()};
		for (int i = 0; i < br.length; i++) {
			br[i].f1();
		}
	}
}

class Test {
	void f1() { System.out.println(1); }
}
*/

/*
//ex53) 업캐스팅 사용
class Aaa {
	void f1() {}
	void f3() { // 업캐스팅된 경우, 스코프{}에 들어오기 전, 자식에 오버라이딩 되어있는지 확인하고 선택적으로 수행한다.
		System.out.println(10);
	}
	void f4() {
		System.out.println(20);
	}
}
class Bbb extends Aaa {
	void f2() {}
	void f4() {
		System.out.println(40);
	}
}

public class Hello {
	public static void main(String[] args) {
		
		Aaa t = new Bbb();
		t.f3(); // 스코프{}에 들어오기 전, 자식에 오버라이딩 되어있는지 확인하고 선택적으로 수행한다.
		t.f4(); // 오버라이딩 되어 자식의 f4()를 실행하게 된다.
		
		Bbb t2 = new Bbb();
		t.f3();
		t.f4();
	}
}
*/

/*
//ex52 **중요**) 다형성, 업캐스팅
class Aaa {
	void f1() {}
}
class Bbb extends Aaa {
	void f2() {}
}

public class Hello {
	public static void main(String[] args) {
		
		// (왼쪽)문법의 범위 지정 = (오른쪽)메모리 사용 범위 지정
		
		// 1. 부모 = 부모
		// 상속과 관계가 없다.
		Aaa t1 = new Aaa();
		t1.f1();
		
		// 2. 부모 = 자식
		// 업 캐스팅
		Aaa t2 = new Bbb();
		t2.f1(); // f2() 메모리가 있지만 사용할 순 없다.
		
		// 3. 자식 = 부모
		// 다운 캐스팅 -> 자바 지원 X
		// 문법적으로는 Aaa와 Bbb의 코드를 사용할 수 있지만, 
		// 실제로 메모리엔 Aaa 밖에 없으므로 Bbb의 문법을 사용하려고 하면 터지게 된다.
//		Bbb t3 = new Aaa();
		
		// 4. 자식 = 자식
		Bbb t4 = new Bbb();
		t4.f1();
		t4.f2();
		
	}
}
*/

/*
//ex51)
class Tiger {
	int num;
	int age;
	Tiger(){
		age = 10000; // 어떤 생성자를 호출하든 age는 10000이 된다.
		System.out.println(1);
	}
	Tiger(int a){
		this(); // 다른 생성자를 이용하고 싶은 경우, 반드시 코드 첫 줄에 나와야한다.
		num = a;
		System.out.println(2);
	}
	Tiger(int b, int c){
		this(b * c); // 다른 생성자를 이용하고 싶은 경우, 반드시 코드 첫 줄에 나와야한다.
		System.out.println(3);
	}
}

public class Hello {
	public static void main(String[] args) {
		
		Tiger t1 = new Tiger(10);
		Tiger t2 = new Tiger(2, 3);
		
	}
}
*/

/*
//ex50)
// 모든 클래스는 Object 클래스를 상속받는다.
// 즉, 모든 클래스는 자식 클래스이다.
// 생략되어 있어서 안보인다.
//class Aaa extends Object{
//	
//}

class Aaa {
	void f1() {}
}
class Bbb extends Aaa {
	void f2() {}
}
class Ccc extends Bbb {
	void f3() {}
	void f4() {}
}

public class Hello {
	public static void main(String[] args) {
		
		// 상속 계층 보는 단축키 : F4
		Ccc t1 = new Ccc();
		
		String s;
		
	}
}
*/

/*
//ex49) this 사용법 4
// 생성자가 호출되는 실행순서 : 부모 > 자식 <=== 잘못된 해석
//  - 자식의 생성자가 먼저 호출되고 생성자 내부에서 가장 먼저 부모 생성자를 호출하는 생략된 코드가 실행된다.
class Aaa {
	Aaa() {
		System.out.println(1);
	}
	Aaa(int a) {
		System.out.println(1);
	}
	
}

class Bbb extends Aaa {
	Bbb() {
		// 부모 생성자를 콜하는 코드가 생략되어있음.
		// super();
		
		super(100); // 생성자를 선택적으로 사용하는 경우
		System.out.println(2);
	}
	Bbb(int a, int b){
		super();
		System.out.println(4);
	}
}

public class Hello {
	public static void main(String[] args) {
		
		Bbb b1 = new Bbb();
		System.out.println("------");
		Bbb b2 = new Bbb(3, 4);
	}
}
*/

/*
//ex48)
class Aaa { // 조부
	void f1() { System.out.println(1); }
}
class Bbb extends Aaa { // 부모
	
}
class Ccc extends Bbb { // 자식
	
}
class Ddd extends Bbb { // 자식
	
}
public class Hello {
	public static void main(String[] args) {
		
		Ccc t1 = new Ccc();
		
		t1.f1();
		
		
	}
}
*/

/*
//ex47) 상속
class Aaa { // 부모
	void f1() {
		System.out.println(1);
	}
	
	// 함수 원형(prototype) : 스코프를 제외한 함수 부분 ( void f3() )
	void f3() {
		System.out.println(31);
	}
	
	String f5(int a, int b, String t) {
		return null;
	}
}
class Bbb extends Aaa { // 자식
	void f2() {
		System.out.println(2);
	}
	
	// 오버라이딩 : 부모의 함수 원형이 같은 경우
	@Override
	void f3() {
		System.out.println(32);
	}
	
	void f4() {
		f3();
		this.f3();
		super.f3(); // super : 부모
	}
	
	// 오버라이딩
	@Override // 오버라이드한 경우 일반적으로 a notation 표시한다.
	// 만약 함수가 오버라이드되지 않은 경우 에러가 떠서 알려준다.
	String f5(int a, int b, String t) {
		return null;
	}
}

public class Hello {
	public static void main(String[] args) {
		Bbb t1 = new Bbb();
		t1.f1(); // 1
		t1.f2(); // 2
		t1.f3(); // 32, 자식의 f3이 실행된다.
		System.out.println("------");
		
		t1.f4();
	}
}
*/

/*
//ex46-3) this 용법 3
class Man {
	void f1() {
		Women w = new Women();
		boolean result = w.marry(this);
		System.out.println(result ? "^^" : "ㅠㅠ");
	}
	String 성격() {
		return "포악";
	}
}
class Women {
	boolean marry(Man info) {
		String str = info.성격();
		return str == "포악" ? false : true;
	}
}

public class Hello {
	public static void main(String[] args) {
		Man t1 = new Man();
		t1.f1();

		Control con = new Control();
//					   Hello 객체
		con.makeButton(this, "텍스트", "색상"){ // 첫 인수가 this인 경우, 상대방 측에서 내 정보가 필요하다.
			this.칠하다();
		}
	}
	
	void 칠하다() {
		
	}
}
*/

/*
//ex46-2) this 용법 2
class Tiger {
//	Tiger this; // 생략되어져있음
	Tiger f1() {
		System.out.println("아침");
//		return new Tiger();
		return this;
	}
	
	Tiger f2() {
		System.out.println("점심");
		return this;
	}
	
	void f3() {
		System.out.println("저녁");
	}
	
	
}

public class Hello {
	public static void main(String[] args) {
		
		Tiger t1 = new Tiger();
		t1.f1().f2().f3(); // f1()에 의해 t1이 반환되고, 반환된 t1을 다시 체이닝해서 f2()를 호출한다.
		System.out.println("------");
		
		// f1, f2는 t1을 반환해서 체이닝으로 다시 불러올 수 있지만, f3의 경우 반환하지 않아서 체이닝할 수 없다.
//		t1.f1().f1().f2().f1().f3(); // 체이닝의 경우, 줄바꿈으로 구분시켜준다. 
		
		t1.
		f1().
		f2().
		f3();
		
		// 체이닝으로 하지 않을 경우, 각 메소드 간의 관계를 생각하지 않고 이질감 드는 코드를 삽입할 수 있게 된다.
		// 따라서, 흐름을 깨지 않도록 일괄적인 작업을 요구할 때 체이닝을 사용한다. 
		t1.f1();
		System.out.println("끼어들기 가능"); // 쓸데없는 코드
		t1.f2();
		t1.f3();
	}
}
*/

/*
//ex46-1) this 용법 1
// 함수의 전달 인수와 필드를 구분하기 위한 용도 (가독성)
// 자동으로 생성하면 좋은 메소드 : 생성자, getter/setter, toString
class Tiger {
	String name;
	int age;
	
	public Tiger(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
//	Tiger(String name, int age){
//		this.name = name; // 필드 <= 인수
//		this.age = age;
//	}
		
	void f1() {
//		System.out.println(name + " " + age); // 컴파일 시 아래와 같이 this.가 붙게 됨
		System.out.println(this.name + " " + this.age);
	}
	
	void f2() {
		f1();
		this.f1();
	}
	
	void f3(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Tiger [name=" + name + ", age=" + age + "]";
	}
	
	
}

public class Hello {
	public static void main(String[] args) {
		
		Tiger t1 = new Tiger("호랑이", 10);
		System.out.println(t1);
		t1.f3("독수리", 20);
		System.out.println(t1);
		
	}
}
*/

/*
//ex45)
class Lion {
	
}
class Tiger {
	Lion lion;
	Tiger tiger;
	
	Tiger(){
		
//		this = ??? // 생략된 코드, new로 객체 생성 시 ???는 생성한 이름(t1, t2)으로 대체된다.
		System.out.println(this.hashCode()); // 
	}

	//	Tiger this; // 기본적으로 코드가 생략되어 있으며, 따로 작성해줄 수도 없음.
}

public class Hello {
	public static void main(String[] args) {
		
		Tiger t1 = new Tiger(); // 객체 생성 시, 생성자에서 this = t1 코드가 만들어진다.
		System.out.println(t1.hashCode());
		
		Tiger t2 = new Tiger(); // 객체 생성 시, 생성자에서 this = t2 코드가 만들어진다.
		System.out.println(t2.hashCode());
		
	}
}
*/

/*
//ex44)
class Tiger {
	// 객체 생성을 초기에 방지
	private Tiger() {
		
	}
}

public class Hello {
	public static void main(String[] args) {
		// Math의 경우, 객체 생성 비용을 줄이기 위해 대부분 메소드를 static 사용
//		Math m = new Math(); // 따라서, 생성자 자체를 private으로 선언해서 객체 생성을 초기에 방지함
//		m.abs();
		Math.abs(0); // 객체를 생성하지 않아도 사용할 수 있는 static 메소드
		System.out.println(Math.abs(0));
		
//		Thread.sleep(10);
	}
}
*/

/*
//ex43-3)
class Tiger {
	static int count = 0;
	int num = 0;
	Tiger() {
		count++;
		num++;
	}
}

public class Hello {
	public static void main(String[] args) {
		
		Tiger t1 = new Tiger();
		Tiger t2 = new Tiger();
		Tiger t3 = new Tiger();
		
		System.out.println(t1.num);
		System.out.println(t2.num);
		System.out.println(t3.num);
		
		System.out.println("생성된 객체 수는 : " + Tiger.count);
	}
}
*/

/*
//ex43-2)
class Tiger {
	void f1() {
		Tiger t = new Tiger();
	}
}

public class Hello {
	int n1;
	static int n2;
	
	void f1() {}
	static void f2() {}
	
	public static void main(String[] args) {
		
//		f1(); // 메모리에 올라가지 있지 않아 사용할 수 없다.
		f2(); // 메모리에 올라가 있어 사용할 수 있다.
//		n1 = 10;
		n2 = 10;
		Hello h = new Hello();
		h.n1 = 10;
		h.n2 = 20;
		h.f1();
		h.f2();
		
		// 현재, Hello 객체는 1개(main 메소드에서 생성한 객체)
	}
}
*/

/*
//ex43-1)
// static 안에서는 static만 사용할 수 있다.
class Tiger {
	int n1;
	static int n2;
	static void f1() {
		
		// static 메소드의 경우, 내부 필드보다 먼저 메모리에 올라가므로 메모리에 아직 올라가지 않은 멤버필드를 참조할 수 없다.
//		n1 = 100;
		n2 = 200; // static으로 함께 메모리에 올라가므로 접근 가능하다.
		
//		f2(); // 아직 메모리에 올라가지 않아 사용할 수 없다.
		f3(); // static으로 함께 메모리에 올라가므로 사용 가능하다.
	}
	
	void f2() {
		f3(); // static에 의해 f3가 이미 메모리에 올라가므로 사용할 수 있다.
	}
	static void f3() {}
	
}

public class Hello {
	public static void main(String[] args) {
		
		Tiger t1 = new Tiger();
		
	}
}
*/

/*
//ex42-3)
class Tiger {

}

public class Hello {
	
	// 필드와 메소드를 작성해도 아무 문제 없다.
	int age;
	
	Hello() {
		
	}
	
	void f1() {
		
	}
	
	// 진입점(Entry Point)
	// 객체를 생성하지 않아도, static으로 인해 외부로 나와 메모리에 올라간다.
	// 그리고, main 메소드를 OS에서 호출해서 실행하게 된다. ( Hello.main() )
	public static void main(String[] args) {
		
		Tiger t1 = new Tiger();
		
	}
	
	// 필드와 메소드를 작성해도 아무 문제 없다.
	void f2() {
		
	}
}
*/

/*
//ex42-3)
class Tiger {

	// 객체를 여러번 만들어도, 메모리엔 한번만 올려져서 같이 사용한다.
	// 속도를 요구하는 메소드의 경우 static을 이용해서 객체 생성에서 제외시켜, 객체 생성 비용을 줄인다.
	static void f1() {
		
	}
	
	// 객체를 여러번 만들어도, 메모리엔 한번만 올려져서 같이 사용한다.
	void f2(){
		
	}
}

public class Hello {
	public static void main(String[] args) {
		
		// 객체 생성 시 비용이 아주 많이 든다.
		// 따라서, 속도를 요구하는 메소드의 경우 static을 이용해서 객체 생성에서 제외시킨다. 
		Tiger t1 = new Tiger();
		Tiger t2 = new Tiger();
		
	}
}
*/

/*
//ex42-2)
class Tiger {
	// static : 설계도(클래스)가 만들어지게 되면 '1개만' 만들게 됨
	// 컴파일 시 외부로 빠져나가게 됨.
	static int n1;
	int n2;
	
	static void 관제탑() {
		System.out.println("콜");
	}
	void 날다() {
		
	}
}

public class Hello {
	public static void main(String[] args) {
		
		Tiger.관제탑(); // 객체가 없어도 사용 가능
		Tiger t1 = new Tiger();
		t1.날다(); // 객체가 있어야 사용 가능
		t1.관제탑(); // 객체가 있어도 접근 가능
		
		System.out.println(Tiger.n1);
		System.out.println(t1.n2);
	}
}
*/

/*
//ex42-1)
class Tiger {
	private String name;
	private int age;
	
	// getter, setter의 경우 주로 한 줄 처리한다. (한 줄 처리 단축키 : ctrl + alt + j)
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
	
}

public class Hello {
	public static void main(String[] args) {
		
		Tiger t1 = new Tiger();
		
	}
}
*/

/*
//ex42)
// 클래스를 제작하는 사람과 사용하는 사람은 별개
// 클래스를 사용하는 사람은 클래스 내부에 영향을 끼치지 않도록 내부의 필드를 알 수 없게 하는 경우가 일반적
// 따라서, 필드에 직접적으로 접근하지 못하도록 막고, 메소드를 통해서 제어할 수 있도록 한다.
class Tiger {
	// private : 클래스 내부에서만 사용하는 필드 (데이터 은닉)
	// 멤버변수의 경우 대부분 은닉함
	private int age;
	private String name;
	
	void setName(String n) {
		name = n;
	}
	String getName() {
		return name;
	}
	
	// getter, setter 함수
	// 클래스 개발자의 입장에서,
	// private을 사용하지 않을 경우, 내부 필드 접근에 대한 선택권을 가질 수 없지만,
	// private을 사용할 경우, 내부 필드 접근에 대한 선택권을 가질 수 있다.
	// 내부 필드 제어와 관련된 메소드의 경우, 편의를 위해 필드 바로 아래에 작성한다.
	int getAge() {
		return age;
	}
	void setAge(int data) {
		age = data;
	}
	
	Tiger(){
		age = 100;
	}
	
	// f3을 위해 작성된 메소드1
	private void f1() {
		
	}
	// f3을 위해 작성된 메소드2
	private void f2() {
		
	}
	void f3() {
		// f3의 내부를 분리해서 작성한 경우
		f1();
		f2();
	}
}

public class Hello {
	public static void main(String[] args) {
		
		Tiger t1 = new Tiger();
		
		// 멤버필드는 객체를 생성시켜서 직접 사용하는 경우는 거의 없다.
		t1.setAge(1000);
		System.out.println(t1.getAge());
//		t1.money = 200;
		
		
	}
}
*/

/*
//ex41)
class Tiger {
	String name;
	int age;
	
	// 다른 생성자를 작성했지만 디폴트 생성자를 생성하지 않은 경우 에러가 나므로,
	// 디폴트 생성자를 일반적으로 만들어놓고 클래스를 작성함.
	Tiger() {}
	Tiger(int data) {
		name = "익명";
		age = data;
	}
	Tiger(String n, int data){
		name = n;
		age = data;
	}
	
//	void showData() {
//		System.out.println(name + " " + age);
//	}
	@Override
	public String toString() {
		return "Tiger [name=" + name + ", age=" + age + "]";
	}
	
}

public class Hello {
	public static void main(String[] args) {
		
		Tiger t1 = new Tiger(100);
		System.out.println(t1.name + " " + t1.age);
		Tiger t2 = new Tiger("홍길동", 200);
//		t2.showData();
		
		System.out.println(t1.toString());
		System.out.println(t1);
	}
}
*/

/*
//ex40-2)
class Tiger {
	int age = 10;
	Tiger(int data){
		age = data;
	}
}

public class Hello {
	public static void main(String[] args) {
		
		Tiger t1 = new Tiger(100);
		Tiger t2 = new Tiger(200);
		System.out.println(t1.age);
		System.out.println(t2.age);
	}
}
*/

/*
//ex40-1)
class Tiger {
	int age;					 // 초기화방법1 먼저 실행
	Tiger() {					 // 초기화방법2 나중 실행
		System.out.println(1);
		age = 100;
	}
	Tiger(int data) {
		System.out.println(2);
		age = data;
	}
}

public class Hello {
	public static void main(String[] args) {
		
		Tiger t1 = new Tiger();
		System.out.println(t1.age);
		
		Tiger t2 = new Tiger(999);
		System.out.println(t2.age);
		
		
	}
}
*/

/*
//ex39)
// 생성자
// 1. 사용 목적 : 필드 초기화
// 2. 생성자 메소드라 한다.
// 3. 함수의 이름은 반드시 클래스 이름과 동일해야 한다.
// 4. 인수를 전달받을 수 있지만, return은 가질 수 없다.
// 5. 인수전달이 없는 생성자를 디폴트 생성자라고 한다.
// 6. 호출은 new 키워드를 사용할 때, 딱 1번 호출되며, 프로그래머와 임의로 호출할 수 없다.
// 7. 함수이기 때문에 오버로딩이 가능하다.
// 8. 생성자 코드를 작성하지 않으면 자동으로 디폴트 생성자가 작성된다.
//		- 생성자 코드를 작성하게 되면 자동으로 디폴트 생성자가 작성되지 않는다.
class Tiger {
	// 필드
	int age;
	
	// 디폴트 생성자
	Tiger() { // void가 생략됨
		System.out.println("생성자 콜");
		age = 100;
	}
	
	// 메소드
	
	
}

public class Hello {
	public static void main(String[] args) {
		System.out.println(1);
		Tiger t1 = new Tiger(); // 생성자 자동 호출
		System.out.println(2);
		Tiger t2 = new Tiger(); // 생성자 자동 호출
		System.out.println(3);
		
		System.out.println("------");
		for (int i = 0; i < 3; i++) {
			Tiger temp = new Tiger(); // 생성자 자동 호출
			System.out.println(temp.hashCode());
			
		}
	}
}
*/

/*
//ex38-2)오버로딩 예
class Tiger {
	int getRect(int w, int h) {
		return w * h;
	}
	
	int getRect2(int x1, int y1, int x2, int y2){
		int width = x2 - x1 + 1;
		int height = y2 - y1 + 1;
		return width * height;
	}
	int getRect3(int x) {
		return x * x;
	}
	// 굳이 이름을 모두 다르게 할 필요가 없다.
	
	
	int getRect(int x1, int y1, int x2, int y2){
		int width = x2 - x1 + 1;
		int height = y2 - y1 + 1;
		return width * height;
	}
	int getRect(int x) {
		return x * x;
	}
	
	
	int test() {
		return 0;
	}
	float test() {
		return 0.0f;
	}
	// return 타입으로는 오버로딩이 안된다.
	
}

public class Hello {
	public static void main(String[] args) {
		
		Tiger t1 = new Tiger();
		System.out.println(t1.getRect(10, 5));
		
		
	}
}
*/

/*
//ex38-1)
// 오버로딩(Overloading)
class Tiger {
	// 메소드 명을 동일하게 사용할 수 있는 경우
	void showMeTheMoney() {
		System.out.println(1);
	}
	
	// 1. 인수 개수가 다른 경우
	void showMeTheMoney(int i) {
		System.out.println(2);
	}	
	void showMeTheMoney(int a, int b) {
		System.out.println(3);
	}
	
	// 2. 인수 타입이 다른 경우
	void showMeTheMoney(float i) {
		System.out.println(4);
	}		
	void showMeTheMoney(Tiger i) {
		System.out.println(5);
	}	
	void showMeTheMoney(short i) {
		System.out.println(6);
	}	
}

public class Hello {
	public static void main(String[] args) {
		
		Tiger t1 = new Tiger();
		
		t1.showMeTheMoney();
		t1.showMeTheMoney(10);
		t1.showMeTheMoney(10, 20);
		t1.showMeTheMoney(3.14f);
		t1.showMeTheMoney(new Tiger());
		
		float f = 3.0f;
		t1.showMeTheMoney(3.0f); // float으로 간다.
//		t1.showMeTheMoney(3); // int, float, short 중 어디로 갈지 알기 힘들다.
		t1.showMeTheMoney((float)3); // float으로 간다.
		t1.showMeTheMoney((short)3); // short로 간다.
		
		
		
	}
}
*/

/*
//ex37)
class Tiger {
	int number;
}

class Lion {
	Tiger m1(Tiger bbb) {
		System.out.println(bbb.number);
		System.out.println(bbb.hashCode());
		bbb.number = 888;
		return bbb;
	}
}

public class Hello {
	public static void main(String[] args) {
		
		Lion t1 = new Lion();
		Tiger aaa = new Tiger();
		aaa.number = 999;
		System.out.println(aaa.hashCode());
		Tiger ccc = t1.m1(aaa);
		System.out.println(ccc.hashCode());
		// aaa == bbb == ccc, 모두 같다.
	}
}
*/

/*
//ex36)
class Tiger {
	int num = 100;
}

public class Hello {
	public static void main(String[] args) {
		
		Tiger t1 = new Tiger();
		System.out.println(t1.hashCode());
		
		Tiger t2 = new Tiger();
		System.out.println(t2.hashCode());
		
		Tiger t3 = null;
//		System.out.println(t3.hashCode()); // Null Pointer Exception
		
		t3 = t1; // 이름만 다를 뿐, 동일한 메모리를 가리키게 된다.
		System.out.println(t3.hashCode());
		System.out.println(t1.num);
		t1.num = 200;
		System.out.println(t3.num);
	}
}
*/

/*
//ex35)
class Tiger {

}
class Lion {
	// Tiger t = new Tiger();
	
	// 자기 자신을 인수로 넣을 수 있다.
	void m1(int a, String s, Tiger t, Lion l) {
		if(s != null) {
			
		}
	}
	
	Tiger m2() {
		return null;
	}
	
	Tiger m3() {
		return new Tiger();
	}
	
	Tiger m4() {
		Tiger t = new Tiger();
		return t;
	}
	
	Tiger m5(Tiger t) {
		return t;
	}
}

public class Hello {
	public static void main(String[] args) {
		
		Lion t1 = new Lion();
		t1.m1(10, "호랑이", new Tiger(), new Lion());
		t1.m1(10, null, null, null);
	}
}
*/

/*
//ex34)
class Tiger {
	// 인수 전달 : 프리미티브 타입(8) + 클래스(수백만가지)
	void m1(float a, String s) {
//		System.err.println(a);
		System.out.println(a + " " + s);
		
		System.out.println(s.length());
	}
	
	String m2() {
		//return "호랑이";
		String s = "독수리";
		return s;
	}
	
	String m3() {
		// 
		return null;
	}
}

public class Hello {
	public static void main(String[] args) {
		
		Tiger t1 = new Tiger();
		t1.m1(3.14f, "호랑이");
		
		t1.m2();
		
		// 2
		String s = t1.m2();
		System.out.println(s);
		
		// 3
		System.out.println(t1.m2());
		
		// 아직 s2는 객체가 아니다라는 것을 명시적으로 표시한다.
		String s2 = null;
		
		String s3 = "코끼리";
		s3 = null; // 더이상 s3는 객체가 아니다.
		
		
	}
}
*/

/*
//ex33)
class Tiger {

}

public class Hello {
	public static void main(String[] args) {
		
		Tiger t1 = new Tiger();
		
		// String : 문자열을 전문적으로 관리하는 클래스로, 자바에서 제공하는 표준 클래스이다.
		// 정식 표현
		String s1 = new String();
		s1 = "호랑이";
		System.out.println(s1);
		System.out.println(s1.length());
		
		// 약식 표현
		String s2 = "앵무새";
		System.out.println(s2);
		
		Thread t;
		
		Math m;
	}
}
*/

/*
//ex32)
class Tiger {
	int a;
	int b;
	
	void showData() {
		System.out.println(a + " " + b);
	}
	
	int add() {
		return a + b;
	}
	
	void m1(int a, int b) {
		int result = a + b; // 필드와 인수의 이름이 같은 경우, 지역 변수(스코프 내부, 즉, 인수)를 먼저 사용한다.
		System.out.println(result);
		// 필드의 a, b를 사용하고 싶다면, this 키워드 사용
		System.out.println(this.a + " " + this.b);
		
	}
}

public class Hello {
	public static void main(String[] args) {
		
		Tiger t1 = new Tiger();
		t1.a = 10;
		t1.b = 20;
		t1.showData();
		System.out.println(t1.add());
		
	}
}
*/

/*
//ex31)
class Tiger {
	void f1() {
		System.out.println(1);
	}
	void f2() {
		f1(); // 내부 메소드의 경우 클래스를 지칭할 필요가 없다.
		System.out.println(2);
	}
	void f3() {
		f2(); // 내부 메소드의 경우 클래스를 지칭할 필요가 없다.
		System.out.println(3);
	}
	
	// 상호호출 예제 : 스택 오버 플로우 에러남
	void f4() {
		System.out.println(4);
		f5();
	}
	void f5() {
		System.out.println(5);
		f4();
	}
	
	// 재귀호출(recursive call) 예제
	// 잘 쓰면 굉장히 유용하다.
	void f6() {
		System.out.println(6);
		f6();
	}
}

public class Hello {
	public static void main(String[] args) {
		
		Tiger t1 = new Tiger();
		t1.f3();
		System.out.println(4);
		
		//t1.f4(); // 상호호출로 인해 에러 발생
		
		//t1.f6(); // 재귀호출로 인해 에러 발생 
	}
}
*/

/*
//ex30) 리턴
class Tiger {
	// 리턴이 있다. FuncName(){}
	// ....가 없다.
	// 리턴이 없다.
	void func01() {
		
	}

	int func02() {
		System.out.println(1);
		return 100;
	}
	
	// 메소드에서 return 키워드를 만나면 함수가 중단된다.
	int func03() {
		if(3 < 2) {
			return 100;
		}else if(3 > 2) {
			return 200;
		}else {
			System.out.println(1000);
		}
		
		System.out.println(1000);
		return 2000;
	}
	
	// void 이지만 return 키워드를 사용할 수 있다.
	void func04() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			if( i == 5) {
//				break;
				return;
			}
			
		}
		System.out.println("for문 중단됨");
	}
	
	// 4번째 유형
	int func05(int num) {
		
		
		//return num * num;
		int result = num * num;
		if(result < 0) {
			
		}
		return result;
	}
	
	int func06(int num) {
//		System.out.println(num*num); // 값을 응용해서 활용할 수 있도록 하기 위해 출력문은 메소드에서 빼낸다.
		return num * num;
	}
	
	// 규칙을 만든다.
	// -1이 리턴된 경우는 음수인 경우이다.
	// +1이 리턴된 경우는 정상인 경우이다.
	int func07(int num) {
		if(num < 0) {
//			System.out.println("음수");
			return -1;
		}
		
		if(num % 2 == 0) {
			System.out.println("짝");
		}else {
			System.out.println("홀");
		}
		
		return 1;
	}
}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		// 1. 외면
		t1.func02();
		
		// 2.
		int num = t1.func02(); // 100
		System.out.println(num);
		// System.out.println(100);
		
		// 3.
		System.out.println(t1.func02());
		// System.out.println(100);
		
		// 에러
//		System.out.println(t1.func01()); // func01()은 리턴이 없어서 출력할 수 없다.
		
		t1.func04();
		System.out.println(t1.func05(4));
		
		System.out.println(t1.func06(5) + t1.func06(3)); // 값을 응용해서 활용할 수 있도록 하기 위해 출력문은 메소드에서 빼낸다.
		
		if( t1.func07(-4) == -1) {
			System.out.println("음수입니다.");			
		}
	}
}
*/

/*
//ex29)
class Tiger{
	
	void m1() {
		System.out.println("멍");
	}
	
	void m2(int num) { // = 대입 연산이 일어남
		
		System.out.println("멍" + num);
	}
	
	void m3(int num) { // = 대입 연산이 일어남
		for (int i = 0; i < num; i++) {
			System.out.print("멍");
		}System.out.println();
	}
	
	void m4(int a, int b) { // = 대입 연산이 일어남
		System.out.println(a + " " + b);
		System.out.println(a * b);
	}
	
	// 일반적으로 사각형이 그려질 땐, 가로, 세로 순으로 입력한다.
	void m5(int width, int height, char ch, boolean b) { // = 대입 연산이 일어남
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print(ch + " ");
			}System.out.println();
		}
	}
	
	void m6(int n) {
		for (int i = 0; i < 10; i++) {
			System.out.println(n + " * " + i + " = " + n * i);
		}
	}
	
	void m7(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
	
	void m8(int w, int h, char ch1, char ch2) {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				
				if( (i+j) % 2 == 0) {
					System.out.print(ch1);
				}else {
					System.out.print(ch2);
				}
				
				System.out.print(
						((i+j) % 2 == 0 ? ch1 : ch2) + " "
				); // 내부가 복잡한 경우, 가독성을 위해 여러 줄로 작성한다.
				
			}System.out.println();
		}
	}
}

public class Hello {
	public static void main(String[] args) {
		
		Tiger t1 = new Tiger();
		t1.m1();
		t1.m2(3);
		t1.m3(8);
		t1.m3(14);
		t1.m4(3, 4);
		
		// 일반적으로 사각형이 그려질 땐, 가로, 세로 순으로 입력한다.
		t1.m5(5, 4, '*', true);
		
		t1.m6(19);
		t1.m7(5);
		
		t1.m8(8,  7, '한', '글');
	}
}
*/

/*
//ex28)
class Tiger{
	// 메소드 유형
	// 1. void f1() {}
	// 2. void f1(int a) {}
	// 3. int f1() {}
	// 4. int f1(int a) {}
	
	// 1. 리턴없다 f1(인수전달 없음) {}
	// 2. 리턴없다 f1(인수전달 있음) {}
	// 3. 리턴있다 f1(인수전달 없음) {}
	// 4. 리턴있다 f1(인수전달 있음) {}
	
	// 1. X f1(X) {}
	// 2. X f1(O) {}
	// 3. O f1(X) {}
	// 4. O f1(O) {}
	
	// 1
	void method01() {
		System.out.println("method01");
		System.out.println("method01");
		System.out.println("method01");
	}
	
	void method02() {
		System.out.println("method01");
		System.out.println("method01");
		System.out.println("method01");
	}
	
	
}

public class Hello {
	public static void main(String[] args) {
		
		// 코드의 재활용 
		// 함수(메소드) : 자주 사용되는 코드를 저장해서 재활용한다.
		
		Tiger t1 = new Tiger();
		System.out.println(1000);
		t1.method01(); // 함수 호출
		System.out.println(2000);
		t1.method01(); // 함수 호출
		System.out.println(3000);
		
		Tiger t2 = new Tiger();
		t2.method01();
		
		t2.method02();
	}
}
*/

/*
//ex27)
// 관례적으로 클래스 첫글자는 대문자
class Airplane{ // 설계도
	// 멤버 종류
	// 1. 필드(변수) >> 속성
	int a;
	float b;
	int seat;
	int[] ar = new int[4];
	
	int num = 99;
	
	// 2. 생성자
	
	// 3. 메소드(함수)
	
}

public class Hello {
	public static void main(String[] args) {
//		Airplane a = new Airplane();
//		Airplane airplane = new Airplane(); // Airplane 다음 자동 완성 시, 첫글자 소문자로 변수명이 선언됨.
		// 실제 비행기가 만들어졌다.
		
		Airplane air = new Airplane(); // new 다음 자동 완성 시, 앞과 뒤에 같은 타입으로 타이핑할 수 있다.
		Airplane air2 = new Airplane(); // new 다음 자동 완성 시, 앞과 뒤에 같은 타입으로 타이핑할 수 있다.
		
//		air.a = 10; // . -> 체인이라고 부름
		air.b = 20.0f;
		air.seat = 30;
		System.out.println(air.a); // 안이 자동으로 초기화됨
		System.out.println(air.b);
		
		air2.seat = 40;
		// 완전히 서로 다른 메모리 이다.
		System.out.println(air.seat + " " + air2.seat);
		
		
		
		System.out.println(air.ar.length);
		for (int i = 0; i < air.ar.length; i++) {
			air.ar[i] = i * 10;
		}
		
		for (int i = 0; i < air.ar.length; i++) {
			System.out.print(air.ar[i] + " ");
		}System.out.println();
		
		for (int i = 0; i < air2.ar.length; i++) {
			System.out.print(air2.ar[i] + " ");
		}System.out.println();
		
		air.ar = new int[8]; // air.ar 초기화
		for (int i = 0; i < air.ar.length; i++) {
			System.out.print(air.ar[i] + " ");
		}System.out.println();
	
		
		
		System.out.println(air.num);
		System.out.println(air2.num);

		air.num = 1000;
		System.out.println(air.num);
		System.out.println(air2.num);
		
		
		
		int[]ar;
		System.out.println("------");
		ar = new int[10];
		ar = new int[20]; // ar 10개는 사라지고 20개가 새로 생성된다.
		
		// 메모리 반납 코드 : 자바가 자동으로 반납시켜줘서 신경쓰지 않아도 됨.
		// delete ar; 
	}
}
*/

/*
//ex26)
public class Hello {
	public static void main(String[] args) {
		Random rnd = new Random();
		
		int num = 10;
		int[] ar = new int[num];
		
		// 안좋은 예 : 데이터 갱신과 출력을 하나로 묶지 않는다. 갱신과 출력 사이에 많은 코드가 들어가는 경우가 생길 수 있기 때문.
		
		for (int i = 0; i < ar.length; i++) {
			ar[i] = rnd.nextInt(20);
			System.out.print(ar[i] + " ");
		}System.out.println();
		
		
		// 데이터 갱신(초기화)
		for (int i = 0; i < ar.length; i++) {
			ar[i] = rnd.nextInt(20);
		}
		// 데이터 출력
		for (int i = 0; i < ar.length; i++) {
			System.out.print(ar[i] + " ");
		}System.out.println();
		
		for (int i = 0; i < ar.length / 2; i++) {
			System.out.print(ar[i] + ar[num - 1 -i] + " ");
		}System.out.println();
	}
}
*/

/*
//ex25)
public class Hello {
	public static void main(String[] args) {
		
		// 배열
		// 1. 정석
		int[] arr = new int[10]; // 0으로 초기화
		
		// 2.
		int[] brr = new int[] {10, 20, 30}; // 임의의 값으로 초기화
		
		// 3.
		int[] crr = {40, 50, 60};
		
		// arr은 변수가 10개 있다.
		arr[0] = 10;
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		
		arr[9] = 20;
		System.out.println(arr[9]);
		
		// 0 - 9
		// arr[-5] = 100; // 중단됨 : ArrayIndexOutOfBoundsException
		
		// 변수 사용 및 산술연산 가능
		int num = 4;
		arr[num * 2 - 7] = 999;
		System.out.println(arr[1]);
		
		// 배열 인자로 배열 가능
		arr[5] = 7;
		arr[7] = 777;
		arr[arr[5] * 2 - 7] = 888;
		System.out.println(arr[7]);
		
		// 배열 길이 반환 메소드 
		System.out.println("------");
		System.out.println(arr.length);
		
		//
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}System.out.println(); // for문의 출력문을 구분시켜주기 위해 사용하므로 for문에 붙여준다.
		
		System.out.println("독수리");
	}
}
*/

/*
//ex24)
public class Hello {
	public static void main(String[] args) {
		
		//일반적인 switch 사용법
		Random rnd = new Random();
		
		int num = rnd.nextInt(30); // nextInt(2) : 0~1까지 값 랜덤 반환
		switch (num % 2) {
		case 0:{
			for (int i = 0; i < 10; i++) {
				System.out.println(num + " * " + i + " = " + num * i);
			}	
		}break; // case에 내용이 한 줄을 초과할 경우, 일반적으로 {}로 묶고 break를 당겨서 쓴다.
		
		case 1:{
			int sum = 0;
			for (int i = 1; i <= num; i++) {
				sum += i;
			}
			System.out.println(num + "까지의 합은 : " + sum);
		}break;

		default: break; // default에 내용이 없을 경우, 일반적으로 break를 당겨서 쓴다.
		}
		
	}
}
*/

/*
//ex23)
public class Hello {
	public static void main(String[] args) {
		
		int score = 87;
		switch(score / 10) {
		case 10: //break; // 100점인 경우 의도적으로 break를 뺐음을 표시한다.
		case 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		case 6:
			System.out.println("D");
			break;
		default:
			System.out.println("F");
			break;
		}
		
	}
}
*/

/*
//ex22)
public class Hello {
	public static void main(String[] args) {
		
		//switch
		//1. switch 안에 변수를 사용할 수 있다.
		//2. case 뒤에 변수를 사용할 수 없다.
		//3. break를 생략하면 switch를 빠져나오지 않는다.
		//4. 만족하는 분기문이 없을때는 default로 이동한다.
		//5. 정수, 문자, 문자열 모두 분기가 가능하다.
		//6. 의도적으로 break를 생략하기도 한다.
		
		int num = 20;
		char ch = '한';
		
		switch (num) {
		//case nn: (x)
		case 10:
			System.out.println(1);
			//break;
		
		case 20:
			System.out.println(1);
			break;
		
		case '한':
			System.out.println(1);
			break;

		default:
			System.out.println("호랑이");
			break;
		}
		
	}
}
*/

/*
//ex21)
public class Hello {
	public static void main(String[] args) {
		//난수 발생 방법1 : Random 클래스
		Random rnd = new Random();
		int num = rnd.nextInt(); // Int 범위 내의 난수 반환
		if(num < 0) {
			num = -num;
		}
		System.out.println(num);
		
		
		int sum = 0;
		while(true) {
			
			sum += num % 10;
			num /= 10;
		
			if(num <= 0) {
				break;
			}
			
		}
		System.out.println(sum);
	}
}
*/

/*
//ex20)
public class Hello {
	public static void main(String[] args) {
		
		// 연산횟수를 알기 어려운 예 : 우박수
		int num = 17;
		
		while(true) {
			System.out.println(num);
			
			
			if(num % 2 == 0) {
				num = num / 2;
			} else {
				num = num * 3 + 1;
			}
			// if와 else가 같은 변수를 사용 => 삼항으로 수정
			
			num = (num % 2 == 0) ? num / 2 : num * 3 + 1;
			
			if(num == 1) {
				System.out.println(num);
				break;
			}
		}
		
	}
}
*/

/*
//ex19)
public class Hello {
	public static void main(String[] args) {
		
		//while : 반복횟수를 알고 작성하는 for문과 달리, 반복횟수를 알지 못할 경우 사용

		// 잘못된 예1 : 무한 루프
		
		int num = 0;
		while(true) {
			System.out.println(num);
		}
				
		
		// 잘못된 예2 : 반복횟수를 알고 있는데 while문을 사용한 경우
		
		int num = 0;
		while(num < 4) {
			System.out.println(num);
			num++;
		}
		
		
		// 올바른 예 : true와 break로 while문 제어
		int num = 0;
		num = 0;
		while(true) {
			if(num == 4) {
				System.out.println("탈출 전");
				break;
				//System.out.println("Unreach code.");
			}
			System.out.println(num);
			num++;
		}
	}
}
*/

/*
//ex18-2)
public class Hello {
	public static void main(String[] args) {

		// 이중 for문의 경우 사각형 형태의 연산
		for (int i = 0; i < 3; i++) { // 세로

			for (int j = 0; j < 4; j++) { // 가로
				System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();

		for (int i = 0; i < 3; i++) { // 세로

			for (int j = 0; j < 4; j++) { // 가로
				System.out.print("[" + i + " " + j + "]");
			}
			System.out.println();
		}
		System.out.println();

		// if문과 else문에 같은 변수를 사용할 경우, 무조건 삼항연산으로 수정한다.
		int result;
		if (3 > 2) {
			result = 10;
		} else {
			result = 20;
		}

		// 삼항으로 수정된 예
		result = (3 > 2) ? 10 : 20;

		// O, X로 사각형 표현 예제를 삼항으로 수정
		int width = 8, height = 7;
		for (int i = 0; i < height; i++) { // 세로

			for (int j = 0; j < width; j++) { // 가로
//				if( (i + j) % 2 == 0 ) {
//					System.out.print("O ");										
//				} else {
//					System.out.print("X ");					
//				}
				System.out.print(((i + j) % 2 == 0) ? "O " : "X ");
			}
			System.out.println();
		}
		System.out.println();

		// 메소드 내 return을 삼항으로 구현한 경우
		
		int func() {
			
			if(3 > 2) {
				return 100;
			} else {
				return 200;
			}
			
			return (3 > 2) ? 100 : 200;
		}
		
	}
}
*/

/*
//ex18-1)
public class Hello {
	public static void main(String[] args) {
		
		for (int i = 0; i < 3; i++) {
			System.out.println("------");
			
			for (int j = 0; j < 4; j++) {
				System.out.println(1);
			}
			
			System.out.println("******");
		}
		
	}
}
*/

/*
// ex17)
public class Hello {
	public static void main(String[] args) {
		
		int num = 7; // for문 내부의 코드는 건드리지 않고 외부의 값을 통해 제어할 수 있게 한다.
		for (int i = 0; i < 10; i++) {
			System.out.println(num + " * " + i + " = " + num * i);
		}
		
		System.out.println("------");
		
		int sum = 0;
		int num2 = 1000;
		for (int i = 0; i <= num2; i++) {
			sum += i;
		}
		System.out.println(sum);
		

		// 2의 8승
		int sum2 = 1;
		int a = 2, b = 8;
		for (int i = 0; i < b; i++) {
			sum2 *= a;
		}
		System.out.println(sum2);
	}
}
*/

/*
//ex16)
public class Hello {
	public static void main(String[] args) {
		
		// for문은 몇번 도는지 한눈에 알 수 있어야한다.
		// for문 내에서 정리를 하지 말고, for문에 들어가기 전에 정리해야한다.
		// 유형 1 : 조건만큼 돈다.(4)
		for (int i = 0; i < 4; i++) {
			System.out.println(i);
		}
		
		// 유형 2 : 조건만큼 돈다.(4)
		for (int i = 1; i <= 4; i++) {
			System.out.println(i);
		}
		
		// 유형 3 : 조건 * 2 + 1 만큼 돈다.(7)
		// 음수에서 양수로 바뀌는 경우 주로 사용
		for (int i = -3; i <= 3; i++) {
			System.out.println(i);
		}
		
		
		// 잘못된 예1
		for (int i = 32; i <= 100; i+=8) {
			System.out.println(i);
		}
		
		// 잘못된 예2
		for (int i = 32; i > 2; i--) {
			System.out.println(i);
		}
		
	}
}
*/

/*
//ex15)
public class Hello {
	public static void main(String[] args) {
		
		// else if : 속도의 평준화가 안일어나므로 가급적 switch로 바꾸는 경우가 많다.
		int score = 87;
		if(score >= 90) {
			System.out.println('A');
		} else if(score >= 80) {
			System.out.println('B');
		} else if(score >= 70) {
			System.out.println('C');
		} else {
			System.out.println('F');
		}
		
		System.out.println(5);
		
	}
}
*/

/*
//ex14)
public class Hello {
	public static void main(String[] args) {
		
		// 1. if() {}
		// 2. if() {} else {}
		// 3. if() {} else if {} else if {} else {}
		
		int num = 10;
		if(num % 2 == 0) {
			System.out.println("Even");
		} else {
			System.out.println("Odd");
		}
		
		// 잘못된 예 : if와 else에 너무 다양한 작업이 들어가있음 -> 단순화가 필요.
		
		int password = 1234;
		if(password != 1234) {
			System.out.println("틀림");
		} else {
			System.out.println("맞음");
			System.out.println("유저가 로그인 하였음");
			System.err.println("다음 정보 확인");
		}
		
		
		// 수정된 예
		
		if(password != 1234) {
			System.out.println("틀림");
			break;
			exit();
			return;
		}
		
		System.out.println("맞음");
		System.out.println("유저가 로그인 하였음");
		System.err.println("다음 정보 확인");
		
		
		// 잘못된 예 : 실행시간이 경우에 따라 달라짐 -> 실행시간 측정 시 불안정함
		
		int nn = 10;
		while(true) {
			if(nn < 0) {
				nn = -nn;
				// sin();
			}
		}
		
		
		// 수정된 예 : sin()의 경우 계산을 할 때와 안할 때 속도차이가 심하므로 안정적인 측정을 위해 일부러 맞춰준다.
		
		int nn = 10;
		while(true) {
			if(nn < 0) {
				nn = -nn;
				// sin();
			}
			else {
				nn = +nn;
				// sin();
			}
		}
		
	}
}
*/

/*
//ex13)
public class Hello {
	public static void main(String[] args) {
		
		System.out.println(1);
		
		if(3 > 2) {
			System.out.println(2);
			
			if(3 != 4) {
				System.out.println(3);
			}
			System.out.println(4);
			
			if(3+4 >= 7) {
				System.out.println(5);	
			}
			System.out.println(6);
		}
		System.out.println(7);
		
	}
}
*/

/*
//ex12)
public class Hello {
	public static void main(String[] args) {
		
		// if, for, while, switch
		// do while(사용안함)
		
		if(true) {
			System.out.println(1);
			System.out.println(2);
		}
		
		if(false) {
			System.out.println(3);
			System.out.println(4);
		}
		
		System.out.println("------");
		
		if(true) {
			System.out.println(6);

			if(false) {
				System.out.println(7);
			}

			System.out.println(8);
		}
		
		System.out.println(9);
	}
}
*/

/*
//ex11)
public class Hello {
	public static void main(String[] args) {
		
		int a = 10, b = 20;
		int t; // temp
		System.out.println(a + " " + b);
		
		t = a;
		a = b;
		b = t;

		System.out.println(a + " " + b);
		
	}
}
*/

/*
//ex9)
public class Hello {
	public static void main(String[] args) {
		
		int n = 10; // 10
		n = 20; // 20
		n = n + 10; // 30 컴파일 속도가 더 느리다. 실행속도는 같다.
		n += 10; // 40 (복합대행연산자) 컴파일 속도가 더 빠르다. 실행속도는 같다.
		n = n + 1;
		n += 1;
		n++; // 43 (단항연산자) 실행 속도가 가장 빠르다.
		++n; // 44 실행 속도가 가장 빠르다.
		
		int a, b;
		n = 10;
		a = n++; // 10, 대입 증가
		System.out.println(a + " " + n);
		
		n = 10;		
		b = ++n; // 11, 증가 대입		
		System.out.println(b + " " + n);
	}
}
*/

/*
//ex8)
public class Hello {
	public static void main(String[] args) {
		
		//1. 변수 이름은 중복될 수 없다.
		int apple;
		// int apple; (x)
		
		//2. 대소 구분된다.
		int Apple;
		
		//3. 첫 글자가 숫자가 아닐 때 숫자 사용 가능
		int Apple123;
		//int 9Apple; (x)
		
		//4. _와 $ 를 제외하면 특수문자 사용불가
		int apple_num;
		int _34; // 행렬에서 3행 4열을 표현하는 경우
		
		//5. 한글 사용 가능(가급적 피한다)
		int 사과 = 10;
		System.out.println(사과);
		
		//6. 한 단어 이상 합성 시에는 카멜표기법
		int BananaNumber = 10; // 방법 1
		int bananaNumber = 10; // 방법 2 (일반적)
		
	}
}
*/

/*
//ex)
public class Hello {
	public static void main(String[] args) {
		
		// 범위 주석 설정 단축키 : ctrl + shift + /
		// 범위 주석 해제 단축키 : ctrl + shift + \
		System.out.println(100);
		System.out.println(100);
		System.out.println(100);
				
	}
}
*/

/*
//ex7)
public class Hello {
	public static void main(String[] args) {
	
		// 정수 관련 표준 프리미티브 타입 : byte(1), short(2), int(4), long(8)
		// 나머지 표준 프리미티브 타입 : boolean(1), char(2, 음수범위가 없음), float(4, 소숫점), double(8)
		
		// 메모리 요구
		byte apple; // 1byte 메모리를 apple로 작명해서 요구
		apple = 10; // 대입연산(=)
		System.out.println(apple);
		
		apple = 20;
		System.out.println(apple);
		
//		apple = 200; // 에러 : 1byte는 크기가 127까지 밖에 안됨
//		apple = 128; // 에러 : 1byte는 크기가 127까지 밖에 안됨
		apple = 127;
		System.out.println(apple);
		
		short banana = 20; // short : 타입, banana : 변수(variable), = : 대입연산자, 20 : 리터럴
		
		int orange = 222222222;
		
		long kiwi = 22222222;
		
		// boolean(1), char(2, 음수범위가 없음), float(4, 소숫점), double(8)
		boolean t1 = true; // true 혹은 false
		char t2 = 'A';
		char t3 = '한';
		char t4 = 65; // 가급적 피한다. 가독성 떨어짐
		System.out.println(t2);
		System.out.println(t3);
		System.out.println((int)t2);
		System.out.println((int)t3);
		System.out.println((char)(t3+1));
		System.out.println((int)Character.MIN_VALUE); // char는 음수영역이 존재하지 않는다.
		System.out.println((int)Character.MAX_VALUE); // char는 음수영역이 존재하지 않는다.
		
		float t5 = 3.14f; // float 타입은 수 마지막에 f 붙여줘야함
		double t6 = 3.14;
		
		float sum = 0.0f;
		for (int i = 0; i < 100; i++) {
			sum = sum + 0.1f;
		}
		System.out.println(sum); // 10.000002 : 오차 발생
//		if(sum == 10.0f) // 사용할 수 없음
		
	}
}
*/

/*
//ex6)
public class Hello {
	public static void main(String[] args) {
		
		// 코드 줄 맞춤 단축키 : ctrl + i

		System.out.println(Byte.MIN_VALUE); // 1 Byte가 가질 수 있는 최소값
		System.out.println(Byte.MAX_VALUE); // 1 Byte가 가질 수 있는 최소값

		System.out.println("-------");
		
		// 2 Byte = 1 Short
		System.out.println(Short.MIN_VALUE); // 2 Byte가 가질 수 있는 최소값
		System.out.println(Short.MAX_VALUE); // 2 Byte가 가질 수 있는 최소값
		
		System.out.println("-------");
		
		// 4 Byte = 1 Integer
		System.out.println(Integer.MIN_VALUE); // 4 Byte가 가질 수 있는 최소값
		System.out.println(Integer.MAX_VALUE); // 4 Byte가 가질 수 있는 최소값
		
		System.out.println("-------");
		
		// 8 Byte = 1 Long
		System.out.println(Long.MIN_VALUE); // 8 Byte가 가질 수 있는 최소값
		System.out.println(Long.MAX_VALUE); // 8 Byte가 가질 수 있는 최소값
		
	}
}
*/

/*
//ex5)
public class Hello {
	public static void main(String[] args) {
		
		//논리연산 || : OR
		System.out.println(false || false);
		System.out.println(false || true);
		System.out.println(true || false);
		System.out.println(true || true);
		
		System.out.println("---------");
		
		//논리연산 && : AND
		System.out.println(false && false);
		System.out.println(false && true);
		System.out.println(true && false);
		System.out.println(true && true);

		// 연산 순서 : 산술 > 관계 > 논리
		System.out.println(3+2 > 7 && 2+6 < 8);
		
		System.out.println("---------");
		
		//논리연산 ! : 부정
		System.out.println(!true);
		System.out.println(!(3>2));		
		
		
	}
}
*/

/*
//ex4)
public class Hello {
	public static void main(String[] args) {
		
		// 관계연산은 true 혹은 false 반환
		System.out.println(10 > 5);
		System.out.println(10 >= 5);
		System.out.println(10 < 5);
		System.out.println(10 <= 5);
		System.out.println(10 == 5);
		System.out.println(10 != 5);
		
	}
}
*/

/*
// ex3)
public class Hello {
	public static void main(String[] args) {
		
		System.out.println(17+3);
		System.out.println(17-3);
		System.out.println(17*3);
		System.out.println(17/3);
		System.out.println(17%3);
		
		System.out.println(3+4*5); // 우선순위에 따라 산술연산됨
		System.out.println((3+4)*5); // 우선순위에 따라 산술연산됨
		System.out.println(2+3*4+5); // 우선순위에 따라 산술연산됨
		
		
	}
}
*/

/*
// ex2)
public class Hello {
	public static void main(String[] args) {
		
		System.out.println(100); // 정수
		System.out.println('한'); // 문자 (''가 비어있으면 에러남)
		System.out.println("호랑이"); // 문자열
		
		System.out.println(100 + 200); // 숫자 + 숫자 (산술연산)
		System.out.println(100 + "호랑이"); // 숫자 + 문자열 (문자열연결)
		System.out.println("호랑이" + 100); // 문자열 + 숫자 (문자열연결)
		System.out.println("호랑이" + "사자"); // 문자열 + 문자열 (문자열연결)
		
		System.out.println("100"); // 문자열
		System.out.println("100" + 100); // 문자열 + 숫자 (문자열연결)
		System.out.println(10 + 20 + "호랑이"); // 숫자 + 숫자 + 문자열 (좌측부터 연산 : 산술연산 후 문자열연결)
		System.out.println("호랑이" + 10 + 20); // 문자열 + 숫자 + 숫자 (좌측부터 연산 : 문자열연결 후 문자열연결)
		System.out.println(10 + " " + 20); // 숫자 + 문자열 + 숫자 (좌측부터 연산 : 문자열연결 후 문자열연결)
		System.out.println(10 + " " + 20 + " " + 30); // 숫자 + 문자열 + 숫자 (좌측부터 연산 : 문자열연결 후 문자열연결)
		
		System.out.println(10 + 'A'); // 숫자 + 문자 (산술연산 시 문자는 아스키코드로 치환됨)
		System.out.println(1 + 'A'); // 숫자 + 문자 (산술연산 시 문자는 아스키코드로 치환됨)
		
		System.out.println((char)(1 + 'A')); // type casting
		
	}
}
*/

/*
// ex1)
public class Hello {
	public static void main(String[] args) {
		
		// 자바에선 함수를 메소드라 칭한다.
		// 코드를 기계어로 변환하는 작업 : 컴파일 (단축키 : ctrl + f11)
		// 코드 복사 단축키 : ctrl + alt + 위, 아래
		// 코드 이동 단축키 : alt + 위, 아래
		// 주석 단축키 : 블록 후 ctrl + / 
		System.out.println(1000);
		System.out.println();
	}
}
*/