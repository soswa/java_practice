package Pack01;

import java.io.*; // *�� java.io ������ �ִ� Ŭ������ ��� ����
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


//ex91) ��Ʈ��ũ ���α׷���

public class Hello {
	public static void main(String[] args) {
		

		
	}
}



/*
//ex90-8) UI : �ٸ� Ŭ����(World)�� �Բ� ���
public class Hello {
	public static void main(String[] args) {
		
		System.out.println("���");
		Scanner sc = new Scanner(System.in);
		sc.nextInt();
		System.out.println("��� ����");
		
	}
}
*/

/*
//ex90-7) UI : �̺�Ʈ�� �����带 ���� Ŭ������ ���� ����ϱ�
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
		System.out.println("������ ����");
		
		// btn1
//		Platform.runLater(()->{
//			
//			btn.setText("ȣ����");
//			
//		});

		// btn3, btn4
		Platform.runLater(()->{
			
			hello.btn3.setText("ȣ����");
			hello.btn4.setText("�ڳ���");
			
		});
		
		System.out.println("������ ����");
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
		
		// ---��ġ ����---
		
//		Button btn1 = new Button("��ư1");
//		
//		btn1.setOnAction(new EventHandler<ActionEvent>() {
//			
//			@Override
//			public void handle(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				// �����带 ���� Ŭ������ ���� �ڵ尡 ���������.
//				// => ������ : Ŭ���� ���ο��� ��Ʈ�� ��ü�� ������ �Ұ����ϴ�.
//				// => �ذ� : �����ڸ� ���� ���� �ʵ忡 �������ش�.
//				Tiger t1 = new Tiger(btn1);
//				t1.start();
//			}
//		});
//		
//		root.getChildren().addAll(btn1);
		
		// �����带 ���ؼ� ������ ��Ұ� ���� ���
		btn3 = new Button("��ư3");
		btn4 = new Button("��ư4");
		
		btn3.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				// ���� ��Ұ� ���ٸ�?
				// => �����ڿ� �����ε�� ���ʰ��� ���� �� ����.
				// => hello Ŭ���� ��ü�� ����������. (this)
				Tiger t1 = new Tiger(Hello.this);
				t1.start();
			}
		});
		
		root.getChildren().addAll(btn3, btn4);
		
		// ---��ġ ����---
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("ȣ����");
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
//ex90-6) UI : �̺�Ʈ�� ������ ��� �� ������
public class Hello extends Application {
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub

		HBox root = new HBox();
		root.setPrefSize(400, 300);
		root.setSpacing(10);
		
		// ---��ġ ����---
		
		Button btn1 = new Button("��ư1");
		
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Thread() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						System.out.println("������ ����");
//						btn1.setText("ȣ����"); // �����忡�� ������ ����.
						
						// (����!)�����忡�� �ݵ�� Ŭ������ �־ ��Ʈ�� ���¸� �����ؾ��Ѵ�.
						Platform.runLater(()->{
							
							btn1.setText("ȣ����");
							
						});
						System.out.println("������ ����");
					}
				}.start();
			}
		});
		root.getChildren().addAll(btn1);
		
		// ---��ġ ����---
		
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.setTitle("ȣ����");
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
//ex90-5) UI : ��ư ���̰�/�Ⱥ��̰�, ��Ȱ��ȭ
public class Hello extends Application {
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub

		HBox root = new HBox();
		root.setPrefSize(400, 300);
		root.setSpacing(10);
		
		// ---��ġ ����---
		
		Button btn1 = new Button("��ư1");
		Button btn2 = new Button("��ư2");
		
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				btn2.setText("ȫ�浿"); // �ٸ� ��Ʈ�ѷ��� ������ �� �ִ�.
			}
		});
		
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
//				btn1.setVisible(false); // �Ⱥ��̰�
				btn1.setVisible( !btn1.isVisible() ); 
				
				btn1.setDisable(true); // ��Ȱ��ȭ
			}
		});
		root.getChildren().addAll(btn1, btn2);
		
		// ---��ġ ����---
		
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.setTitle("ȣ����");
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
		
		// ---��ġ ����---

		Button btn1 = new Button("��ư1");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("ȣ����---");
				
			}
		});
		
		
		TextArea textArea = new TextArea();
		
		TextField textField = new TextField();
		textField.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String s = textField.getText();
//				System.out.println(s); // ���� �Է� �� ��޴�.

				textField.setText("");
				
				textArea.appendText(s + "\n");
				
			}
		});
		
		root.getChildren().addAll(btn1, textArea, textField);
		
		// ---��ġ ����---
		
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.setTitle("ȣ����");
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
//ex90-3) UI : ��ư �̺�Ʈ �Լ�
// ��ư �̺�Ʈ �Լ� ���� ����
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
		
		// ---��ġ ����---

		// ��ư �̺�Ʈ �Լ� ���� ����
//		Tiger t1 = new Tiger();
//		t1.f2(new A<Integer>() {
//			@Override
//			public void f1() {
//				// TODO Auto-generated method stub
//				System.out.println();
//			}
//		});
		
		Button btn1 = new Button("��ư1");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("ȣ����---");
				
			}
		});
		
		Button btn2 = new Button("��ư2");
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("�ڳ���");
				
			}
		});
		root.getChildren().addAll(btn1, btn2);
		
		// ---��ġ ����---
		
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.setTitle("ȣ����");
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
		root.setSpacing(10); // �� ��Ʈ�� ���� ���� (px)
		
		// ---��ġ ����---

		// ��ġ ��� 1.���� ��ġ
//		Button btn1 = new Button("��ư1"); // ��ü ����
//		root.getChildren().add(btn1); // ��ü ��ġ
//		
//		Button btn2 = new Button("��ư2"); // ��ü ����
//		root.getChildren().add(btn2); // ��ü ��ġ
		
		// ��ġ ��� 2. �ϰ� ��ġ (�ַ� ���)
		Button btn1 = new Button("��ư1"); // ��ü ����
		Button btn2 = new Button("��ư2"); // ��ü ����
		Button btn3 = new Button("��ư3"); // ��ü ����
		
		root.getChildren().addAll(btn1, btn2, btn3); // ��ü �ϰ� ��ġ
		
		// ---��ġ ����---
		
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.setTitle("ȣ����");
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
//ex90-1-1) launch�� static�ε�, ��� �������̵� �Ϲ� �Լ��� start�� �ҷ��� �� �ִ°�?
//			 => ��ü ��ü ���� �� �޼ҵ� ã��
abstract class MyApplication{
	static void launch() {
		
//		Hello h = new Hello();
//		h.start();
		// ������ Ŭ�������� �� �� ���� ������ ��ó�� �������� ������ �ʰ�
		// �������� �Ʒ��� ���� Ŭ�������� ã�� �Ѵ�.
		
		try {
			// Ŭ���� ã��
			Class<?> cls = Class.forName("Pack01.Hello");
			System.out.println(cls);
			
			// ��ü ����
			Constructor<?> constructor = cls.getConstructor();
			Object obj = constructor.newInstance();
			
			// �޼ҵ� ã��
			Method m = cls.getMethod("start");
//			Method m = cls.getMethod("start", String.class); // �μ��� �ִ� �Լ��� ���
			System.out.println(m);
			
			// start �Լ� ȣ��
			m.invoke(obj);
//			m.invoke(obj, "ȣ����"); // �μ��� �ִ� �Լ��� ���
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	abstract void start();
//	abstract void start(String s); // �μ��� �ִ� �Լ��� ���
}

public class Hello extends MyApplication {
	public void start() {
		System.out.println(100);
	}
//	public void start(String s) { // �μ��� �ִ� �Լ��� ���
//		System.out.println(s);
//	}
	public static void main(String[] args) {
		
		launch();
		
	}
}
*/


/*
//ex90-1) UI : swing -> JavaFx (�߾Ⱦ�)
// ���� Ŭ������ Application�� ��� �޾ƾ��Ѵ�.
// https://gluonhq.com/products/javafx/ ���� �ٿ�ε�
// swing�̶� �浹 �Ͼ �� �����Ƿ� ����
public class Hello extends Application {
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		// UI�� �ڵ� ���α׷��������� �ʴ°� ���� UI�̴�.
		// �巡�� ������� ���� �� �� �� �־�� �Ѵ�. (JavaFx�� �ڵ� ���α׷������̾ ��������.)

		// ���̾ƿ� ����
		VBox root = new VBox(); // Vertical Box
		// â ũ�� ���� (����X)
		root.setPrefSize(400, 300);
		
		// ------
		//
		// root ������ ��ҵ��� ��ġ�ȴ�.
		//
		// ------
		
		// ������ ������ Ŭ���� �ȿ� ���� ������ �ʴ� ��ġ�� ����Ѵ�.
		// â ũ�� ����
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.setTitle("ȣ����"); // ���α׷� ��� ���� ����
		arg0.show(); // ������ ��ϵ� ���� ȭ�鿡 ���
		
	}
	public static void main(String[] args) {
		System.out.println("Start");
		launch(); // (ù���� �ҹ���) ������ start �Լ� ȣ��, static �Լ� (static���� static��)
		// ���ŷ
		
		System.out.println("Exit"); // â�� ������ ������ ����� �ȴ�.
		
	}
}
*/

/*
//ex89) Thread ����5 : Ŭ������ �̿��� ������ ���
class Tiger extends Thread{
	public void run() {
		System.out.println(1);
	}
}

public class Hello {
	public static void main(String[] args) {
		
		// 1. �Ϲ����� ������ ���
		Tiger t1 = new Tiger();
		t1.start();
		
		// 2. ��ĳ�������� ������ ���
		Thread t2 = new Tiger();
		t2.start();
		
		// 3. �͸� Ŭ���� �����ؼ� ������ ���
		Thread t3 = new Thread() {
			public void run() {
				System.out.println(2);
			}
		};
		t3.start();
		
		// 4. �͸� Ŭ������ �������� �ʰ� ������ ���
		new Thread() {
			public void run() {
				System.out.println(3);
			}
		}.start();
	}
}
*/

/*
//ex88) Thread ����4 : ����� �й� ����
class Lion extends Thread{
	public void run() {

		// ���ŷ
		new Scanner(System.in).nextInt();
		System.out.println("������");
	}
}
class Tiger extends Thread{
	public void run() {
		Lion t2 = new Lion();
		t2.start();
		
		// ���ŷ
		new Scanner(System.in).nextInt();
		System.out.println("�ڳ���");
	}
}
public class Hello {
	public static void main(String[] args) {
		
		Tiger t1 = new Tiger();
		t1.start(); // 
		
		// ���ŷ
		new Scanner(System.in).nextInt();
		System.out.println("ȣ����");
		
		
		// ���ŷ �Է� �ڵ� ���� �ٷ� ����ڵ尡 ���ðŶ�� �����ϴ� ���� �����ϴ�.
		// ��� ���1 >> ���ŷ �Է� �ڵ�� ��� �ڵ尡 ������ ���� ���
		//  1
		//  �ڳ���
		//  2
		//  ȣ����
		//  3
		//  ������
		
		// ��� ���2 >> ���ŷ �Է� �ڵ尡 �������� ���� ���
		//  1
		//	�ڳ���
		//	2
		//	3
		//	������
		//	ȣ����
		
	}
}
*/

/*
//ex87) Thread ����3 : ����� �й� ����
class Tiger extends Thread{
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("ȣ���� : " + i);
			// sleep(0) : OS�� ������ �� ���� ª�ٰ� �����Ǵ� �ð���ŭ ����. (�Ƚ��� �� X)
			try { Thread.sleep(0); } catch (Exception e) { } 
		}
	}
}
public class Hello {
	public static void main(String[] args) {
		
		Tiger t1 = new Tiger();
		t1.start();
		
		for (int i = 0; i < 10; i++) {
			System.out.println("�ڳ��� : " + i);
			// sleep(0) : OS�� ������ �� ���� ª�ٰ� �����Ǵ� �ð���ŭ ����. (�Ƚ��� �� X)
			try { Thread.sleep(0); } catch (Exception e) { } 
		}
	}
}
*/

