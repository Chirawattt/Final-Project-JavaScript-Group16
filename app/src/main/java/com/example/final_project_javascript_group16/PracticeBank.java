package com.example.final_project_javascript_group16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PracticeBank {
    // Map<LessonNumber, List<PracticeQuestion>>
    private static HashMap<Integer, List<PracticeQuestion>> practiceMap = new HashMap<>();

    static {
        loadLesson1();
        loadLesson2();
        loadLesson3();
        loadLesson4();
        loadLesson5();
    }

    private static void loadLesson1() {
        List<PracticeQuestion> lesson1 = new ArrayList<>();

        // ง่าย
        lesson1.add(new PracticeQuestion(
                "ง่าย: ประกาศตัวแปรชื่อ age และกำหนดค่าเป็น 25",
                "25", 0,
                "let age = 25;\nreturn age;"
        ));

        // ปานกลาง
        lesson1.add(new PracticeQuestion(
                "ปานกลาง: ประกาศตัวแปร name ให้มีค่า 'John' และแสดงผลลัพธ์",
                "John", 1,
                "let name = 'John';\nreturn name;"
        ));

        // ยาก
        lesson1.add(new PracticeQuestion(
                "ยาก: สร้างอาร์เรย์ชื่อ colors ที่เก็บ 'red', 'green', 'blue' แล้วแสดงค่าที่ index 1",
                "green", 2,
                "let colors = ['red', 'green', 'blue'];\nreturn colors[1];"
        ));

        practiceMap.put(1, lesson1);
    }

    private static void loadLesson2() {
        List<PracticeQuestion> lesson2 = new ArrayList<>();

        // ง่าย
        lesson2.add(new PracticeQuestion(
                "ง่าย: ประกาศตัวแปร x ด้วย let แล้วกำหนดค่าเป็น 10",
                "10", 0,
                "let x = 10;\nreturn x;"
        ));

        lesson2.add(new PracticeQuestion(
                "ปานกลาง: ใช้ const ประกาศตัวแปรชื่อ pi แล้วกำหนดค่า 3.14 และแสดงผล",
                "3.14", 1,
                "const pi = 3.14;\nreturn pi;"
        ));

        lesson2.add(new PracticeQuestion(
                "ยาก: ประกาศตัวแปร let ชื่อ message ใน block และแสดง message นอก block",
                "null", 2,
                "// โค้ดนี้จะ Error\n{\n  let message = 'Hi';\n}\nreturn message;"
        ));

        practiceMap.put(2, lesson2);
    }

    private static void loadLesson3() {
        List<PracticeQuestion> lesson3 = new ArrayList<>();

        // ง่าย
        lesson3.add(new PracticeQuestion(
                "ง่าย: สร้างตัวแปร x = 5, y = 3 แล้วแสดงผลลัพธ์ของ x + y",
                "8", 0,
                "let x = 5;\nlet y = 3;\nreturn x + y;"
        ));

        lesson3.add(new PracticeQuestion(
                "ปานกลาง: สร้างตัวแปร score = 80 แล้วใช้ ternary operator เพื่อแสดง 'Pass' ถ้า score >= 50 มิฉะนั้นแสดง 'Fail'",
                "Pass", 1,
                "let score = 80;\nreturn score >= 50 ? 'Pass' : 'Fail';"
        ));

        lesson3.add(new PracticeQuestion(
                "ยาก: ให้ x = 5, y = '5' ใช้ === ตรวจว่า x === y แล้วแสดงผลลัพธ์",
                "false", 2,
                "let x = 5;\nlet y = '5';\nreturn x === y;"
        ));

        practiceMap.put(3, lesson3);
    }

    private static void loadLesson4() {
        List<PracticeQuestion> lesson4 = new ArrayList<>();

        // ง่าย
        lesson4.add(new PracticeQuestion(
                "ง่าย: เขียนคำสั่ง if เพื่อตรวจว่า x = 10 มากกว่า 5 หรือไม่ ถ้าใช่ ให้แสดง 'Yes'",
                "Yes", 0,
                "let x = 10;\nif (x > 5) {\n  return 'Yes';\n}"
        ));

        lesson4.add(new PracticeQuestion(
                "ปานกลาง: ใช้ for loop เพื่อรวมเลข 1 ถึง 3 เป็นข้อความเดียวแล้วแสดงผล",
                "123", 1,
                "let result = '';\nfor (let i = 1; i <= 3; i++) {\n  result += i;\n}\nreturn result;"
        ));


        lesson4.add(new PracticeQuestion(
                "ยาก: ใช้ try...catch ตรวจจับ error จากตัวแปรที่ยังไม่ได้ประกาศ แล้วแสดง 'Caught Error'",
                "Caught Error", 2,
                "try {\n  return notDeclared;\n} catch (e) {\n  return 'Caught Error';\n}"
        ));

        practiceMap.put(4, lesson4);
    }

    private static void loadLesson5() {
        List<PracticeQuestion> lesson5 = new ArrayList<>();

        // ง่าย
        lesson5.add(new PracticeQuestion(
                "ง่าย: สร้างฟังก์ชันชื่อ greet ที่ return คำว่า 'Hello'",
                "Hello", 0,
                "function greet() {\n  return 'Hello';\n}\nreturn greet();"
        ));

        lesson5.add(new PracticeQuestion(
                "ปานกลาง: สร้าง arrow function ที่รับชื่อ name และ return 'Hi, [name]' โดย name = 'Kaning'",
                "Hi, Kaning", 1,
                "const sayHi = name => 'Hi, ' + name;\nreturn sayHi('Kaning');"
        ));

        lesson5.add(new PracticeQuestion(
                "ยาก: เขียน recursive function ที่คำนวณค่า factorial ของ 4 และแสดงผลลัพธ์",
                "24", 2,
                "function factorial(n) {\n  if (n <= 1) return 1;\n  return n * factorial(n - 1);\n}\nreturn factorial(4);"
        ));

        practiceMap.put(5, lesson5);
    }


    public static PracticeQuestion getQuestion(int lessonNumber, int difficultyLevel) {
        List<PracticeQuestion> list = practiceMap.get(lessonNumber);
        for (PracticeQuestion q : list) {
            if (q.getDifficultyLevel() == difficultyLevel) {
                return q;
            }
        }
        return null;
    }
}