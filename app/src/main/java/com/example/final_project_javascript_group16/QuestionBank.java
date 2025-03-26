package com.example.final_project_javascript_group16;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank {

    public static List<Question> getQuestions(int lessonNumber) {
        List<Question> questions = new ArrayList<>();

        switch (lessonNumber) {
            case 0: // บทที่ 1
                questions.add(new Question(
                        "ข้อใดคือชนิดข้อมูลพื้นฐานใน JavaScript?",
                        new String[]{"Number, String, Boolean", "Class, Object, Function", "Integer, Char, Boolean", "Document, Window, Event"},
                        0
                ));

                questions.add(new Question(
                        "ชนิดข้อมูล 'String' ใช้สำหรับเก็บอะไร?",
                        new String[]{"ค่าความจริง", "ข้อความ", "ตัวเลข", "ค่าว่าง"},
                        1
                ));

                questions.add(new Question(
                        "ค่าของตัวแปรที่ยังไม่ได้กำหนดจะมีค่าอะไร?",
                        new String[]{"null", "undefined", "0", "\"\""},
                        1
                ));

                questions.add(new Question(
                        "ข้อใดคือค่าของชนิด Boolean ที่ถูกต้องใน JavaScript?",
                        new String[]{"yes, no", "1, 0", "true, false", "on, off"},
                        2
                ));

                questions.add(new Question(
                        "ชนิดข้อมูล Null ใช้แทนสิ่งใด?",
                        new String[]{"ค่าที่ไม่ใช่ตัวเลข", "ค่าที่ไม่สามารถเปลี่ยนแปลงได้", "ค่าที่ไม่มีอยู่", "ค่าที่ไม่ได้กำหนด"},
                        2
                ));

                questions.add(new Question(
                        "ข้อใดคือความแตกต่างของ Primitive type และ Reference type?",
                        new String[]{
                                "Primitive ถูกเปลี่ยนค่าได้, Reference ไม่ได้",
                                "Primitive คัดลอกค่า, Reference ชี้ไปยังที่อยู่ในหน่วยความจำ",
                                "Reference ใช้กับตัวเลขเท่านั้น",
                                "Primitive เหมาะกับข้อมูลขนาดใหญ่"
                        },
                        1
                ));

                questions.add(new Question(
                        "ชนิดข้อมูลใดต่อไปนี้จัดเป็น Reference type?",
                        new String[]{"String", "Number", "Array", "Boolean"},
                        2
                ));

                questions.add(new Question(
                        "Object ใน JavaScript มีลักษณะอย่างไร?",
                        new String[]{
                                "เก็บค่าหลายค่าในตัวแปรเดียว โดยไม่ต้องมี key",
                                "เก็บข้อมูลแบบ key-value",
                                "ใช้แทนค่าทางคณิตศาสตร์",
                                "เก็บได้แค่ข้อความเท่านั้น"
                        },
                        1
                ));

                questions.add(new Question(
                        "ข้อใดคือวิธีเข้าถึงค่าจาก object ชื่อ person ที่มี key เป็น name?",
                        new String[]{
                                "person[name]",
                                "person->name",
                                "person.name",
                                "person:name"
                        },
                        2
                ));

                questions.add(new Question(
                        "Array ใน JavaScript มี index เริ่มต้นที่เท่าไหร่?",
                        new String[]{"1", "0", "-1", "ไม่แน่นอน"},
                        1
                ));
                break;


            case 1:
                questions.add(new Question(
                        "คำว่า \"ตัวแปร\" (Variable) ใน JavaScript ใช้เพื่ออะไร?",
                        new String[]{"เก็บข้อมูลในหน่วยความจำ", "แสดงข้อความบนหน้าเว็บ", "สร้างปุ่ม", "โหลดไฟล์ภายนอก"},
                        0
                ));

                questions.add(new Question(
                        "คีย์เวิร์ดใดใช้สำหรับประกาศค่าคงที่ใน JavaScript?",
                        new String[]{"var", "let", "const", "static"},
                        2
                ));

                questions.add(new Question(
                        "ข้อใดกล่าวถูกต้องเกี่ยวกับ var?",
                        new String[]{"มี block scope", "ไม่สามารถประกาศซ้ำ", "ถูก hoisting และมีค่า undefined", "ใช้แทน const ได้เลย"},
                        2
                ));

                questions.add(new Question(
                        "let และ const ต่างจาก var อย่างไร?",
                        new String[]{"ไม่ถูก hoisting", "อยู่ใน block scope", "ใช้กับ object เท่านั้น", "ทำงานเร็วกว่า"},
                        1
                ));

                questions.add(new Question(
                        "Hoisting คืออะไร?",
                        new String[]{
                                "การทำให้ฟังก์ชันรันเร็วขึ้น",
                                "การจัดการหน่วยความจำ",
                                "การย้ายตัวแปรไปประกาศไว้บนสุดของ scope",
                                "การแสดงผลค่าทั้งหมดในตัวแปร"
                        },
                        2
                ));

                questions.add(new Question(
                        "เมื่อใช้ const ต้องทำอย่างไร?",
                        new String[]{"สามารถเปลี่ยนค่าได้ภายหลัง", "ไม่ต้องกำหนดค่าเริ่มต้น", "ต้องกำหนดค่าเริ่มต้น และเปลี่ยนไม่ได้", "ใช้ได้แค่กับ array"},
                        2
                ));

                questions.add(new Question(
                        "ข้อใดเป็นชื่อของตัวแปรที่ไม่ถูกต้องตามกฎ?",
                        new String[]{"let name1 = 'John';", "let _total = 100;", "let 1name = 'Alice';", "let $price = 50;"},
                        2
                ));

                questions.add(new Question(
                        "ตัวแปรใน JavaScript เป็นแบบ Case-Sensitive หมายถึงอะไร?",
                        new String[]{
                                "ตัวแปรพิมพ์ใหญ่เล็กถือว่าเหมือนกัน",
                                "สามารถใช้ตัวอักษรพิเศษได้",
                                "ตัวแปร name และ Name เป็นคนละตัวกัน",
                                "ใช้ได้เฉพาะตัวพิมพ์เล็ก"
                        },
                        2
                ));

                questions.add(new Question(
                        "ข้อใดคือคำสงวน (Reserved Keyword) ที่ไม่ควรใช้เป็นชื่อตัวแปร?",
                        new String[]{"total", "number", "function", "myVar"},
                        2
                ));

                questions.add(new Question(
                        "รูปแบบการตั้งชื่อตัวแปรแบบ camelCase คือข้อใด?",
                        new String[]{"let MyVariable = 1;", "let my_variable = 1;", "let myVariable = 1;", "let myvariable = 1;"},
                        2
                ));
                break;


            case 2:
                questions.add(new Question(
                        "ข้อใดคือตัวดำเนินการทางคณิตศาสตร์ใน JavaScript?",
                        new String[]{"+, -, *, /, %", "==, !=, >", "&&, ||, !", "+++, ---"},
                        0
                ));

                questions.add(new Question(
                        "ผลลัพธ์ของ 10 % 3 คืออะไร?",
                        new String[]{"1", "3", "0", "10"},
                        0
                ));

                questions.add(new Question(
                        "ตัวดำเนินการเปรียบเทียบใดใช้ตรวจสอบทั้งค่าและชนิดข้อมูล?",
                        new String[]{"==", "!=", "===", "<="},
                        2
                ));

                questions.add(new Question(
                        "ผลลัพธ์ของ true && false คืออะไร?",
                        new String[]{"true", "false", "undefined", "error"},
                        1
                ));

                questions.add(new Question(
                        "ตัวดำเนินการ ! ใช้ทำอะไร?",
                        new String[]{"รวมค่าความจริง", "แปลงเป็นตัวเลข", "กลับค่าความจริง", "เชื่อมข้อความ"},
                        2
                ));

                questions.add(new Question(
                        "ข้อใดเป็นตัวดำเนินการกำหนดค่าที่ถูกต้อง?",
                        new String[]{"x == 10", "x += 5", "x != 0", "x &&= 1"},
                        1
                ));

                questions.add(new Question(
                        "ตัวดำเนินการระดับบิต (Bitwise) ใช้สำหรับอะไร?",
                        new String[]{
                                "เปรียบเทียบข้อความ",
                                "ทำงานกับเลขฐานสองในระดับบิต",
                                "เชื่อมข้อความ",
                                "แสดงข้อความบนหน้าเว็บ"
                        },
                        1
                ));

                questions.add(new Question(
                        "รูปแบบของตัวดำเนินการ ternary คืออะไร?",
                        new String[]{
                                "if () then : else",
                                "เงื่อนไข ? ค่าถ้าเป็นจริง : ค่าถ้าเป็นเท็จ",
                                "switch (case) {}",
                                "for ? while : do"
                        },
                        1
                ));

                questions.add(new Question(
                        "หากต้องการเปรียบเทียบค่าที่ไม่เท่ากันทั้งชนิดและค่า ควรใช้ตัวดำเนินการใด?",
                        new String[]{"!==", "!=", "==", "==="},
                        0
                ));

                questions.add(new Question(
                        "ลำดับความสำคัญของตัวดำเนินการใน JavaScript ถูกใช้เพื่ออะไร?",
                        new String[]{
                                "เพื่อจัดลำดับการแสดงผลบนหน้าเว็บ",
                                "เพื่อจัดลำดับการคำนวณและประมวลผล",
                                "เพื่อเรียงข้อมูลใน array",
                                "เพื่อเปลี่ยนค่าตัวแปร"
                        },
                        1
                ));
                break;

            case 3:
                questions.add(new Question(
                        "คำสั่งใดใช้สำหรับตรวจสอบเงื่อนไขใน JavaScript?",
                        new String[]{"switch", "loop", "if", "for"},
                        2
                ));

                questions.add(new Question(
                        "คำสั่ง if ทำงานอย่างไร?",
                        new String[]{
                                "ทำงานเสมอไม่ว่าเงื่อนไขจะเป็นจริงหรือเท็จ",
                                "ทำงานเฉพาะเมื่อเงื่อนไขเป็นเท็จ",
                                "ทำงานเมื่อเงื่อนไขเป็นจริง",
                                "ใช้ได้เฉพาะในฟังก์ชันเท่านั้น"
                        },
                        2
                ));

                questions.add(new Question(
                        "คำสั่ง switch เหมาะกับกรณีใด?",
                        new String[]{
                                "ตรวจสอบหลายค่าที่เป็นไปได้ของตัวแปร",
                                "วนลูปซ้ำตามจำนวนรอบที่กำหนด",
                                "เปรียบเทียบค่าความจริง",
                                "คำนวณเลขทางคณิตศาสตร์"
                        },
                        0
                ));

                questions.add(new Question(
                        "รูปแบบการใช้ switch ที่ถูกต้องคือข้อใด?",
                        new String[]{
                                "switch { case x: break; }",
                                "switch(x) { case 1: ... }",
                                "switch => (x) { ... }",
                                "switch x => case {...}"
                        },
                        1
                ));

                questions.add(new Question(
                        "คำสั่ง for ใช้สำหรับอะไร?",
                        new String[]{
                                "เปรียบเทียบค่าของตัวแปร",
                                "วนลูปโดยใช้เงื่อนไข",
                                "วนลูปตามจำนวนรอบที่กำหนดไว้ล่วงหน้า",
                                "ตรวจสอบตัวแปร"
                        },
                        2
                ));

                questions.add(new Question(
                        "คำสั่ง while และ do...while ต่างกันอย่างไร?",
                        new String[]{
                                "while รันเสมอ 1 ครั้ง, do...while ไม่",
                                "while ใช้ได้กับตัวแปรเดียว, do...while ใช้ได้หลายตัว",
                                "do...while รันอย่างน้อย 1 ครั้งเสมอ",
                                "while เร็วกว่า do...while เสมอ"
                        },
                        2
                ));

                questions.add(new Question(
                        "คำสั่ง break ใช้เพื่ออะไรในลูป?",
                        new String[]{
                                "หยุดลูปทันที",
                                "ข้ามรอบนั้น",
                                "รีเซตตัวแปร",
                                "ไปที่เงื่อนไขถัดไป"
                        },
                        0
                ));

                questions.add(new Question(
                        "คำสั่ง continue ใช้เพื่ออะไรในลูป?",
                        new String[]{
                                "ออกจากลูป",
                                "ไปยังลูปรอบถัดไปทันที",
                                "หยุดการรันโค้ดทั้งหมด",
                                "ล้างค่าตัวแปร"
                        },
                        1
                ));

                questions.add(new Question(
                        "try...catch ใช้เพื่ออะไรใน JavaScript?",
                        new String[]{
                                "วนลูปซ้ำ",
                                "เช็กค่าความจริง",
                                "จัดการข้อผิดพลาดระหว่างรันไทม์",
                                "เรียกใช้ API ภายนอก"
                        },
                        2
                ));

                questions.add(new Question(
                        "คำสั่ง catch จะทำงานเมื่อใด?",
                        new String[]{
                                "เมื่อไม่มีเงื่อนไขตรงกับ if",
                                "เมื่อ try ไม่มี error",
                                "เมื่อเกิด error ใน try",
                                "เมื่อเงื่อนไขไม่เป็นจริง"
                        },
                        2
                ));
                break;

            case 4:
                questions.add(new Question(
                        "ฟังก์ชันใน JavaScript ใช้เพื่ออะไร?",
                        new String[]{
                                "สร้างตัวแปร",
                                "จัดการข้อผิดพลาด",
                                "รวมโค้ดที่ใช้ซ้ำให้ทำงานเป็นกลุ่ม",
                                "โหลดไฟล์ภายนอก"
                        },
                        2
                ));

                questions.add(new Question(
                        "คำสั่งใดใช้สำหรับประกาศฟังก์ชันแบบดั้งเดิม?",
                        new String[]{"let", "new", "function", "define"},
                        2
                ));

                questions.add(new Question(
                        "การเรียกใช้งานฟังก์ชันใน JavaScript ทำได้อย่างไร?",
                        new String[]{
                                "แค่ประกาศ function ก็ทำงานทันที",
                                "ต้องเรียกชื่อฟังก์ชันตามด้วย ()",
                                "ใช้ if function",
                                "ใช้ return แล้วจึงเรียก"
                        },
                        1
                ));

                questions.add(new Question(
                        "พารามิเตอร์และอาร์กิวเมนต์ต่างกันอย่างไร?",
                        new String[]{
                                "พารามิเตอร์ใช้ตอนเรียกฟังก์ชัน, อาร์กิวเมนต์ใช้ตอนประกาศ",
                                "อาร์กิวเมนต์เป็นตัวแปร, พารามิเตอร์เป็นฟังก์ชัน",
                                "พารามิเตอร์คือค่าที่รับตอนประกาศ, อาร์กิวเมนต์คือค่าที่ส่งตอนเรียก",
                                "ไม่มีความแตกต่าง"
                        },
                        2
                ));

                questions.add(new Question(
                        "คำสั่ง return ในฟังก์ชันมีไว้เพื่ออะไร?",
                        new String[]{
                                "หยุดฟังก์ชันไม่ให้ทำงาน",
                                "ส่งค่ากลับออกไปจากฟังก์ชัน",
                                "แสดงข้อความใน console",
                                "เปลี่ยนค่าตัวแปรภายนอก"
                        },
                        1
                ));

                questions.add(new Question(
                        "Anonymous Function คืออะไร?",
                        new String[]{
                                "ฟังก์ชันที่ไม่มีชื่อ",
                                "ฟังก์ชันที่ return false เสมอ",
                                "ฟังก์ชันที่ใช้ภายใน if เท่านั้น",
                                "ฟังก์ชันที่ไม่สามารถเรียกใช้ซ้ำได้"
                        },
                        0
                ));

                questions.add(new Question(
                        "Arrow Function มีลักษณะอย่างไร?",
                        new String[]{
                                "ใช้เครื่องหมาย ->",
                                "ใช้ลูกศร => ในการประกาศ",
                                "ไม่มีการส่งค่าออก",
                                "ประกาศได้เฉพาะใน for-loop"
                        },
                        1
                ));

                questions.add(new Question(
                        "ฟังก์ชันเรียกตัวเอง (Recursive Function) คืออะไร?",
                        new String[]{
                                "ฟังก์ชันที่ถูกเรียกโดยฟังก์ชันอื่น",
                                "ฟังก์ชันที่สามารถลบตัวเองได้",
                                "ฟังก์ชันที่เรียกชื่อของตัวเองซ้ำ",
                                "ฟังก์ชันที่ใช้ไม่ได้ใน arrow function"
                        },
                        2
                ));

                questions.add(new Question(
                        "คำว่า this ภายในฟังก์ชันใน JavaScript หมายถึงอะไร?",
                        new String[]{
                                "ตัวแปรล่าสุดที่ประกาศ",
                                "อ็อบเจกต์ที่เรียกใช้ฟังก์ชันนั้น",
                                "ค่าที่ return ออกมา",
                                "ค่า null เสมอ"
                        },
                        1
                ));

                questions.add(new Question(
                        "ข้อใดคือประโยชน์ของการใช้ฟังก์ชัน?",
                        new String[]{
                                "ลดการเขียนโค้ดซ้ำซ้อน",
                                "ทำให้โค้ดอ่านง่ายขึ้น",
                                "จัดระเบียบโปรแกรมได้ดีขึ้น",
                                "ทุกข้อถูกต้อง"
                        },
                        3
                ));
                break;



        }

        return questions;
    }
}