/*
//ex86) Thread ����2 : ����� �й�
// ������� �������� ����� ����ȴ�. (�ַ� while������ ���� ��)
// ������� ������ ��ȣ�� ������ �����ȴ�.
// ex85�� ���� ����
class Tiger extends Thread{
	public void run() {
		System.out.println("thread start");
		System.out.println("call");
		System.out.println("thread end");
	}
}
public class Hello {
	public static void main(String[] args) {
		
		// ex85�� ���� ����
		// Tiger�� start�� ������, ����� �� �ִ�. => �θ��� Thread Ŭ������ �ִ�.
		Tiger t1 = new Tiger();
		t1.start(); // start�� �Ǵ� ����, run �Լ��� "thread start"�� ���"ȣ����"�� ���� ���� ���̰� �ȴ�.
					// �� �� ������ ���� ������ ��(������� ���� ���� ������)�� ������ �ü���� �����̹Ƿ� �� �� ����.
		System.out.println("ȣ����");
		
	}
}
*/

/*
//ex85) Thread ����1 : ���� ���� 
// �θ��� �Լ��� ���� �ڽ��� ������ �Լ��� ������ ���� ������ �� �־���Ѵ�.
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
		// B�� ������ �ڽſ��� start�� ����. => �θ𿡰� �ִ�.
		// �θ��� start�� �����Ű��, �ڽ��� run�� ����Ǿ���. => start�� run�� �����Ű�� �ڵ尡 �ִ�.
		
	}
}
*/

/*
//ex84) Ű �Է� : Scanner �� ���ŷ �Լ�
// ���ŷ �Լ� : ��ӵ� Ư�� ������ ������ ������ ���α׷��� ���̻� �������� ���ϴ� �Լ�
// ex : nextInt(), sleep()
public class Hello {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("���ڸ� �Է��ϼ���.");
		
		// �Է�
		int num = sc.nextInt(); // nextInt() : ���ŷ �Լ�
		System.out.println(num);

		int num2 = sc.nextInt();
		System.out.println(num2);
		
		System.out.println(num + num2);
		
		
		// ���� �� �Է�
		for (int i = 0; i < 100; i++) {
			System.out.println("���ڸ� �Է��ϼ���.");
			int num3 = sc.nextInt();
			
			// for������ ���� ��ü ������ ����� ���� ���.
			// Resource leak: '<unassigned Closeable value>' is never closed
//			int num3 = new Scanner( System.in).nextInt();
			
			// ���� ����, ���� Ŭ������ �Ź� �������� �ʰ�,
			// �� �� ������ ��ü���� nextInt()�� ���� �޾ƿ� �� �ִ�.
//			Random rnd = new Random();
//			int random = new Random().nextInt(100);
			
			System.out.println(num3);
			if(num3 == 999) {
				break;
			}
		}

		System.out.println("���α׷��� �����մϴ�.");
	}
}
*/

/*
//ex83-2) Generic ���� : Ŭ����2
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
//		mm.add(100); // ���� : Book Ŭ������ �� �� �ִ�.
		mm.add(new Book("�ڹٸ� ����", "ȫ�浿", "���������ǻ�1", 100));
		mm.add(new Book("���� �ڴ� ��", "������", "���������ǻ�2", 150));
		mm.add(new Book("������ ������", "�ƹ���", "���������ǻ�3", 200));
		mm.add(new Book("���� ���� ���� �;��", "������", "���������ǻ�4", 1000));
		System.out.println(mm.get(0).toString()); // Book [title=�ڹٸ� ����, author=ȫ�浿, publisher=���������ǻ�, price=100]
		System.out.println(mm.size()); // 4
		
		// READ
		// 1. ��ü
		for (Book book : mm) {
			System.out.println(book);
		}System.out.println();
		
		// 2. �˻�
		Book oneBook = mm.get(2);
		System.out.println(oneBook);
		
		System.out.println("------");
		
		// UPDATE
		mm.set(1, new Book("���� �Ͼ�� ��", "�̵���", "���������ǻ�5", 2000));
		for (Book book : mm) {
			System.out.println(book);
		}System.out.println();
		
		System.out.println("------");
		
		// DELETE
		mm.remove(0);
		for (Book book : mm) {
			System.out.println(book);
		}System.out.println();
		
		// �˻�
		// �Ϲ������� �Լ��� ���� ����Ѵ�.
		Book findBook = search(mm, "������");
		if(findBook != null) {
			System.out.println("ã�Ҵ�.");
			System.out.println(findBook);
		}else {
			System.out.println("�׷� å ����.");
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
//ex83-1) Generic ���� : Ŭ����
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
		
		// Generic���� Ŭ������ �� �� �ִ�.
		Lion<Tiger> t1 = new Lion<>();
		
		
	}
}
*/

/*
//ex82-2) LinkedList �˻� ���� ����
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
		
		// ¦�� ���� ����
		// �߸��� �ڵ�
		for (int i = 0; i < mm.size(); i++) {
			if(mm.get(i)%2 == 0) {
				mm.remove(i);
			}
		}
		System.out.println(mm); // [11, 33, 55, 77, 99, 101, 104] => ¦�� 104�� �����ִ�.
								// => �ε����� �����ϴµ�, �����;��� �پ���.
								// => ���� ����, index�� ���� ����������Ѵ�.

		// ������ �ʱ�ȭ
		mm = new LinkedList<>();
		for (int i = 0; i < 10; i++) {
			mm.add(i * 10 + i);
		}

		mm.add(101);
		mm.add(102);
		mm.add(104);
		System.out.println(mm); // [0, 11, 22, 33, 44, 55, 66, 77, 88, 99, 101, 102, 104]

		// �ùٸ� �ڵ�
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
//ex82-1) LinkedList �˻� ����
public class Hello {
	public static void main(String[] args) {
		
		LinkedList<Integer> mm = new LinkedList<>();
		
		for (int i = 0; i < 10; i++) {
			mm.add(i * 10 + i);
		}
		System.out.println(mm); // [0, 11, 22, 33, 44, 55, 66, 77, 88, 99]

		// �˻� �� ����
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
// �ڷᱸ��
//ex81) �ݷ��� - LinkedList CRUD
// 1. �ݷ��� Ŭ������ ���� ���� �� �ִ°�? => �ڷᱸ��. (C / C++)
// 2. �̹� ���۵� ���� �� ����ϴ°�? => (JAVA �� ������ �迭)
//  => �̹� ������� �� ����ϱ� ������ �ڹٴ� �ڷᱸ���� ����. (�ڹ� ö�� : ������� ���� �� �������)
public class Hello {
	public static void main(String[] args) {
		
		LinkedList<Integer> mm = new LinkedList<>();
		// CRUD + �˻�, ���� �Ǵ��� Ȯ��
		
		// CREATE
		System.out.println(mm.size()); // ������ �ֱ� �� 0
		mm.add(100);
		System.out.println(mm.size()); // ������ ���� �� 1
		
		for (int i = 0; i < 10; i++) {
			mm.add(i * 10 + i);
		}
		System.out.println(mm.size()); // ������ ���� �� 11
	
		// READ
		// 1. �����͸� ���⸸ �� ��, Ȱ�뵵�� ��������.
		System.out.println(mm); // [100, 0, 11, 22, 33, 44, 55, 66, 77, 88, 99] // .toString() ����
		
		// 2. �����Ϳ� �ϳ��� ������ �� �־, �����͸� Ȱ���� �� �ִ�. 
		for (int i = 0; i < mm.size(); i++) {
			System.out.print(mm.get(i) * 2 + " "); // 200 0 22 44 66 88 110 132 154 176 198 
		}System.out.println();
		
		// 3-1. for���� ����ȭ�� ����(���� �ڵ�) : forEach ��
		// data (Ȥ�� item, value) : ���� ������ or Index ���� Ȯ���ؾߵ�.
		for (Integer data : mm) { // (���� ������ Ÿ�� : ��ü) => ��� �����Ϳ� ���� �� ����
			System.out.print(data + " "); // 100 0 11 22 33 44 55 66 77 88 99 => ���� ������
		}System.out.println();
		
		// 3-2. �迭 forEach
		int[] arr = {10, 20, 30};
		for (int item : arr) {
			System.out.print(item + " "); // 10 20 30 
		}System.out.println();
		
		// 3-3. ���ڿ� forEach => �ڹ� X
//		String s = "����ȭ�����Ǿ����ϴ�";
//		for (int value : s) { // ���� �ȵ� (�ٸ� ���� ���� ��)
//			System.out.println(value);
//		}
		
		// UPDATE
		System.out.println(mm); // [100, 0, 11, 22, 33, 44, 55, 66, 77, 88, 99]
		mm.set(5, 99); // index 5�� ���� 99�� ����
		System.out.println(mm); // [100, 0, 11, 22, 33, 99, 55, 66, 77, 88, 99]

		// DELETE
		System.out.println(mm); // [100, 0, 11, 22, 33, 99, 55, 66, 77, 88, 99]
		mm.remove(4); // index 4�� ���� ����
		System.out.println(mm); // [100, 0, 11, 22, 99, 55, 66, 77, 88, 99]

		// �˻�
		// 6-1. forEach (�� ã�� ��츦 �߰��Ϸ���, �ܺ� ������ �ʿ���)
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
//ex80) Generic ����
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

// Generic : Ÿ��(T)�� ��ü�� ������ �� ��������.
// <> : '�����̳�'��� Ī��
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
		
		// �Ʒ� �ڵ���� Ÿ�Ը� �ٸ��� ����� ���� �ڵ��.
		// => Generic���� Ŭ������ �����ش�.
		Tiger t1 = new Tiger();
		t1.setData(100);
		System.out.println(t1.getData());
		
		Lion t2 = new Lion();
		t2.setData("����");
		System.out.println(t2.getData());
		
		Cat t3 = new Cat();
		t3.setData(3.14f);
		System.out.println(t3.getData());
		
		// Generic ����
		// Ŭ������ �����ϹǷ�, ���� Ÿ���� �⺻���� ����ؾ��Ѵ�. (Dog<int> => X, Dog<Integer> => O) 
		Dog<Integer> t4 = new Dog<Integer>();
//		Dog<Integer> t4 = new Dog<>(); // ������ <> ���� ���� �����ϴ�.
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
//ex79) File �б�
// bmp ������ read, ���� ���� �� ������ File�� ���ؼ� ��� ���α׷����Ѵٰ� �� �� �ִ�.
public class Hello {
	public static void main(String[] args) {
		
		try {
			Reader reader = new FileReader("sample.txt");
//			Reader reader = new FileReader("s.txt");
			
			while(true) {
				
				// int java.io.Reader.read() throws IOException
				int readData = reader.read();
				if(readData == -1) {
					System.out.println("���ϳ����� ��� ����");
					break;
				}
				
				System.out.print((char)readData);
			}
			
			reader.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(); // ���� : 1. ���, 2. ��Ÿ
		}
		System.out.println("���");
		
	}
}
*/

/*
//ex78) File ����� ����
public class Hello {
	public static void main(String[] args) {
		
		// O X O X O X
		// X O X O X O
		// O X O X O X
		// X O X O X O
		// O X O X O X

		try {
			// Open
			Writer write = new FileWriter("sample.txt"); // ������ �����ϴµ�, �����Ѵٸ� ������.
		
			int width = 6, height = 5;
			for (int i = 0; i < height; i++) { // ����

				for (int j = 0; j < width; j++) { // ����

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
//ex77) File �����
public class Hello {
	public static void main(String[] args) {
		System.out.println(1);
		
		try {
			
			// ���� ����� == �� ���
			// ����, ����, �ݴ� �۾��� �ʿ�.
			// ������ ���� ������, �ٸ� ���α׷����� ���� �Ұ����ϴ�. -> ġ������ ���� �߻� ����
			
			// Open
			// Unhandled Exception
			// write(����) = FileWriter(����) => ��ĳ����
			Writer write = new FileWriter("sample.txt"); // ������ �����ϴµ�, �����Ѵٸ� ������.
			
			write.write("apple");
			write.write("\n"); // �ٹٲ� (Carriage Return)
			write.write("ȣ����");
			
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
//ex76) finally ���� �� �������
public class Hello {
	static int m1() {
		return 100;
	}
	
	// 2. finally�� ����ϴ� ���� 
	static void m2(int a, int b) {
		System.out.println("ȣ����1");
		if(a > b) {
			System.out.println("ȣ����2");
		} else {
			return; // ȣ����3�� ������� �ʴ´�.
		}
		System.out.println("ȣ����3"); // return���� ���� ��µ��� �ʴ´�.
	}
	static void m3(int a, int b) {
		try {
			System.out.println("ȣ����1");
			if(a > b) {
				System.out.println("ȣ����2");
			} else {
				return; // ������ finally ������ ���� �Ǿ��ִ�.
						// ȣ����3�� ��µǰ� �ȴ�.
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			System.out.println("ȣ����3"); // return�� ���ĵ� ��µǰ� �ȴ�.
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println(m1());
		
		try {
			System.out.println(2 / 0);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("catch"); // ��µ�
		} finally { // �� ���� �ְ�, �Ⱦ� ���� ����
			// catch�� ����, �����ʵ�, ������ ����
			// => �׷� try �ܺο� ������ �Ͱ� ���� �ʴ°�? 
			// => m2, m3 ����
			System.out.println("finally"); // ��µ�
		}
		System.out.println("���"); // ��µ�
		
	}
}
*/

/*
//ex75) Exception �߻���Ű�� ǥ�� �޼ҵ�
public class Hello {
	public static void main(String[] args) {

		for (int i = 0; i < 4; i++) {
			System.out.println(i);
			// ��ü������ Exception�� �߻���Ų��. == try/catch�� �ʿ��ϴ�.
			// ���� ���� ó���Ѵ�.
			try { Thread.sleep(1000); } catch (Exception e) {} // 1000 ms == 1��
		
		}
			
	}
}
*/

/*
//ex74) throw ����
class Tiger{
	// ��� 1
	void f1() {
		System.out.println("�Լ� 1");
		
		try {
			throw new Exception(); // Exceiption�� �߻���Ű�� �ڵ�
			// throw�� Exceiption�� �߻���Ű�� �ݵ�� �޾��ִ� �ڵ尡 �־�� ��.
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	// ��� 2 : Exception ���ѱ�� (�ַ� ����Ѵ�. �ٷ���� Exception�� ������ �����Ƿ� ȣ���� �ʿ��� �����ϵ��� �Ѵ�.)
	// �Լ��� ȣ���� ������ Exception�� �޵��� �Ѵ�.
	// �߻��ϴ� Exception�� ������ �پ��ϹǷ�, �� �Լ����� ��� Exception�� �����ϱ� ����, ȣ���� �ʿ��� �����ϵ��� �Ѵ�.
	void f2() throws Exception {
		System.out.println("�Լ� 2");
		
		throw new Exception();
	}
}
public class Hello {
	public static void main(String[] args) throws Exception { // main Exception�� �ü���� �޴´�. (�� ��� X : ���� ��� �ٷ��� �����ϰ� ����Ѵ�.)
		Tiger t1 = new Tiger();
		
		// 1. Exception �߻���Ű��
		t1.f1();
		System.out.println("ȣ����");

		// 2. Exception ���ѱ��
		// Unhandled exception
//		t1.f2(); // Exception�� �޾��� �ڵ尡 �ʿ��ϴ�.
		
		// try/catch�� �޾��ش�.
		try {
			t1.f2(); // Exception�� �޾��� �ڵ尡 �ʿ��ϴ�.
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�߻�");
		}
		System.out.println("ȣ����2");
		
		// 3. main Exception
		// Exception�� ��� �ٷ��� �̸� �����ϱ� ������, �� ������� �ʴ´�.
	}
}
*/

/*
//ex73) Exception�� try / catch ����
// ������ try / catch�� ��������� �ʴ´�.
public class Hello {
	public static void main(String[] args) {

		// Exception : ������ �߻������� �׿� �°� �����ڰ� �����϶�� �ǹ� (���α׷��� �����϶�� �ǹ� X)
		
		// 1-1. ArrayIndexOutOfBoundsException
		int[] ar = new int[3]; // 0 1 2
		System.out.println("����1"); // ��� ��
//		ar[3] = 10; // ���� : java.lang.ArrayIndexOutOfBoundsException
		// Exception�� �߻��ϸ� ���α׷��� �ߴܵȴ�.
		System.out.println("����2"); // ��� �ȵ�
		
		// 1-2. Exception�� �ٷ�� ���
		System.out.println("ȣ����1"); // ��� ��
		try {
			// Exception�� �߻��� ���ɼ��� �ִ� �ڵ�
			ar[3] = 10; // ���� : java.lang.ArrayIndexOutOfBoundsException
		} catch (Exception e) {
			// TODO: handle exception
			// Exception�� �߻��ϸ� catch������ ������ �ȴ�.
			System.out.println("�߻�"); // ��� ��
			e.printStackTrace(); // Exception�� �߻��� ���� ���
		}
		System.out.println("ȣ����2"); // ��� �ȵ�
		
		
		
		// 2-1. ArithmeticException
//		System.out.println(5 / 0); // ���� : java.lang.ArithmeticException
		System.out.println("������1"); // ��� �ȵ� 
		
		// 2-2.
		try {
			System.out.println(5 / 0);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�߻�"); // ��� ��
		}
		System.out.println("�����"); // ��� ��
		
		
		
		// 3-1. NullPointerException
		String s = null;
//		s.length(); // ���� : NullPointerException
		
		// 3-2. 
		try {
			s.length();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�߻�");
		}
		System.out.println("������");
		
		// 4. ������� ���α׷�
		// ���� : �̷�������, ������
		// ���� : �ڵ尡 �������.
		if( s != null ) { // ������ ����� ������ �ɾ��ش�.
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
		
		// 1. �μ��� ������� �ʴ� ���� �Լ�
		Aaa t1 = ()->{
			System.out.println(1);
		};
		t1.f1();

		// 2. �μ��� ����ϴ� ���� �Լ�
		Bbb t2 = (n)->{
			System.out.println(n);
		};
		t2.f1(100);
		
		// 3. ������ �ִ� ���� �Լ�
		Ccc t3 = ()->{
			return 200;
		};
		System.out.println(t3.f1());
		
		// 4. �μ��� ������ �ִ� ���� �Լ�
		Ddd t4 = (s, n)->{
			return s + n;
		};
		System.out.println(t4.f1("ȣ����", 3000));
		
		// 5. ���� �ڵ� 1�ٸ� �ִ� ���, return�� {}�� ������ �� �ִ�. (������ ���� X)
		Ccc t5 = ()-> 200;
		System.out.println(t5.f1());
		
		Ddd t6 = (s, n)-> s + n;
		System.out.println(t6.f1("����", 4000));
	}
}
*/

/*
//ex71)
interface Tiger{
	void f1();
}

class Lion{
	// ���� �������̽��� ������ �ȵ�����(Tiger t = new Tiger() X), �͸����� ���� �����϶�� �ǹ� (������)
	void f1(Tiger t) { 
		t.f1();
	}
}
public class Hello {
	public static void main(String[] args) {
		
		Lion lion = new Lion();
//		lion.f1(); // ������ ����.
		
		lion.f1(new Tiger() { // �͸� Ŭ������ ���� �߻� �޼ҵ带 �����ؼ� �����ϰ� �Ǹ� ��밡�� (������)
			
			@Override
			public void f1() {
				// TODO Auto-generated method stub
				System.out.println("ȣ����");
			}
		});
		
		lion.f1(new Tiger() { // ���� �� ������ �ٸ� ���� �����Ͽ� ������� ���� �� �ִ�.(������)
			
			@Override
			public void f1() {
				// TODO Auto-generated method stub
				System.out.println("������");
			}
		});

		Tiger t1 = new Tiger() {
			@Override
			public void f1() {
				// TODO Auto-generated method stub
				System.out.println("�޹���");
			}
		};
		
		// �� �ڵ��� ��� ǥ��� : ���� �Լ�
		Tiger t2 = ()->{ // -> : �ַο�
			System.out.println("�޹���");
		};
		
		// ù �ڵ��� ���� �Լ� ��� ����
		lion.f1(()->{
			System.out.println("�޹���");
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
		// ��ü�� ������ų �� ����.
		
		// �������̽� ���1
		Lion t1 = new Lion();
		Tiger t2 = new Lion(); // ��ĳ����
		
		// �������̽� ���2
//		Tiger t3 = new Tiger(); // ���� ����� �� ����
		
		// �͸� Ŭ������ ����ؼ� �߻� Ŭ������ �����ϸ�, �������̽��� ����� �� �ִ�.
		Tiger t3 = new Tiger() {
			
			@Override
			public void f1() {
				System.out.println("ȣ����");
			}
		
		};
		t3.f1();
		
		// �������̽� ���3 : ���2���� ����κ� ����
		// �͸� ��ü
		new Tiger() {
			@Override
			public void f1() {
				// TODO Auto-generated method stub
				System.out.println("�޹���");
			}
		}.f1(); // ��� ���� �Լ�
		
	}
}
*/

/*
//ex69) ���� ����(DI)
// Aaa�� Bbb�� ���� �������̰�, Bbb�� Ccc�� ���� �������̴�.
class Aaa{
	Bbb bbb;
	Aaa(Bbb bbb){ // ����
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
	public void f1() { System.out.println("���� ����"); }
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
		System.out.println("�뱹�� �����մϴ�.");
	}
	void play(Ai ai) {
		ai.play();
	}
	void stop(Ai ai) {
		ai.stop();
	}
	
	// �Լ��� �ǵ��� �μ������� ���δ�.
	// �Լ��� �μ������� ���̱� ���� �ʵ� ����
	Ai ai;
	// �����ڴ� ����(injection)�� �ް� �ִ�.
	Baduk(Ai ai){
		this.ai = ai;
		System.out.println("�뱹�� �����մϴ�.");
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

//�Ƹ���
class AlphaGo implements Ai{
	public void play() {
		System.out.println("�ΰ������� ���İ��Դϴ�.");
	}
	public void stop() {
		System.out.println("���İ� ������ ����մϴ�.");
	}
}
//����ũ�μ���Ʈ
class BetaGo  implements Ai{
	public void play() {
		System.out.println("�ΰ������� ��Ÿ���Դϴ�.");
	}
	public void stop() {
		System.out.println("��Ÿ�� ������ ����մϴ�.");
	}
}

public class Hello {
	public static void main(String[] args) {
		
		Baduk baduk = new Baduk();
		// ��ü�� ��� ������ �ʿ� ������, �׳� �Ѿ���� �Ѵ�.
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
//ex67-3) �̱��� Ŭ����(Ai)�� �����ϴ� ���� ���� -> �߻�ȭ
class Baduk{
	Baduk(){
		System.out.println("�뱹�� �����մϴ�.");
	}
	// ��ĳ���� �������� �̿��ؼ� �Լ��� �ϳ��� �����Ѵ�.
	void play(Ai alphaGo) {
		alphaGo.play();
	}
}

//class Ai{
//	void play() {};
//}
// �߻� Ŭ����ȭ
//abstract class Ai{
//	abstract void play();
//}
// �������̽�ȭ
interface Ai{
	void play();
}

//�Ƹ���
class AlphaGo implements Ai{
	public void play() {
		System.out.println("�ΰ������� ���İ��Դϴ�.");
		
	}
}
//����ũ�μ���Ʈ
class BetaGo  implements Ai{
	public void play() {
		System.out.println("�ΰ������� ��Ÿ���Դϴ�.");
		
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
//ex67-2) �ٸ� �ΰ��������� ������ ������ Ŭ������ �Լ��� �߰��ؾ� �Ѵ�.
class Baduk{
	Baduk(){
		System.out.println("�뱹�� �����մϴ�.");
	}
	void play(AlphaGo alphaGo) {
//		System.out.println("�ΰ������� ���İ��Դϴ�.");
		alphaGo.play();
	}
	void play(BetaGo betaGo) {
//		System.out.println("�ΰ������� ���İ��Դϴ�.");
		betaGo.play();
	}
}
// �Ƹ���
class AlphaGo{
	void play() {
		System.out.println("�ΰ������� ���İ��Դϴ�.");
		
	}
}
// ����ũ�μ���Ʈ
class BetaGo{
	void play() {
		System.out.println("�ΰ������� ��Ÿ���Դϴ�.");
		
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
//ex67-1) �ΰ������� ������ ���
class Baduk{
	Baduk(){
		System.out.println("�뱹�� �����մϴ�.");
	}
	void play() {
		System.out.println("�ΰ������� ���İ��Դϴ�.");
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
	// 1. �ʵ� Final( ���� �ʱ�ȭ�ϴ� ���� ���Ⱑ �������̴�.) = ���ȭ
	// const
	final int NUM = 10;
	void f1() {
//		this.NUM = 20; // ���� : final�� ���� �� �ʱ�ȭ �� �� ����
	}
	
	// 1-2. �ʵ忡�� �ʱ�ȭ���� ���� ���, �����ڿ��� �ʱ�ȭ �����ϴ�.
	final int NUM1;
	Tiger() {
		this.NUM1 = 20; // �ʵ忡�� �ʱ�ȭ���� �ʾƼ� �ʱ�ȭ �����ϴ�.
	}
	
	// 1-3. final ������ �Ϲ������� �빮�ڷ� ���ش�.
}

// 2. Ŭ���� Final
class Aaa{
	
}
// final Ŭ������ ��� ���̻� ����� �� ����.
final class Bbb extends Aaa{
	
}
//class Ccc extends Bbb{ // final Ŭ������ ���ؼ� ��ӹ��� �� ����
//	
//}

// 2-2. ǥ�� Ŭ���� ��� ����
//class Ddd extends String {} // final�� ���� ��� ���� �� ����
class Eee extends Thread {} // ��� ���� �� ����

// 3. �������̵� fianl
// ����ϴ� Ŭ������ �Լ��� �ʹ� ���Ƽ� �ߺ��Ǵ� �Լ����� �߻��� ��츦 ����Ѵ�.
class Fff{
	final void f1() {} // fianl �޼ҵ�� �������̵� �ȵȴ�.
	void f2() {
		f1(); // �ڽ��� �޼ҵ忩�� ��밡��
	}
}
class Ggg extends Fff{
//	void f1() {}	// final�� ���ؼ� �������̵��� �� ����.
}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
//		t1.num = 20; // ���� : final�� ���� �� �ʱ�ȭ �� �� ����
//		Math.PI = 20; // ����
		
	}
}
*/

/*
// ex65-2) �������̽��� ��� �Ǵ� Ŭ�������� �߰��ϴ� ����
//���� �ȸ��� ������, ���� ��ĳ������ ��츦 ���ؼ� �̸� �߰��Ѵ�.
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

// �������̽��� ���� ����� �����ϴ�.
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

@FunctionalInterface // �ش� �������̽����� �̱��� �޼ҵ尡 1�� �ִ�. (2�� �̻��� ���, ������ ��)
interface Eee{
	void f1();
}

public class Hello {
	public static void main(String[] args) {
		
		String s; // �������̽� 5�� 
		Thread th; // �������̽� 1��
		StringBuffer sb; // ��� 1��, �������̽� 3��
	}
}
*/

/*
//ex64)
// �������̽� ����1 : Ŭ������ ������ �������̽�
// ��, Ŭ������ ���� ����� �ȵȴ�.
abstract class Aaa{
	// �Ʒ��� �Լ����� �ݵ�� �����ϵ��� ���
	abstract void f1(); // �������̽� : �������� ������ ������, �ش� Ʋ�� �������� �����ϼ���.
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

//�������̽� ����2
abstract class ����Ʈ��{
	// �Ʒ��� �Լ����� �ݵ�� �����ϵ��� ���
	abstract void �޼���(); // �������̽� : �������� ������ ������, �ش� Ʋ�� �������� �����ϼ���.
	abstract void ��ȭ();
}
class �ȵ���̵� extends ����Ʈ��{
	@Override
	void �޼���() {
		// TODO Auto-generated method stub
		
	}
	@Override
	void ��ȭ() {
		// TODO Auto-generated method stub
		
	}
}

// �������̽� ����3
// ���� ����� �����ϴ�.
interface Ccc{
	// �Ʒ��� �Լ����� �ݵ�� �����ϵ��� ���
	void f1(); // abstract�� �����ص� ��
	void f2();
}
class Ddd implements Ccc{ // �������̽��� ����� �ƴ� �������� ǥ���Ѵ�.
	public void f1() { // �������̽� �޼ҵ�� �տ� public�� ���δ�.
		
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
		
		System.out.println(a * 800); // a�� 800�� ���Ѵ�.
		System.out.println(800 * a); // 800�� a�� ���Ѵ�. -> a�� ���� ���� ������ �޶�����.
		System.out.println((a << 9) + (a << 8) + (a << 5)); // ������ 800�� ������.
		
		// ����, ��Ʈ�� ��ġ�� ���� ���� ���, + ��� |�� ����ϴ°� �� ������. ( ���� : Integer.reverseBytes() )
		// �Ʒ� ������ +�� �����(18400)�� |�� �����(16352)�� �޶� +�� |�� ��ü���� ���Ѵ�.
		System.out.println((a << 9) | (a << 8) | (a << 5));
		
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				
				System.out.println(a * 800); // a�� 800�� ���Ѵ�.
				System.out.println(800 * a);
				System.out.println((a << 9) + (a << 8) + (a << 5)); // ������ ���� ������.
				
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
		// 1. & : ���� ���ϴ� Ư�� ������ �ɷ��� ��� ���� ��� �ַ� ���
		System.out.println(n1 & 0xFFFF0000); // 305397760
		System.out.println(hexaToBinary(n1)); // 0001 0010 0011 0100 1010 1011 1100 1101
		System.out.println(hexaToBinary(0xFFFF0000)); // 1111 1111 1111 1111 0000 0000 0000 0000 (����ũ ������)
		System.out.println(hexaToBinary(n1 & 0xFFFF0000)); // 0001 0010 0011 0100 0000 0000 0000 0000

		// 2. | : ������ bit���� �ռ� �� �ַ� ��� 
		System.out.println(n1 | 0xFFFF0000); // -21555
		System.out.println(hexaToBinary(n1)); // 0001 0010 0011 0100 1010 1011 1100 1101
		System.out.println(hexaToBinary(0xFFFF0000)); // 1111 1111 1111 1111 0000 0000 0000 0000 (����ũ ������)
		System.out.println(hexaToBinary(n1 | 0xFFFF0000)); // 1111 1111 1111 1111 1010 1011 1100 1101
		
		// 2-2. | ����
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
		
		// 3. ��Ʈ ����
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
		
		// 3-3. Ư�� ��Ʈ �������� (&)
		int data = 0xabcd;
		System.out.println(hexaToBinary(data)); 	   // 0000 0000 0000 0000 1010 1011 1100 1101
													   // 0000 0000 0000 0000 0000 0000 0001 1111 (����ŷ ������)
		System.out.println(hexaToBinary(data & 0x1f)); // 0000 0000 0000 0000 0000 0000 0000 1101
		System.out.println(data & 0x1f);   	           // 13
		
		System.out.println( (data & 0x7e0) >> 5);	   // 30
		
		System.out.println(hexaToBinary(0x7e0));
		
		System.out.println("---");
		System.out.println(hexaToBinary(0x0000f800));
		System.out.println(hexaToBinary((data & 0x0000f800 >> 11)));
		System.out.println((data & 0x0000f800 >> 11));
		
		System.out.println("---");

		// 3-4. ��Ʈ ���� (~)
		System.out.println(hexaToBinary(data));
		System.out.println(hexaToBinary(~data));
		
		System.out.println("---");
		
		// 3-5. ��Ʈ XOR (^)
		// �ַ� ����ó������ ������ų �� ���� ����
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
		
		// 32bit�� �ش��ϴ� ���ڿ��� ����� �۾�
		while(s.length() < 32) {
			s = "0" + s; // s�� ���� ��������� ��ü
		}
//		System.out.println(s.length()); // 32
//		System.out.println(s); // 01100011110011100111101111001101
		
		StringBuffer sb = new StringBuffer(s);
//		System.out.println(sb); // 01100011110011100111101111001101
		
		// StringBuffer : insert(" ")
		// String������ ������ ��ü�� �������� �ʱ� ������ insert�� ����		
		for (int i = 0; i < 7; i++) {
//			System.out.println((7 - i) * 4);
			sb.insert((7 - i) * 4, " ");
		}
//		System.out.println(sb); // 0110 0011 1100 1110 0111 1011 1100 1101

		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		// ���� ���ϴ� �������� 2���� ���
		int num = 0x63CE7BCD;
		System.out.println(hexaToBinary(num)); // 0110 0011 1100 1110 0111 1011 1100 1101

		System.out.println(hexaToBinary(0xab)); // 0000 0000 0000 0000 0000 0000 1010 1011

		int num2 = 100;
		System.out.println(hexaToBinary(num2)); // 0000 0000 0000 0000 0000 0000 0110 0100
		// ���� �޸𸮿��� ������ ��� ������ ������ �� 2������ ���� �� �� �ִ�.
		
		System.out.println(hexaToBinary(0x7fffffff)); // 0111 1111 1111 1111 1111 1111 1111 1111
		
		System.out.println(hexaToBinary(0x80000000)); // 1000 0000 0000 0000 0000 0000 0000 0000

	}
}
*/

/*
//ex60) 16����
class Tiger {

}

public class Hello {
	public static void main(String[] args) {
		
		int num1 = 100;
		System.out.println(num1); // 100
		
		int num2 = 0x100; // 0x : 16���� ǥ��
		System.out.println(num2); // 256
		
		int num3 = 0xABCD;
		System.out.println(num3); // 43981
		
		// 16������ 4�ڸ�, �� �ڸ����� 0, 1�� �� �� �ִ�.
		// ����, �� �ڸ��� 1bit, 16���� 1���� 4bit
		// 
		// int�� �ִ� 4byte �̹Ƿ�, 4byte�� ���� �� ����. (FF FF FF FF)
		int num4 = 0x63ce7bcd;
		System.out.println(num4); // 1674476493
		
		// 0 ~ 80 00 00 00(16���� �߰�) ~ FF FF FF FF
		System.out.println(Integer.toBinaryString(num4)); // 16������ ������� ���ڿ��� 2������ ��ȯ
		// 1100011110011100111101111001101
		
		int num5 = 0xab;
		System.out.println(Integer.toBinaryString(num5));
		// 10101011
		// 0000 0000 0000 0000 0000 0000 1010 1011 (���� ����ϰ� �Ǵ� ǥ��)
		
	}
}
*/

/*
//ex59) ����( bit ���� ) : 2(��), 10(���), 16(��, ��� ����)
class Tiger {
	// 16����
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
//ex58) String ������ �Լ��� ����
class Tiger {

}

public class Hello {
	public static void main(String[] args) {
		
		String s1 = "����ȭ�����Ǿ����ϴ�"; // '��' = index 0
		
		// 1. int java.lang.String.length()
		System.out.println(s1.length()); // ���ڿ� ���̸� ��ȯ������ ����� �� �ִ�.
		
		// 2. char java.lang.String.charAt(int index)
		System.out.println(s1.charAt(3)); // �ش��ϴ� �ε��� ���� �ҷ��´�.
		
		// 3. int java.lang.String.indexOf(String str) 
		System.out.println(s1.indexOf("���Ǿ�")); // ���ڿ��� �˻��ؼ� �ε��� ���� �ҷ��´�.
		
		// 3-2.
		System.out.println(s1.indexOf("���ϴ�")); // �˻� ���� �� ���� Ȥ�� -1�� ��ȯ�Ѵ�.
		
		// 3-2. ����
		if(s1.indexOf("���ϴ�") == -1) {
			System.out.println("�˻�����");
		}else {
			System.out.println("�˻�����");
		}
		
		// 4.
		// Ŭ���� ��� �� ���� �����͸� �����ϴ��� �� Ȯ���� ��
		// String replace(
		//		CharSequence target, 
		//		CharSequence replacement
		// )
		String s2 = s1.replace("����", "������"); // String Ŭ������ ���� �����͸� ���� �������� �ʴ´�.
		System.out.println(s1);
		s1 = "ȣ����"; // s1�� �޸𸮰� ������ ��(��ü ����), ���Ҵ��� �޴´�(��ü ����). ��, ���� �����Ͱ� ����� ���� �ƴϴ�.
		System.out.println(s1);
		
		// ����, ������ �����ϰ� �ʹٸ�, StringBuffer Ŭ������ �̿��ؾ��Ѵ�.
		System.out.println(s2);
//		System.out.println(s1.replace("����", "�Ĺ���"));
		
		// 5. String java.lang.String.substring(int beginIndex)
		s1 = "����ȭ�����Ǿ����ϴ�";
		System.out.println(s1.substring(3));
		System.out.println(s1.substring(3, 5)); // start ~ (end -1)
		// 3, 4�� ǥ������ �ʰ�, 3, 5�� ǥ���ϴ� ����
		// �ڵ� ���������� �߶� ������ ����� ���� ���ؼ� 
		// (end - start + 1�� ������� �ʰ�, end - start �� �ٷ� ����� �� �ִ�.)
		
		// 6. ��ҹ��� ����
		// �ܾ� �˻��� ���ؼ� ��ҹ��ڸ� ���Ͻ�Ű�� ��쿡�� ��� (Apple, apple, aPPLe)
		s1 = "Apple";
		System.out.println(s1.toLowerCase());
		System.out.println(s1.toUpperCase());
		
		// 7. ���� ����
		s1 = "  A p p l e  ";
		System.out.print(s1);
		System.out.println(1000);
		System.out.print(s1.trim()); // �յ� ������ �����Ѵ�. "A p p l e"
		System.out.println(2000);
						
	}
}
*/

/*
//ex57)
// 4. �߻��Լ��� ������ Ŭ������ �ݵ�� �߻�Ŭ���� �̾�� �Ѵ�.
abstract class Aaa {
	// 1. �������̵��� ��ǥ�� �ۼ��� �޼ҵ�������,
	// 2. �θ� �޼ҵ忡�� �ۼ��� ������ ���� ���
	// 3. �������� �����ϰ� �����ݷ��� ��� ���� �̿ϼ� �ڵ�(�߻�)�� �ȴ�.
	abstract void f1();
}
class Bbb extends Aaa{
	
	// 5. ��� ���� Ŭ������ �ݵ�� �ϼ����Ѿ� �Ѵ�.
	@Override
	void f1() {
		System.out.println(1);
	}
}

public class Hello {
	public static void main(String[] args) {
				
//		Aaa t = new Aaa(); // �߻� Ŭ������ �̿ϼ� Ŭ�����̹Ƿ� ��ü�� ������ų �� ����.
		// ��ü�� ������Ű�� �ʹٸ� ��ĳ������ �̿��ؾ��Ѵ�.
		Aaa a = new Bbb();
		a.f1();
		
	}
}
*/

/*
//ex56**�߿�**) ������
class Animal {
	void cry() {System.out.println("�Ҹ� ���� ����");}
}
class Tiger extends Animal {
	void cry() {System.out.println("����");}
}
class Cat extends Animal {
	void cry() {System.out.println("�߿�");}
}
class Dog extends Animal {
	void cry() {System.out.println("�۸�");}
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

	// ��ĳ������ Ȱ���ؼ� �޼ҵ带 ���� �� �ִ�.
	// ������ Ÿ���� ������ ���� ����� �پ��ϰ� ���� �� �ִ�. (������)
	// Animal�� ��ӹ޴� ���ο� Ŭ������ �߰��Ǿ sound �޼ҵ�� ���� ������ �ʿ䰡 ����.
	// (���� ����� ��Ģ, SOLID �� OCP)
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
		System.out.println("�Ҹ��� �� �� ����.");
	}
}
class Tiger extends Animal {
	@Override
	void cry() {
		System.out.println("����");
	}
}
class Cat extends Animal {
	@Override
	void cry() {
		System.out.println("�߿�");
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
		System.out.println("---�迭�� ��ĳ������ �̿��ؼ� switch ���� ��ü�� �� �ִ�.---");
		
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
		System.out.println("�Ҹ��� �� �� ����.");
	}
}
class Tiger extends Animal {
	@Override
	void cry() {
		System.out.println("����");
	}
}
class Cat extends Animal {
	@Override
	void cry() {
		System.out.println("�߿�");
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
//		s0 = "ȣ����";
//		s1 = "ȣ����";
//		s2 = "ȣ����";
//		s3 = "ȣ����";
		
//		String[] ar = new String[4]; // ��ü�� ������ ������ ���� �ƴ϶�, ��ü�� ������ �� �ִ� ���� 4���� ���� ��
//		ar[0] = "ȣ����0";
//		ar[1] = "ȣ����1";
//		ar[2] = "ȣ����2";
//		ar[3] = "ȣ����3";
		
		String[] ar = new String[] {"ȣ����0", "ȣ����1", "ȣ����2", "ȣ����3"}; // ��ü�� ������ ������ ���� �ƴ϶�, ��ü�� ������ �� �ִ� ���� 4���� ���� ��
		for (int i = 0; i < ar.length; i++) {
			System.out.println(ar[i]);
		}
		
//		Test[] br = new Test[4]; // ��ü�� ������ ������� ���� �ƴ϶�, Ŭ������ ���� �� �ִ� ������ 4�� ������� ��
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
//ex53) ��ĳ���� ���
class Aaa {
	void f1() {}
	void f3() { // ��ĳ���õ� ���, ������{}�� ������ ��, �ڽĿ� �������̵� �Ǿ��ִ��� Ȯ���ϰ� ���������� �����Ѵ�.
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
		t.f3(); // ������{}�� ������ ��, �ڽĿ� �������̵� �Ǿ��ִ��� Ȯ���ϰ� ���������� �����Ѵ�.
		t.f4(); // �������̵� �Ǿ� �ڽ��� f4()�� �����ϰ� �ȴ�.
		
		Bbb t2 = new Bbb();
		t.f3();
		t.f4();
	}
}
*/

/*
//ex52 **�߿�**) ������, ��ĳ����
class Aaa {
	void f1() {}
}
class Bbb extends Aaa {
	void f2() {}
}

public class Hello {
	public static void main(String[] args) {
		
		// (����)������ ���� ���� = (������)�޸� ��� ���� ����
		
		// 1. �θ� = �θ�
		// ��Ӱ� ���谡 ����.
		Aaa t1 = new Aaa();
		t1.f1();
		
		// 2. �θ� = �ڽ�
		// �� ĳ����
		Aaa t2 = new Bbb();
		t2.f1(); // f2() �޸𸮰� ������ ����� �� ����.
		
		// 3. �ڽ� = �θ�
		// �ٿ� ĳ���� -> �ڹ� ���� X
		// ���������δ� Aaa�� Bbb�� �ڵ带 ����� �� ������, 
		// ������ �޸𸮿� Aaa �ۿ� �����Ƿ� Bbb�� ������ ����Ϸ��� �ϸ� ������ �ȴ�.
//		Bbb t3 = new Aaa();
		
		// 4. �ڽ� = �ڽ�
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
		age = 10000; // � �����ڸ� ȣ���ϵ� age�� 10000�� �ȴ�.
		System.out.println(1);
	}
	Tiger(int a){
		this(); // �ٸ� �����ڸ� �̿��ϰ� ���� ���, �ݵ�� �ڵ� ù �ٿ� ���;��Ѵ�.
		num = a;
		System.out.println(2);
	}
	Tiger(int b, int c){
		this(b * c); // �ٸ� �����ڸ� �̿��ϰ� ���� ���, �ݵ�� �ڵ� ù �ٿ� ���;��Ѵ�.
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
// ��� Ŭ������ Object Ŭ������ ��ӹ޴´�.
// ��, ��� Ŭ������ �ڽ� Ŭ�����̴�.
// �����Ǿ� �־ �Ⱥ��δ�.
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
		
		// ��� ���� ���� ����Ű : F4
		Ccc t1 = new Ccc();
		
		String s;
		
	}
}
*/

/*
//ex49) this ���� 4
// �����ڰ� ȣ��Ǵ� ������� : �θ� > �ڽ� <=== �߸��� �ؼ�
//  - �ڽ��� �����ڰ� ���� ȣ��ǰ� ������ ���ο��� ���� ���� �θ� �����ڸ� ȣ���ϴ� ������ �ڵ尡 ����ȴ�.
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
		// �θ� �����ڸ� ���ϴ� �ڵ尡 �����Ǿ�����.
		// super();
		
		super(100); // �����ڸ� ���������� ����ϴ� ���
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
class Aaa { // ����
	void f1() { System.out.println(1); }
}
class Bbb extends Aaa { // �θ�
	
}
class Ccc extends Bbb { // �ڽ�
	
}
class Ddd extends Bbb { // �ڽ�
	
}
public class Hello {
	public static void main(String[] args) {
		
		Ccc t1 = new Ccc();
		
		t1.f1();
		
		
	}
}
*/

/*
//ex47) ���
class Aaa { // �θ�
	void f1() {
		System.out.println(1);
	}
	
	// �Լ� ����(prototype) : �������� ������ �Լ� �κ� ( void f3() )
	void f3() {
		System.out.println(31);
	}
	
	String f5(int a, int b, String t) {
		return null;
	}
}
class Bbb extends Aaa { // �ڽ�
	void f2() {
		System.out.println(2);
	}
	
	// �������̵� : �θ��� �Լ� ������ ���� ���
	@Override
	void f3() {
		System.out.println(32);
	}
	
	void f4() {
		f3();
		this.f3();
		super.f3(); // super : �θ�
	}
	
	// �������̵�
	@Override // �������̵��� ��� �Ϲ������� a notation ǥ���Ѵ�.
	// ���� �Լ��� �������̵���� ���� ��� ������ ���� �˷��ش�.
	String f5(int a, int b, String t) {
		return null;
	}
}

public class Hello {
	public static void main(String[] args) {
		Bbb t1 = new Bbb();
		t1.f1(); // 1
		t1.f2(); // 2
		t1.f3(); // 32, �ڽ��� f3�� ����ȴ�.
		System.out.println("------");
		
		t1.f4();
	}
}
*/

/*
//ex46-3) this ��� 3
class Man {
	void f1() {
		Women w = new Women();
		boolean result = w.marry(this);
		System.out.println(result ? "^^" : "�Ф�");
	}
	String ����() {
		return "����";
	}
}
class Women {
	boolean marry(Man info) {
		String str = info.����();
		return str == "����" ? false : true;
	}
}

public class Hello {
	public static void main(String[] args) {
		Man t1 = new Man();
		t1.f1();

		Control con = new Control();
//					   Hello ��ü
		con.makeButton(this, "�ؽ�Ʈ", "����"){ // ù �μ��� this�� ���, ���� ������ �� ������ �ʿ��ϴ�.
			this.ĥ�ϴ�();
		}
	}
	
	void ĥ�ϴ�() {
		
	}
}
*/

/*
//ex46-2) this ��� 2
class Tiger {
//	Tiger this; // �����Ǿ�������
	Tiger f1() {
		System.out.println("��ħ");
//		return new Tiger();
		return this;
	}
	
	Tiger f2() {
		System.out.println("����");
		return this;
	}
	
	void f3() {
		System.out.println("����");
	}
	
	
}

public class Hello {
	public static void main(String[] args) {
		
		Tiger t1 = new Tiger();
		t1.f1().f2().f3(); // f1()�� ���� t1�� ��ȯ�ǰ�, ��ȯ�� t1�� �ٽ� ü�̴��ؼ� f2()�� ȣ���Ѵ�.
		System.out.println("------");
		
		// f1, f2�� t1�� ��ȯ�ؼ� ü�̴����� �ٽ� �ҷ��� �� ������, f3�� ��� ��ȯ���� �ʾƼ� ü�̴��� �� ����.
//		t1.f1().f1().f2().f1().f3(); // ü�̴��� ���, �ٹٲ����� ���н����ش�. 
		
		t1.
		f1().
		f2().
		f3();
		
		// ü�̴����� ���� ���� ���, �� �޼ҵ� ���� ���踦 �������� �ʰ� ������ ��� �ڵ带 ������ �� �ְ� �ȴ�.
		// ����, �帧�� ���� �ʵ��� �ϰ����� �۾��� �䱸�� �� ü�̴��� ����Ѵ�. 
		t1.f1();
		System.out.println("������ ����"); // �������� �ڵ�
		t1.f2();
		t1.f3();
	}
}
*/

/*
//ex46-1) this ��� 1
// �Լ��� ���� �μ��� �ʵ带 �����ϱ� ���� �뵵 (������)
// �ڵ����� �����ϸ� ���� �޼ҵ� : ������, getter/setter, toString
class Tiger {
	String name;
	int age;
	
	public Tiger(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
//	Tiger(String name, int age){
//		this.name = name; // �ʵ� <= �μ�
//		this.age = age;
//	}
		
	void f1() {
//		System.out.println(name + " " + age); // ������ �� �Ʒ��� ���� this.�� �ٰ� ��
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
		
		Tiger t1 = new Tiger("ȣ����", 10);
		System.out.println(t1);
		t1.f3("������", 20);
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
		
//		this = ??? // ������ �ڵ�, new�� ��ü ���� �� ???�� ������ �̸�(t1, t2)���� ��ü�ȴ�.
		System.out.println(this.hashCode()); // 
	}

	//	Tiger this; // �⺻������ �ڵ尡 �����Ǿ� ������, ���� �ۼ����� ���� ����.
}

public class Hello {
	public static void main(String[] args) {
		
		Tiger t1 = new Tiger(); // ��ü ���� ��, �����ڿ��� this = t1 �ڵ尡 ���������.
		System.out.println(t1.hashCode());
		
		Tiger t2 = new Tiger(); // ��ü ���� ��, �����ڿ��� this = t2 �ڵ尡 ���������.
		System.out.println(t2.hashCode());
		
	}
}
*/

/*
//ex44)
class Tiger {
	// ��ü ������ �ʱ⿡ ����
	private Tiger() {
		
	}
}

public class Hello {
	public static void main(String[] args) {
		// Math�� ���, ��ü ���� ����� ���̱� ���� ��κ� �޼ҵ带 static ���
//		Math m = new Math(); // ����, ������ ��ü�� private���� �����ؼ� ��ü ������ �ʱ⿡ ������
//		m.abs();
		Math.abs(0); // ��ü�� �������� �ʾƵ� ����� �� �ִ� static �޼ҵ�
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
		
		System.out.println("������ ��ü ���� : " + Tiger.count);
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
		
//		f1(); // �޸𸮿� �ö��� ���� �ʾ� ����� �� ����.
		f2(); // �޸𸮿� �ö� �־� ����� �� �ִ�.
//		n1 = 10;
		n2 = 10;
		Hello h = new Hello();
		h.n1 = 10;
		h.n2 = 20;
		h.f1();
		h.f2();
		
		// ����, Hello ��ü�� 1��(main �޼ҵ忡�� ������ ��ü)
	}
}
*/

/*
//ex43-1)
// static �ȿ����� static�� ����� �� �ִ�.
class Tiger {
	int n1;
	static int n2;
	static void f1() {
		
		// static �޼ҵ��� ���, ���� �ʵ庸�� ���� �޸𸮿� �ö󰡹Ƿ� �޸𸮿� ���� �ö��� ���� ����ʵ带 ������ �� ����.
//		n1 = 100;
		n2 = 200; // static���� �Բ� �޸𸮿� �ö󰡹Ƿ� ���� �����ϴ�.
		
//		f2(); // ���� �޸𸮿� �ö��� �ʾ� ����� �� ����.
		f3(); // static���� �Բ� �޸𸮿� �ö󰡹Ƿ� ��� �����ϴ�.
	}
	
	void f2() {
		f3(); // static�� ���� f3�� �̹� �޸𸮿� �ö󰡹Ƿ� ����� �� �ִ�.
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
	
	// �ʵ�� �޼ҵ带 �ۼ��ص� �ƹ� ���� ����.
	int age;
	
	Hello() {
		
	}
	
	void f1() {
		
	}
	
	// ������(Entry Point)
	// ��ü�� �������� �ʾƵ�, static���� ���� �ܺη� ���� �޸𸮿� �ö󰣴�.
	// �׸���, main �޼ҵ带 OS���� ȣ���ؼ� �����ϰ� �ȴ�. ( Hello.main() )
	public static void main(String[] args) {
		
		Tiger t1 = new Tiger();
		
	}
	
	// �ʵ�� �޼ҵ带 �ۼ��ص� �ƹ� ���� ����.
	void f2() {
		
	}
}
*/

/*
//ex42-3)
class Tiger {

	// ��ü�� ������ ����, �޸𸮿� �ѹ��� �÷����� ���� ����Ѵ�.
	// �ӵ��� �䱸�ϴ� �޼ҵ��� ��� static�� �̿��ؼ� ��ü �������� ���ܽ���, ��ü ���� ����� ���δ�.
	static void f1() {
		
	}
	
	// ��ü�� ������ ����, �޸𸮿� �ѹ��� �÷����� ���� ����Ѵ�.
	void f2(){
		
	}
}

public class Hello {
	public static void main(String[] args) {
		
		// ��ü ���� �� ����� ���� ���� ���.
		// ����, �ӵ��� �䱸�ϴ� �޼ҵ��� ��� static�� �̿��ؼ� ��ü �������� ���ܽ�Ų��. 
		Tiger t1 = new Tiger();
		Tiger t2 = new Tiger();
		
	}
}
*/

/*
//ex42-2)
class Tiger {
	// static : ���赵(Ŭ����)�� ��������� �Ǹ� '1����' ����� ��
	// ������ �� �ܺη� ���������� ��.
	static int n1;
	int n2;
	
	static void ����ž() {
		System.out.println("��");
	}
	void ����() {
		
	}
}

public class Hello {
	public static void main(String[] args) {
		
		Tiger.����ž(); // ��ü�� ��� ��� ����
		Tiger t1 = new Tiger();
		t1.����(); // ��ü�� �־�� ��� ����
		t1.����ž(); // ��ü�� �־ ���� ����
		
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
	
	// getter, setter�� ��� �ַ� �� �� ó���Ѵ�. (�� �� ó�� ����Ű : ctrl + alt + j)
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
// Ŭ������ �����ϴ� ����� ����ϴ� ����� ����
// Ŭ������ ����ϴ� ����� Ŭ���� ���ο� ������ ��ġ�� �ʵ��� ������ �ʵ带 �� �� ���� �ϴ� ��찡 �Ϲ���
// ����, �ʵ忡 ���������� �������� ���ϵ��� ����, �޼ҵ带 ���ؼ� ������ �� �ֵ��� �Ѵ�.
class Tiger {
	// private : Ŭ���� ���ο����� ����ϴ� �ʵ� (������ ����)
	// ��������� ��� ��κ� ������
	private int age;
	private String name;
	
	void setName(String n) {
		name = n;
	}
	String getName() {
		return name;
	}
	
	// getter, setter �Լ�
	// Ŭ���� �������� ���忡��,
	// private�� ������� ���� ���, ���� �ʵ� ���ٿ� ���� ���ñ��� ���� �� ������,
	// private�� ����� ���, ���� �ʵ� ���ٿ� ���� ���ñ��� ���� �� �ִ�.
	// ���� �ʵ� ����� ���õ� �޼ҵ��� ���, ���Ǹ� ���� �ʵ� �ٷ� �Ʒ��� �ۼ��Ѵ�.
	int getAge() {
		return age;
	}
	void setAge(int data) {
		age = data;
	}
	
	Tiger(){
		age = 100;
	}
	
	// f3�� ���� �ۼ��� �޼ҵ�1
	private void f1() {
		
	}
	// f3�� ���� �ۼ��� �޼ҵ�2
	private void f2() {
		
	}
	void f3() {
		// f3�� ���θ� �и��ؼ� �ۼ��� ���
		f1();
		f2();
	}
}

public class Hello {
	public static void main(String[] args) {
		
		Tiger t1 = new Tiger();
		
		// ����ʵ�� ��ü�� �������Ѽ� ���� ����ϴ� ���� ���� ����.
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
	
	// �ٸ� �����ڸ� �ۼ������� ����Ʈ �����ڸ� �������� ���� ��� ������ ���Ƿ�,
	// ����Ʈ �����ڸ� �Ϲ������� �������� Ŭ������ �ۼ���.
	Tiger() {}
	Tiger(int data) {
		name = "�͸�";
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
		Tiger t2 = new Tiger("ȫ�浿", 200);
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
	int age;					 // �ʱ�ȭ���1 ���� ����
	Tiger() {					 // �ʱ�ȭ���2 ���� ����
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
// ������
// 1. ��� ���� : �ʵ� �ʱ�ȭ
// 2. ������ �޼ҵ�� �Ѵ�.
// 3. �Լ��� �̸��� �ݵ�� Ŭ���� �̸��� �����ؾ� �Ѵ�.
// 4. �μ��� ���޹��� �� ������, return�� ���� �� ����.
// 5. �μ������� ���� �����ڸ� ����Ʈ �����ڶ�� �Ѵ�.
// 6. ȣ���� new Ű���带 ����� ��, �� 1�� ȣ��Ǹ�, ���α׷��ӿ� ���Ƿ� ȣ���� �� ����.
// 7. �Լ��̱� ������ �����ε��� �����ϴ�.
// 8. ������ �ڵ带 �ۼ����� ������ �ڵ����� ����Ʈ �����ڰ� �ۼ��ȴ�.
//		- ������ �ڵ带 �ۼ��ϰ� �Ǹ� �ڵ����� ����Ʈ �����ڰ� �ۼ����� �ʴ´�.
class Tiger {
	// �ʵ�
	int age;
	
	// ����Ʈ ������
	Tiger() { // void�� ������
		System.out.println("������ ��");
		age = 100;
	}
	
	// �޼ҵ�
	
	
}

public class Hello {
	public static void main(String[] args) {
		System.out.println(1);
		Tiger t1 = new Tiger(); // ������ �ڵ� ȣ��
		System.out.println(2);
		Tiger t2 = new Tiger(); // ������ �ڵ� ȣ��
		System.out.println(3);
		
		System.out.println("------");
		for (int i = 0; i < 3; i++) {
			Tiger temp = new Tiger(); // ������ �ڵ� ȣ��
			System.out.println(temp.hashCode());
			
		}
	}
}
*/

/*
//ex38-2)�����ε� ��
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
	// ���� �̸��� ��� �ٸ��� �� �ʿ䰡 ����.
	
	
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
	// return Ÿ�����δ� �����ε��� �ȵȴ�.
	
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
// �����ε�(Overloading)
class Tiger {
	// �޼ҵ� ���� �����ϰ� ����� �� �ִ� ���
	void showMeTheMoney() {
		System.out.println(1);
	}
	
	// 1. �μ� ������ �ٸ� ���
	void showMeTheMoney(int i) {
		System.out.println(2);
	}	
	void showMeTheMoney(int a, int b) {
		System.out.println(3);
	}
	
	// 2. �μ� Ÿ���� �ٸ� ���
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
		t1.showMeTheMoney(3.0f); // float���� ����.
//		t1.showMeTheMoney(3); // int, float, short �� ���� ���� �˱� �����.
		t1.showMeTheMoney((float)3); // float���� ����.
		t1.showMeTheMoney((short)3); // short�� ����.
		
		
		
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
		// aaa == bbb == ccc, ��� ����.
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
		
		t3 = t1; // �̸��� �ٸ� ��, ������ �޸𸮸� ����Ű�� �ȴ�.
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
	
	// �ڱ� �ڽ��� �μ��� ���� �� �ִ�.
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
		t1.m1(10, "ȣ����", new Tiger(), new Lion());
		t1.m1(10, null, null, null);
	}
}
*/

/*
//ex34)
class Tiger {
	// �μ� ���� : ������Ƽ�� Ÿ��(8) + Ŭ����(���鸸����)
	void m1(float a, String s) {
//		System.err.println(a);
		System.out.println(a + " " + s);
		
		System.out.println(s.length());
	}
	
	String m2() {
		//return "ȣ����";
		String s = "������";
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
		t1.m1(3.14f, "ȣ����");
		
		t1.m2();
		
		// 2
		String s = t1.m2();
		System.out.println(s);
		
		// 3
		System.out.println(t1.m2());
		
		// ���� s2�� ��ü�� �ƴϴٶ�� ���� ��������� ǥ���Ѵ�.
		String s2 = null;
		
		String s3 = "�ڳ���";
		s3 = null; // ���̻� s3�� ��ü�� �ƴϴ�.
		
		
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
		
		// String : ���ڿ��� ���������� �����ϴ� Ŭ������, �ڹٿ��� �����ϴ� ǥ�� Ŭ�����̴�.
		// ���� ǥ��
		String s1 = new String();
		s1 = "ȣ����";
		System.out.println(s1);
		System.out.println(s1.length());
		
		// ��� ǥ��
		String s2 = "�޹���";
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
		int result = a + b; // �ʵ�� �μ��� �̸��� ���� ���, ���� ����(������ ����, ��, �μ�)�� ���� ����Ѵ�.
		System.out.println(result);
		// �ʵ��� a, b�� ����ϰ� �ʹٸ�, this Ű���� ���
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
		f1(); // ���� �޼ҵ��� ��� Ŭ������ ��Ī�� �ʿ䰡 ����.
		System.out.println(2);
	}
	void f3() {
		f2(); // ���� �޼ҵ��� ��� Ŭ������ ��Ī�� �ʿ䰡 ����.
		System.out.println(3);
	}
	
	// ��ȣȣ�� ���� : ���� ���� �÷ο� ������
	void f4() {
		System.out.println(4);
		f5();
	}
	void f5() {
		System.out.println(5);
		f4();
	}
	
	// ���ȣ��(recursive call) ����
	// �� ���� ������ �����ϴ�.
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
		
		//t1.f4(); // ��ȣȣ��� ���� ���� �߻�
		
		//t1.f6(); // ���ȣ��� ���� ���� �߻� 
	}
}
*/

/*
//ex30) ����
class Tiger {
	// ������ �ִ�. FuncName(){}
	// ....�� ����.
	// ������ ����.
	void func01() {
		
	}

	int func02() {
		System.out.println(1);
		return 100;
	}
	
	// �޼ҵ忡�� return Ű���带 ������ �Լ��� �ߴܵȴ�.
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
	
	// void ������ return Ű���带 ����� �� �ִ�.
	void func04() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			if( i == 5) {
//				break;
				return;
			}
			
		}
		System.out.println("for�� �ߴܵ�");
	}
	
	// 4��° ����
	int func05(int num) {
		
		
		//return num * num;
		int result = num * num;
		if(result < 0) {
			
		}
		return result;
	}
	
	int func06(int num) {
//		System.out.println(num*num); // ���� �����ؼ� Ȱ���� �� �ֵ��� �ϱ� ���� ��¹��� �޼ҵ忡�� ������.
		return num * num;
	}
	
	// ��Ģ�� �����.
	// -1�� ���ϵ� ���� ������ ����̴�.
	// +1�� ���ϵ� ���� ������ ����̴�.
	int func07(int num) {
		if(num < 0) {
//			System.out.println("����");
			return -1;
		}
		
		if(num % 2 == 0) {
			System.out.println("¦");
		}else {
			System.out.println("Ȧ");
		}
		
		return 1;
	}
}

public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		// 1. �ܸ�
		t1.func02();
		
		// 2.
		int num = t1.func02(); // 100
		System.out.println(num);
		// System.out.println(100);
		
		// 3.
		System.out.println(t1.func02());
		// System.out.println(100);
		
		// ����
//		System.out.println(t1.func01()); // func01()�� ������ ��� ����� �� ����.
		
		t1.func04();
		System.out.println(t1.func05(4));
		
		System.out.println(t1.func06(5) + t1.func06(3)); // ���� �����ؼ� Ȱ���� �� �ֵ��� �ϱ� ���� ��¹��� �޼ҵ忡�� ������.
		
		if( t1.func07(-4) == -1) {
			System.out.println("�����Դϴ�.");			
		}
	}
}
*/

/*
//ex29)
class Tiger{
	
	void m1() {
		System.out.println("��");
	}
	
	void m2(int num) { // = ���� ������ �Ͼ
		
		System.out.println("��" + num);
	}
	
	void m3(int num) { // = ���� ������ �Ͼ
		for (int i = 0; i < num; i++) {
			System.out.print("��");
		}System.out.println();
	}
	
	void m4(int a, int b) { // = ���� ������ �Ͼ
		System.out.println(a + " " + b);
		System.out.println(a * b);
	}
	
	// �Ϲ������� �簢���� �׷��� ��, ����, ���� ������ �Է��Ѵ�.
	void m5(int width, int height, char ch, boolean b) { // = ���� ������ �Ͼ
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
				); // ���ΰ� ������ ���, �������� ���� ���� �ٷ� �ۼ��Ѵ�.
				
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
		
		// �Ϲ������� �簢���� �׷��� ��, ����, ���� ������ �Է��Ѵ�.
		t1.m5(5, 4, '*', true);
		
		t1.m6(19);
		t1.m7(5);
		
		t1.m8(8,  7, '��', '��');
	}
}
*/

/*
//ex28)
class Tiger{
	// �޼ҵ� ����
	// 1. void f1() {}
	// 2. void f1(int a) {}
	// 3. int f1() {}
	// 4. int f1(int a) {}
	
	// 1. ���Ͼ��� f1(�μ����� ����) {}
	// 2. ���Ͼ��� f1(�μ����� ����) {}
	// 3. �����ִ� f1(�μ����� ����) {}
	// 4. �����ִ� f1(�μ����� ����) {}
	
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
		
		// �ڵ��� ��Ȱ�� 
		// �Լ�(�޼ҵ�) : ���� ���Ǵ� �ڵ带 �����ؼ� ��Ȱ���Ѵ�.
		
		Tiger t1 = new Tiger();
		System.out.println(1000);
		t1.method01(); // �Լ� ȣ��
		System.out.println(2000);
		t1.method01(); // �Լ� ȣ��
		System.out.println(3000);
		
		Tiger t2 = new Tiger();
		t2.method01();
		
		t2.method02();
	}
}
*/

/*
//ex27)
// ���������� Ŭ���� ù���ڴ� �빮��
class Airplane{ // ���赵
	// ��� ����
	// 1. �ʵ�(����) >> �Ӽ�
	int a;
	float b;
	int seat;
	int[] ar = new int[4];
	
	int num = 99;
	
	// 2. ������
	
	// 3. �޼ҵ�(�Լ�)
	
}

public class Hello {
	public static void main(String[] args) {
//		Airplane a = new Airplane();
//		Airplane airplane = new Airplane(); // Airplane ���� �ڵ� �ϼ� ��, ù���� �ҹ��ڷ� �������� �����.
		// ���� ����Ⱑ ���������.
		
		Airplane air = new Airplane(); // new ���� �ڵ� �ϼ� ��, �հ� �ڿ� ���� Ÿ������ Ÿ������ �� �ִ�.
		Airplane air2 = new Airplane(); // new ���� �ڵ� �ϼ� ��, �հ� �ڿ� ���� Ÿ������ Ÿ������ �� �ִ�.
		
//		air.a = 10; // . -> ü���̶�� �θ�
		air.b = 20.0f;
		air.seat = 30;
		System.out.println(air.a); // ���� �ڵ����� �ʱ�ȭ��
		System.out.println(air.b);
		
		air2.seat = 40;
		// ������ ���� �ٸ� �޸� �̴�.
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
		
		air.ar = new int[8]; // air.ar �ʱ�ȭ
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
		ar = new int[20]; // ar 10���� ������� 20���� ���� �����ȴ�.
		
		// �޸� �ݳ� �ڵ� : �ڹٰ� �ڵ����� �ݳ������༭ �Ű澲�� �ʾƵ� ��.
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
		
		// ������ �� : ������ ���Ű� ����� �ϳ��� ���� �ʴ´�. ���Ű� ��� ���̿� ���� �ڵ尡 ���� ��찡 ���� �� �ֱ� ����.
		
		for (int i = 0; i < ar.length; i++) {
			ar[i] = rnd.nextInt(20);
			System.out.print(ar[i] + " ");
		}System.out.println();
		
		
		// ������ ����(�ʱ�ȭ)
		for (int i = 0; i < ar.length; i++) {
			ar[i] = rnd.nextInt(20);
		}
		// ������ ���
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
		
		// �迭
		// 1. ����
		int[] arr = new int[10]; // 0���� �ʱ�ȭ
		
		// 2.
		int[] brr = new int[] {10, 20, 30}; // ������ ������ �ʱ�ȭ
		
		// 3.
		int[] crr = {40, 50, 60};
		
		// arr�� ������ 10�� �ִ�.
		arr[0] = 10;
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		
		arr[9] = 20;
		System.out.println(arr[9]);
		
		// 0 - 9
		// arr[-5] = 100; // �ߴܵ� : ArrayIndexOutOfBoundsException
		
		// ���� ��� �� ������� ����
		int num = 4;
		arr[num * 2 - 7] = 999;
		System.out.println(arr[1]);
		
		// �迭 ���ڷ� �迭 ����
		arr[5] = 7;
		arr[7] = 777;
		arr[arr[5] * 2 - 7] = 888;
		System.out.println(arr[7]);
		
		// �迭 ���� ��ȯ �޼ҵ� 
		System.out.println("------");
		System.out.println(arr.length);
		
		//
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}System.out.println(); // for���� ��¹��� ���н����ֱ� ���� ����ϹǷ� for���� �ٿ��ش�.
		
		System.out.println("������");
	}
}
*/

/*
//ex24)
public class Hello {
	public static void main(String[] args) {
		
		//�Ϲ����� switch ����
		Random rnd = new Random();
		
		int num = rnd.nextInt(30); // nextInt(2) : 0~1���� �� ���� ��ȯ
		switch (num % 2) {
		case 0:{
			for (int i = 0; i < 10; i++) {
				System.out.println(num + " * " + i + " = " + num * i);
			}	
		}break; // case�� ������ �� ���� �ʰ��� ���, �Ϲ������� {}�� ���� break�� ��ܼ� ����.
		
		case 1:{
			int sum = 0;
			for (int i = 1; i <= num; i++) {
				sum += i;
			}
			System.out.println(num + "������ ���� : " + sum);
		}break;

		default: break; // default�� ������ ���� ���, �Ϲ������� break�� ��ܼ� ����.
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
		case 10: //break; // 100���� ��� �ǵ������� break�� ������ ǥ���Ѵ�.
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
		//1. switch �ȿ� ������ ����� �� �ִ�.
		//2. case �ڿ� ������ ����� �� ����.
		//3. break�� �����ϸ� switch�� ���������� �ʴ´�.
		//4. �����ϴ� �б⹮�� �������� default�� �̵��Ѵ�.
		//5. ����, ����, ���ڿ� ��� �бⰡ �����ϴ�.
		//6. �ǵ������� break�� �����ϱ⵵ �Ѵ�.
		
		int num = 20;
		char ch = '��';
		
		switch (num) {
		//case nn: (x)
		case 10:
			System.out.println(1);
			//break;
		
		case 20:
			System.out.println(1);
			break;
		
		case '��':
			System.out.println(1);
			break;

		default:
			System.out.println("ȣ����");
			break;
		}
		
	}
}
*/

/*
//ex21)
public class Hello {
	public static void main(String[] args) {
		//���� �߻� ���1 : Random Ŭ����
		Random rnd = new Random();
		int num = rnd.nextInt(); // Int ���� ���� ���� ��ȯ
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
		
		// ����Ƚ���� �˱� ����� �� : ��ڼ�
		int num = 17;
		
		while(true) {
			System.out.println(num);
			
			
			if(num % 2 == 0) {
				num = num / 2;
			} else {
				num = num * 3 + 1;
			}
			// if�� else�� ���� ������ ��� => �������� ����
			
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
		
		//while : �ݺ�Ƚ���� �˰� �ۼ��ϴ� for���� �޸�, �ݺ�Ƚ���� ���� ���� ��� ���

		// �߸��� ��1 : ���� ����
		
		int num = 0;
		while(true) {
			System.out.println(num);
		}
				
		
		// �߸��� ��2 : �ݺ�Ƚ���� �˰� �ִµ� while���� ����� ���
		
		int num = 0;
		while(num < 4) {
			System.out.println(num);
			num++;
		}
		
		
		// �ùٸ� �� : true�� break�� while�� ����
		int num = 0;
		num = 0;
		while(true) {
			if(num == 4) {
				System.out.println("Ż�� ��");
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

		// ���� for���� ��� �簢�� ������ ����
		for (int i = 0; i < 3; i++) { // ����

			for (int j = 0; j < 4; j++) { // ����
				System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();

		for (int i = 0; i < 3; i++) { // ����

			for (int j = 0; j < 4; j++) { // ����
				System.out.print("[" + i + " " + j + "]");
			}
			System.out.println();
		}
		System.out.println();

		// if���� else���� ���� ������ ����� ���, ������ ���׿������� �����Ѵ�.
		int result;
		if (3 > 2) {
			result = 10;
		} else {
			result = 20;
		}

		// �������� ������ ��
		result = (3 > 2) ? 10 : 20;

		// O, X�� �簢�� ǥ�� ������ �������� ����
		int width = 8, height = 7;
		for (int i = 0; i < height; i++) { // ����

			for (int j = 0; j < width; j++) { // ����
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

		// �޼ҵ� �� return�� �������� ������ ���
		
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
		
		int num = 7; // for�� ������ �ڵ�� �ǵ帮�� �ʰ� �ܺ��� ���� ���� ������ �� �ְ� �Ѵ�.
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
		

		// 2�� 8��
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
		
		// for���� ��� ������ �Ѵ��� �� �� �־���Ѵ�.
		// for�� ������ ������ ���� ����, for���� ���� ���� �����ؾ��Ѵ�.
		// ���� 1 : ���Ǹ�ŭ ����.(4)
		for (int i = 0; i < 4; i++) {
			System.out.println(i);
		}
		
		// ���� 2 : ���Ǹ�ŭ ����.(4)
		for (int i = 1; i <= 4; i++) {
			System.out.println(i);
		}
		
		// ���� 3 : ���� * 2 + 1 ��ŭ ����.(7)
		// �������� ����� �ٲ�� ��� �ַ� ���
		for (int i = -3; i <= 3; i++) {
			System.out.println(i);
		}
		
		
		// �߸��� ��1
		for (int i = 32; i <= 100; i+=8) {
			System.out.println(i);
		}
		
		// �߸��� ��2
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
		
		// else if : �ӵ��� ����ȭ�� ���Ͼ�Ƿ� ������ switch�� �ٲٴ� ��찡 ����.
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
		
		// �߸��� �� : if�� else�� �ʹ� �پ��� �۾��� ������ -> �ܼ�ȭ�� �ʿ�.
		
		int password = 1234;
		if(password != 1234) {
			System.out.println("Ʋ��");
		} else {
			System.out.println("����");
			System.out.println("������ �α��� �Ͽ���");
			System.err.println("���� ���� Ȯ��");
		}
		
		
		// ������ ��
		
		if(password != 1234) {
			System.out.println("Ʋ��");
			break;
			exit();
			return;
		}
		
		System.out.println("����");
		System.out.println("������ �α��� �Ͽ���");
		System.err.println("���� ���� Ȯ��");
		
		
		// �߸��� �� : ����ð��� ��쿡 ���� �޶��� -> ����ð� ���� �� �Ҿ�����
		
		int nn = 10;
		while(true) {
			if(nn < 0) {
				nn = -nn;
				// sin();
			}
		}
		
		
		// ������ �� : sin()�� ��� ����� �� ���� ���� �� �ӵ����̰� ���ϹǷ� �������� ������ ���� �Ϻη� �����ش�.
		
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
		// do while(������)
		
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
		n = n + 10; // 30 ������ �ӵ��� �� ������. ����ӵ��� ����.
		n += 10; // 40 (���մ��࿬����) ������ �ӵ��� �� ������. ����ӵ��� ����.
		n = n + 1;
		n += 1;
		n++; // 43 (���׿�����) ���� �ӵ��� ���� ������.
		++n; // 44 ���� �ӵ��� ���� ������.
		
		int a, b;
		n = 10;
		a = n++; // 10, ���� ����
		System.out.println(a + " " + n);
		
		n = 10;		
		b = ++n; // 11, ���� ����		
		System.out.println(b + " " + n);
	}
}
*/

/*
//ex8)
public class Hello {
	public static void main(String[] args) {
		
		//1. ���� �̸��� �ߺ��� �� ����.
		int apple;
		// int apple; (x)
		
		//2. ��� ���еȴ�.
		int Apple;
		
		//3. ù ���ڰ� ���ڰ� �ƴ� �� ���� ��� ����
		int Apple123;
		//int 9Apple; (x)
		
		//4. _�� $ �� �����ϸ� Ư������ ���Ұ�
		int apple_num;
		int _34; // ��Ŀ��� 3�� 4���� ǥ���ϴ� ���
		
		//5. �ѱ� ��� ����(������ ���Ѵ�)
		int ��� = 10;
		System.out.println(���);
		
		//6. �� �ܾ� �̻� �ռ� �ÿ��� ī��ǥ���
		int BananaNumber = 10; // ��� 1
		int bananaNumber = 10; // ��� 2 (�Ϲ���)
		
	}
}
*/

/*
//ex)
public class Hello {
	public static void main(String[] args) {
		
		// ���� �ּ� ���� ����Ű : ctrl + shift + /
		// ���� �ּ� ���� ����Ű : ctrl + shift + \
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
	
		// ���� ���� ǥ�� ������Ƽ�� Ÿ�� : byte(1), short(2), int(4), long(8)
		// ������ ǥ�� ������Ƽ�� Ÿ�� : boolean(1), char(2, ���������� ����), float(4, �Ҽ���), double(8)
		
		// �޸� �䱸
		byte apple; // 1byte �޸𸮸� apple�� �۸��ؼ� �䱸
		apple = 10; // ���Կ���(=)
		System.out.println(apple);
		
		apple = 20;
		System.out.println(apple);
		
//		apple = 200; // ���� : 1byte�� ũ�Ⱑ 127���� �ۿ� �ȵ�
//		apple = 128; // ���� : 1byte�� ũ�Ⱑ 127���� �ۿ� �ȵ�
		apple = 127;
		System.out.println(apple);
		
		short banana = 20; // short : Ÿ��, banana : ����(variable), = : ���Կ�����, 20 : ���ͷ�
		
		int orange = 222222222;
		
		long kiwi = 22222222;
		
		// boolean(1), char(2, ���������� ����), float(4, �Ҽ���), double(8)
		boolean t1 = true; // true Ȥ�� false
		char t2 = 'A';
		char t3 = '��';
		char t4 = 65; // ������ ���Ѵ�. ������ ������
		System.out.println(t2);
		System.out.println(t3);
		System.out.println((int)t2);
		System.out.println((int)t3);
		System.out.println((char)(t3+1));
		System.out.println((int)Character.MIN_VALUE); // char�� ���������� �������� �ʴ´�.
		System.out.println((int)Character.MAX_VALUE); // char�� ���������� �������� �ʴ´�.
		
		float t5 = 3.14f; // float Ÿ���� �� �������� f �ٿ������
		double t6 = 3.14;
		
		float sum = 0.0f;
		for (int i = 0; i < 100; i++) {
			sum = sum + 0.1f;
		}
		System.out.println(sum); // 10.000002 : ���� �߻�
//		if(sum == 10.0f) // ����� �� ����
		
	}
}
*/

/*
//ex6)
public class Hello {
	public static void main(String[] args) {
		
		// �ڵ� �� ���� ����Ű : ctrl + i

		System.out.println(Byte.MIN_VALUE); // 1 Byte�� ���� �� �ִ� �ּҰ�
		System.out.println(Byte.MAX_VALUE); // 1 Byte�� ���� �� �ִ� �ּҰ�

		System.out.println("-------");
		
		// 2 Byte = 1 Short
		System.out.println(Short.MIN_VALUE); // 2 Byte�� ���� �� �ִ� �ּҰ�
		System.out.println(Short.MAX_VALUE); // 2 Byte�� ���� �� �ִ� �ּҰ�
		
		System.out.println("-------");
		
		// 4 Byte = 1 Integer
		System.out.println(Integer.MIN_VALUE); // 4 Byte�� ���� �� �ִ� �ּҰ�
		System.out.println(Integer.MAX_VALUE); // 4 Byte�� ���� �� �ִ� �ּҰ�
		
		System.out.println("-------");
		
		// 8 Byte = 1 Long
		System.out.println(Long.MIN_VALUE); // 8 Byte�� ���� �� �ִ� �ּҰ�
		System.out.println(Long.MAX_VALUE); // 8 Byte�� ���� �� �ִ� �ּҰ�
		
	}
}
*/

/*
//ex5)
public class Hello {
	public static void main(String[] args) {
		
		//������ || : OR
		System.out.println(false || false);
		System.out.println(false || true);
		System.out.println(true || false);
		System.out.println(true || true);
		
		System.out.println("---------");
		
		//������ && : AND
		System.out.println(false && false);
		System.out.println(false && true);
		System.out.println(true && false);
		System.out.println(true && true);

		// ���� ���� : ��� > ���� > ��
		System.out.println(3+2 > 7 && 2+6 < 8);
		
		System.out.println("---------");
		
		//������ ! : ����
		System.out.println(!true);
		System.out.println(!(3>2));		
		
		
	}
}
*/

/*
//ex4)
public class Hello {
	public static void main(String[] args) {
		
		// ���迬���� true Ȥ�� false ��ȯ
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
		
		System.out.println(3+4*5); // �켱������ ���� ��������
		System.out.println((3+4)*5); // �켱������ ���� ��������
		System.out.println(2+3*4+5); // �켱������ ���� ��������
		
		
	}
}
*/

/*
// ex2)
public class Hello {
	public static void main(String[] args) {
		
		System.out.println(100); // ����
		System.out.println('��'); // ���� (''�� ��������� ������)
		System.out.println("ȣ����"); // ���ڿ�
		
		System.out.println(100 + 200); // ���� + ���� (�������)
		System.out.println(100 + "ȣ����"); // ���� + ���ڿ� (���ڿ�����)
		System.out.println("ȣ����" + 100); // ���ڿ� + ���� (���ڿ�����)
		System.out.println("ȣ����" + "����"); // ���ڿ� + ���ڿ� (���ڿ�����)
		
		System.out.println("100"); // ���ڿ�
		System.out.println("100" + 100); // ���ڿ� + ���� (���ڿ�����)
		System.out.println(10 + 20 + "ȣ����"); // ���� + ���� + ���ڿ� (�������� ���� : ������� �� ���ڿ�����)
		System.out.println("ȣ����" + 10 + 20); // ���ڿ� + ���� + ���� (�������� ���� : ���ڿ����� �� ���ڿ�����)
		System.out.println(10 + " " + 20); // ���� + ���ڿ� + ���� (�������� ���� : ���ڿ����� �� ���ڿ�����)
		System.out.println(10 + " " + 20 + " " + 30); // ���� + ���ڿ� + ���� (�������� ���� : ���ڿ����� �� ���ڿ�����)
		
		System.out.println(10 + 'A'); // ���� + ���� (������� �� ���ڴ� �ƽ�Ű�ڵ�� ġȯ��)
		System.out.println(1 + 'A'); // ���� + ���� (������� �� ���ڴ� �ƽ�Ű�ڵ�� ġȯ��)
		
		System.out.println((char)(1 + 'A')); // type casting
		
	}
}
*/

/*
// ex1)
public class Hello {
	public static void main(String[] args) {
		
		// �ڹٿ��� �Լ��� �޼ҵ�� Ī�Ѵ�.
		// �ڵ带 ����� ��ȯ�ϴ� �۾� : ������ (����Ű : ctrl + f11)
		// �ڵ� ���� ����Ű : ctrl + alt + ��, �Ʒ�
		// �ڵ� �̵� ����Ű : alt + ��, �Ʒ�
		// �ּ� ����Ű : ��� �� ctrl + / 
		System.out.println(1000);
		System.out.println();
	}
}
*/