package com.example.final_project_javascript_group16;

import java.util.HashMap;

public class LessonData {
    public static final HashMap<Integer, String[]> lessonData = new HashMap<>();
    public static final HashMap<Integer, String[]> lessonExamples = new HashMap<>();
    public static final HashMap<Integer, String[]> lessonOutputs = new HashMap<>();

    static {
        // บทที่ 1
        lessonData.put(1, new String[]{
                "บทที่ 1: ชนิดข้อมูลใน JavaScript",
                "JavaScript เป็นภาษาที่รองรับชนิดข้อมูลที่หลากหลาย ซึ่งสามารถแบ่งออกเป็น <b>Primitive Types</b> และ <b>Reference Types</b> โดยแต่ละชนิดมีพฤติกรรมที่แตกต่างกัน.<br><br>"
                        + "<i>📖 ศึกษาข้อมูลเพิ่มเติมได้ในบทเรียนนี้</i>",

                "<h2>🔹 1. ข้อมูลพื้นฐานเกี่ยวกับชนิดข้อมูล (Data Types)</h2>"
                        + "<b>📌 1. Number (ตัวเลข)</b><br>"
                        + "• ใช้เก็บค่าทางคณิตศาสตร์ เช่น จำนวนเต็ม และ ทศนิยม.<br>"
                        + "• JavaScript ใช้ <b>Floating Point</b> สำหรับตัวเลขทั้งหมด ซึ่งอาจมีข้อผิดพลาดเรื่องความแม่นยำ.<br>"
                        + "• ค่าพิเศษของตัวเลข เช่น <b>Infinity</b> (ค่าอนันต์) และ <b>NaN</b> (Not a Number) มีความสำคัญในการตรวจสอบข้อผิดพลาด.<br><br>"

                        + "<b>📌 2. String (ข้อความ)</b><br>"
                        + "• ใช้เก็บข้อความ ซึ่งต้องอยู่ภายในเครื่องหมาย <code>\" \"</code> หรือ <code>' '</code>.<br>"
                        + "• JavaScript รองรับ <b>Template Literals (` `` `)</b> ที่ช่วยให้สามารถแทรกค่าตัวแปรลงในข้อความได้สะดวกขึ้น.<br>"
                        + "• สามารถใช้ <b>Escape Characters</b> เช่น `\\n` (ขึ้นบรรทัดใหม่) หรือ `\\t` (แท็บ) เพื่อจัดรูปแบบข้อความ.<br><br>"

                        + "<b>📌 3. Boolean (ค่าความจริง)</b><br>"
                        + "• ใช้เก็บค่าทางตรรกะที่มีเพียงสองค่า คือ `true` (จริง) และ `false` (เท็จ).<br>"
                        + "• ใช้ในการควบคุมเงื่อนไข เช่น `if` และ `while`.<br>"
                        + "• ค่าที่ถือว่าเป็น <b>Falsy Values</b> ใน JavaScript ได้แก่ `0`, `\"\"` (ข้อความว่าง), `null`, `undefined`, และ `NaN`.<br><br>"

                        + "<b>📌 4. Null (ค่าว่าง)</b><br>"
                        + "• ใช้สำหรับระบุว่าตัวแปรไม่มีค่า หรือไม่ได้ใช้งาน.<br>"
                        + "• เป็นค่าที่นักพัฒนาใช้กำหนดเองเมื่อไม่ต้องการให้ตัวแปรมีค่าใด ๆ.<br><br>"

                        + "<b>📌 5. Undefined (ค่าที่ยังไม่ได้กำหนด)</b><br>"
                        + "• ค่าที่ JavaScript กำหนดให้โดยอัตโนมัติ เมื่อตัวแปรถูกสร้างขึ้นแต่ยังไม่ได้กำหนดค่าให้.<br>"
                        + "• ต่างจาก `null` ตรงที่ `undefined` เป็นค่าที่เกิดขึ้นเองจากระบบโดยที่ไม่ได้ตั้งใจ.<br><br>"

                        + "<br><font color='#F7DF1E'>━━━━━━━━━━━━━━━━━━</font><br>"

                        + "<h2>🔹 2. ความแตกต่างระหว่างชนิดข้อมูลแต่ละประเภท</h2>"
                        + "<b>📌 Primitive Type vs Reference Type</b><br>"
                        + "JavaScript แบ่งชนิดข้อมูลออกเป็น 2 ประเภทหลัก:<br><br>"

                        + "✔ <b>Primitive Types</b>: ค่าของตัวแปรเป็นค่าคงที่ (Immutable) และไม่สามารถเปลี่ยนค่าได้โดยตรง เช่น Number, String, Boolean, Null, Undefined.<br>"
                        + "✔ <b>Reference Types</b>: ค่าของตัวแปรเป็นอ้างอิงไปยังหน่วยความจำ (Memory Address) ซึ่งสามารถเปลี่ยนแปลงค่าได้ เช่น Object, Array, Function.<br><br>"

                        + "<b>📌 ความแตกต่างสำคัญ:</b><br>"
                        + "• <b>Primitive Types</b> เป็นค่าที่ถูกคัดลอกเมื่อกำหนดให้ตัวแปรใหม่ (Pass by Value).<br>"
                        + "• <b>Reference Types</b> ใช้วิธีอ้างอิงตำแหน่งหน่วยความจำ ทำให้เมื่อเปลี่ยนแปลงค่าใน Object จะมีผลกระทบต่อตัวแปรที่อ้างอิงค่าดังกล่าวด้วย (Pass by Reference).<br><br>"

                        + "<br><font color='#F7DF1E'>━━━━━━━━━━━━━━━━━━</font><br>"

                        + "<h2>🔹 3. อ็อบเจกต์ (Object) และอาร์เรย์ (Array)</h2>"
                        + "<b>📌 Object คืออะไร?</b><br>"
                        + "• เป็นชนิดข้อมูลที่ใช้เก็บค่าหลายค่าในรูปแบบ <b>Key-Value Pairs</b>.<br>"
                        + "• ใช้สำหรับเก็บข้อมูลที่มีโครงสร้าง เช่น รายละเอียดของบุคคล, สินค้า, หรือข้อมูลเชิงซ้อนอื่น ๆ.<br>"
                        + "• มีคุณสมบัติ <b>Mutable</b> หรือสามารถเปลี่ยนแปลงค่าได้ตลอดเวลา.<br><br>"

                        + "<b>📌 Array คืออะไร?</b><br>"
                        + "• เป็นโครงสร้างข้อมูลที่ใช้เก็บค่าหลายค่า โดยแต่ละค่าจะถูกเก็บไว้ในตำแหน่งที่เรียกว่า <b>Index</b> ซึ่งเริ่มต้นที่ `0`.<br>"
                        + "• Array ใน JavaScript มีลักษณะ <b>Dynamic</b> คือสามารถเพิ่มหรือลดขนาดได้ตามต้องการ.<br>"
                        + "• รองรับเมธอดต่าง ๆ เช่น `.push()`, `.pop()`, `.map()`, `.filter()` เพื่อช่วยจัดการข้อมูลใน Array ได้ง่ายขึ้น.<br><br>"

                        + "<b>📌 ความแตกต่างระหว่าง Object และ Array:</b><br>"
                        + "• <b>Object</b> เหมาะสำหรับเก็บข้อมูลที่มีลักษณะเป็น <b>Key-Value</b> เช่น `{ name: 'John', age: 30 }`.<br>"
                        + "• <b>Array</b> เหมาะสำหรับเก็บข้อมูลที่เป็นลำดับ เช่น `[ 'red', 'blue', 'green' ]`.<br>"
        });
        // เพิ่มตัวอย่างโค้ดสำหรับบทที่ 1
        lessonExamples.put(1, new String[]{
                "// ตัวเลข (Number)\nlet age = 25;\nlet pi = 3.14;\nconsole.log(age, pi);",
                "// ข้อความ (String)\nlet name = \"Alice\";\nlet greeting = 'Hello, ' + name;\nconsole.log(greeting);",
                "// ค่าความจริง (Boolean)\nlet isStudent = true;\nlet hasLicense = false;\nconsole.log(isStudent, hasLicense);",
                "// ค่าว่าง (Null)\nlet emptyValue = null;\nconsole.log(emptyValue);",
                "// ค่าที่ยังไม่ได้กำหนด (Undefined)\nlet notDefined;\nconsole.log(notDefined);",
                "// อ็อบเจกต์และอาร์เรย์\nlet person = { name: 'John', age: 30 };\nlet colors = ['red', 'blue', 'green'];\nconsole.log(person.name, colors[0]);"
        });
        // Mockup Output ของแต่ละตัวอย่าง
        lessonOutputs.put(1, new String[]{
                "✅ ผลลัพธ์: 25 3.14",  // ตัวเลข
                "✅ ผลลัพธ์: Hello, Alice",  // ข้อความ
                "✅ ผลลัพธ์: true false",  // Boolean
                "✅ ผลลัพธ์: null",  // ค่าว่าง
                "✅ ผลลัพธ์: undefined",  // ค่าที่ยังไม่ได้กำหนด
                "✅ ผลลัพธ์: John red"  // อ็อบเจกต์และอาร์เรย์
        });

        // บทที่ 2
        lessonData.put(2, new String[]{
                "บทที่ 2: ตัวแปรใน JavaScript",
                "ตัวแปร (Variables) ใช้สำหรับเก็บข้อมูล เช่น <b>ตัวเลข</b>, <b>ข้อความ</b>, หรือ <b>ค่าความจริง</b>.",

                "<h2>🔹 1. ตัวแปรคืออะไร?</h2>"
                        + "ตัวแปรเป็นพื้นที่ในหน่วยความจำที่ใช้เก็บค่า <b>ซึ่งสามารถเปลี่ยนแปลงได้</b> ตลอดการทำงานของโปรแกรม.<br><br>"

                        + "<font color='#F7DF1E'>━━━━━━━━━━━━━━━━━━</font><br>"

                        + "<h2>🔹 2. ชนิดของตัวแปรใน JavaScript</h2>"
                        + "<ul>"
                        + "  <li><b>`var`</b> - ตัวแปรแบบเก่า (ไม่ควรใช้ในปัจจุบัน)</li>"
                        + "  <li><b>`let`</b> - ตัวแปรที่เปลี่ยนค่าได้ (แนะนำให้ใช้)</li>"
                        + "  <li><b>`const`</b> - ตัวแปรค่าคงที่ เปลี่ยนค่าไม่ได้</li>"
                        + "</ul><br>"

                        + "<font color='#F7DF1E'>━━━━━━━━━━━━━━━━━━</font><br>"

                        + "<h2>🔹 3. ความแตกต่างระหว่าง <b>var</b>, <b>let</b>, <b>const</b></h2>"
                        + "<ul>"
                        + "  <li><b>`var`</b> - สามารถประกาศตัวแปรซ้ำได้ และมีพฤติกรรม <b>Hoisting</b></li>"
                        + "  <li><b>`let`</b> - ไม่สามารถประกาศตัวแปรซ้ำได้ และอยู่ใน <b>Block Scope</b></li>"
                        + "  <li><b>`const`</b> - ต้องกำหนดค่าเริ่มต้น และ <b>เปลี่ยนค่าไม่ได้</b></li>"
                        + "</ul><br>"

                        + "<font color='#F7DF1E'>━━━━━━━━━━━━━━━━━━</font><br>"

                        + "<h2>🔹 4. Hoisting คืออะไร?</h2>"
                        + "Hoisting คือพฤติกรรมที่ <b>JavaScript ย้ายตัวแปรไปไว้บนสุดของ Scope โดยอัตโนมัติ</b>.<br>"
                        + "- <b>`var`</b> จะถูกย้ายขึ้นไปบนสุดและถูกกำหนดค่าเป็น <b>undefined</b>.<br>"
                        + "- <b>`let`</b> และ <b>`const`</b> จะถูกย้ายขึ้นไปบนสุดเช่นกัน <b>แต่จะเกิด Error</b> หากเรียกใช้ก่อนประกาศ.<br><br>"

                        + "<font color='#F7DF1E'>━━━━━━━━━━━━━━━━━━</font><br>"

                        + "<h2>🔹 5. กฎในการตั้งชื่อตัวแปรใน JavaScript</h2>"
                        + "<ul>"
                        + "  <li>✅ <b>ใช้ตัวอักษร (`a-z, A-Z`), ตัวเลข (`0-9`), `_` และ `$` เท่านั้น</b></li>"
                        + "  <li>❌ <b>ห้ามขึ้นต้นด้วยตัวเลข</b> เช่น <b>`let 1name = 'John';`</b></li>"
                        + "  <li>❌ <b>ห้ามใช้คำสงวน (Reserved Keywords)</b> เช่น <b>`let var = 10;`</b></li>"
                        + "  <li>✅ <b>Case-Sensitive (ตัวพิมพ์เล็ก-ใหญ่มีผล)</b> เช่น <b>`username` ≠ `UserName`</b></li>"
                        + "  <li>✅ <b>ใช้ `camelCase` ในการตั้งชื่อตัวแปร</b> เช่น <b>`let firstName = 'John';`</b></li>"
                        + "</ul><br>"
        });
        lessonExamples.put(2, new String[]{
                "// var สามารถใช้ก่อนประกาศได้ (Hoisting)\nconsole.log(x);\nvar x = 5;\nconsole.log(x);",
                "// let ต้องประกาศก่อนใช้ มิฉะนั้นจะเกิด Error\nconsole.log(y);\nlet y = 10;\nconsole.log(y);",
                "// const ต้องกำหนดค่าตอนประกาศ และเปลี่ยนค่าไม่ได้\nconst z = 20;\nconsole.log(z);",
                "// ✅ ตัวแปรที่ถูกต้อง\nlet firstName = 'John';\nlet last_name = 'Doe';\nlet $price = 100;\nconsole.log(firstName);",
                "// ❌ ตัวแปรที่ผิดกฎ (ขึ้นต้นด้วยตัวเลข)\nlet 1user = 'Alice';",
                "// ❌ ตัวแปรที่ผิดกฎ (ใช้คำสงวนของ JavaScript)\nlet function = 'test';"
        });
        lessonOutputs.put(2, new String[]{
                "✅ ผลลัพธ์:\nundefined\n5",  // Hoisting ของ var
                "⚠️ Error: Cannot access 'y' before initialization",  // let ไม่สามารถใช้ก่อนประกาศ
                "✅ ผลลัพธ์:\n20",  // const เปลี่ยนค่าไม่ได้
                "✅ ผลลัพธ์:\nJohn",  // ตัวแปรที่ถูกต้อง
                "⚠️ Error: Unexpected number",  // ตัวแปรขึ้นต้นด้วยตัวเลขผิดกฎ
                "⚠️ Error: Unexpected token 'function'"  // ตัวแปรใช้คำสงวนผิดกฎ
        });

        // บทที่ 3
        lessonData.put(3, new String[]{
                "บทที่ 3: ตัวดำเนินการใน JavaScript",
                "ตัวดำเนินการ (Operators) ใช้สำหรับการคำนวณ การเปรียบเทียบ และการจัดการค่าต่าง ๆ ใน JavaScript",

                "<h2>🔹 1. ตัวดำเนินการทางคณิตศาสตร์ (Arithmetic Operators)</h2>"
                        + "ใช้สำหรับการคำนวณค่าทางคณิตศาสตร์ เช่น การบวก ลบ คูณ หาร และหารเอาเศษ<br><br>"
                        + "<b>+</b> (Addition) - ใช้สำหรับการบวก เช่น <code>5 + 3</code> จะได้ <code>8</code><br>"
                        + "<b>-</b> (Subtraction) - ใช้สำหรับการลบ เช่น <code>10 - 7</code> จะได้ <code>3</code><br>"
                        + "<b>*</b> (Multiplication) - ใช้สำหรับการคูณ เช่น <code>4 * 2</code> จะได้ <code>8</code><br>"
                        + "<b>/</b> (Division) - ใช้สำหรับการหาร เช่น <code>10 / 2</code> จะได้ <code>5</code><br>"
                        + "<b>%</b> (Modulo) - ใช้หาค่าเศษจากการหาร เช่น <code>10 % 3</code> จะได้ <code>1</code><br><br>"

                        + "<b>💡 Tips:</b> ถ้าหารด้วย 0 ใน JavaScript จะได้ค่าเป็น <code>Infinity</code> เช่น <code>10 / 0</code> จะได้ <code>Infinity</code><br>"

                        + "<font color='#F7DF1E'>━━━━━━━━━━━━━━━━━━</font><br>"

                        + "<h2>🔹 2. ตัวดำเนินการเปรียบเทียบ (Comparison Operators)</h2>"
                        + "ใช้สำหรับเปรียบเทียบค่าระหว่างตัวแปรหรือค่าคงที่ และส่งคืนค่าความจริง (`true` หรือ `false`)<br><br>"
                        + "• <b>==</b> (Equal) - ตรวจสอบว่าค่าสองตัวมีค่าเท่ากันหรือไม่ (แต่ไม่ตรวจสอบประเภทข้อมูล) เช่น <code>10 == '10'</code> จะได้ <code>true</code><br>"
                        + "• <b>===</b> (Strict Equal) - ตรวจสอบว่าค่าสองตัวมีค่าและประเภทข้อมูลเหมือนกัน เช่น <code>10 === '10'</code> จะได้ <code>false</code><br>"
                        + "• <b>!=</b> (Not Equal) - ตรวจสอบว่าค่าสองตัวไม่เท่ากัน เช่น <code>5 != 3</code> จะได้ <code>true</code><br>"
                        + "• <b>!==</b> (Strict Not Equal) - ตรวจสอบว่าค่าสองตัวไม่เท่ากันหรือประเภทข้อมูลต่างกัน เช่น <code>5 !== '5'</code> จะได้ <code>true</code><br>"
                        + "• <b>></b>, <b><</b>, <b>>=</b>, <b><=</b> - ใช้เปรียบเทียบค่าทางคณิตศาสตร์<br><br>"

                        + "<b>💡 Tips:</b> ใช้ `===` แทน `==` เพื่อป้องกันข้อผิดพลาดจากการเปรียบเทียบที่ไม่ชัดเจน (Type Coercion)<br>"

                        + "<font color='#F7DF1E'>━━━━━━━━━━━━━━━━━━</font><br>"

                        + "<h2>🔹 3. ตัวดำเนินการตรรกะ (Logical Operators)</h2>"
                        + "ใช้สำหรับการรวมเงื่อนไข เช่น การตรวจสอบหลายเงื่อนไขใน `if`<br><br>"
                        + "• <b>&&</b> (AND) - จะคืนค่า <code>true</code> ก็ต่อเมื่อทั้งสองเงื่อนไขเป็นจริง เช่น <code>true && false</code> ได้ <code>false</code><br>"
                        + "• <b>||</b> (OR) - จะคืนค่า <code>true</code> ถ้ามีอย่างน้อยหนึ่งเงื่อนไขเป็นจริง เช่น <code>true || false</code> ได้ <code>true</code><br>"
                        + "• <b>!</b> (NOT) - ใช้กลับค่าความจริง เช่น <code>!true</code> ได้ <code>false</code><br><br>"

                        + "<font color='#F7DF1E'>━━━━━━━━━━━━━━━━━━</font><br>"

                        + "<h2>🔹 4. ตัวดำเนินการกำหนดค่า (Assignment Operators)</h2>"
                        + "ใช้สำหรับกำหนดค่าให้ตัวแปร และอัปเดตค่าของตัวแปร<br><br>"
                        + "• <b>=</b> (Assign) - ใช้กำหนดค่า เช่น <code>let x = 10;</code><br>"
                        + "• <b>+=</b>, <b>-=</b>, <b>*=</b>, <b>/=</b> - ใช้อัปเดตค่า เช่น <code>x += 5;</code> แทน <code>x = x + 5;</code><br><br>"

                        + "<font color='#F7DF1E'>━━━━━━━━━━━━━━━━━━</font><br>"

                        + "<h2>🔹 5. ลำดับความสำคัญของตัวดำเนินการ (Operator Precedence)</h2><br>"
                        + "ลำดับการทำงานของตัวดำเนินการใน JavaScript มีความสำคัญ ตัวดำเนินการที่มีลำดับสูงกว่าจะทำงานก่อน<br><br>"
                        + "<b>ลำดับความสำคัญจากสูงไปต่ำ:</b><br>"
                        + "1️⃣ วงเล็บ `()`<br>"
                        + "2️⃣ ตัวดำเนินการเพิ่ม/ลดค่า `++` / `--`<br>"
                        + "3️⃣ ตัวดำเนินการคำนวณ `*`, `/`, `%`<br>"
                        + "4️⃣ ตัวดำเนินการบวก/ลบ `+`, `-`<br>"
                        + "5️⃣ ตัวดำเนินการเปรียบเทียบ `>`, `<`, `>=`, `<=`<br>"
                        + "6️⃣ ตัวดำเนินการตรรกะ `&&`, `||`<br>"
                        + "7️⃣ ตัวดำเนินการกำหนดค่า `=`<br><br>"

                        + "<b>💡 Tips:</b> ใช้วงเล็บ `()` เพื่อกำหนดลำดับการทำงานให้ชัดเจน เช่น <code>(10 + 5) * 2</code> แทน <code>10 + 5 * 2</code> ที่ให้ผลลัพธ์ต่างกัน<br>"
        });
        lessonExamples.put(3, new String[]{
                "// การใช้ตัวดำเนินการทางคณิตศาสตร์\nlet x = 10;\nlet y = 5;\nconsole.log(x * y);",
                "// ตัวดำเนินการเปรียบเทียบ\nconsole.log(10 == '10');\nconsole.log(10 === '10');",
                "// ตัวดำเนินการตรรกะ\nconsole.log(true && false);\nconsole.log(true || false);",
                "// ตัวดำเนินการกำหนดค่า\nlet a = 5;\na *= 2;\nconsole.log(a);",
                "// ตัวดำเนินการระดับบิต\nconsole.log(5 & 1);\nconsole.log(5 | 1);",
                "// ตัวดำเนินการสามเงื่อนไข\nlet age = 18;\nlet status = (age >= 18) ? 'ผู้ใหญ่' : 'เด็ก';\nconsole.log(status);"
        });
        lessonOutputs.put(3, new String[]{
                "✅ ผลลัพธ์:\n50",  // ผลลัพธ์ของ `10 * 5`
                "✅ ผลลัพธ์:\ntrue\nfalse",  // เปรียบเทียบ `==` และ `===`
                "✅ ผลลัพธ์:\nfalse\ntrue",  // AND และ OR
                "✅ ผลลัพธ์:\n10",  // `a *= 2` จาก 5 เป็น 10
                "✅ ผลลัพธ์:\n1\n5",  // Bitwise AND และ OR
                "✅ ผลลัพธ์:\n'ผู้ใหญ่'"  // Ternary Operator (อายุ >= 18)
        });

        // บทที่ 4
        lessonData.put(4, new String[]{
                "บทที่ 4: คำสั่งควบคุมใน JavaScript",
                "คำสั่งควบคุม (Control Structures) ใช้กำหนดลำดับการทำงานของโปรแกรม เช่น การเลือกเงื่อนไขและการวนซ้ำ",

                "<h2>🔹 1. คำสั่งเลือกทำ (Conditional Statements)</h2><br>"
                        + "ใช้สำหรับตรวจสอบเงื่อนไขและเลือกคำสั่งที่ต้องการให้โปรแกรมทำงาน<br><br>"

                        + "<b>- คำสั่ง if, else if, else</b><br>"
                        + "• ใช้ตรวจสอบเงื่อนไขและเลือกทำงานตามค่าความจริง (`true` หรือ `false`)<br>"
                        + "• สามารถใช้ `else if` เพื่อเพิ่มเงื่อนไขหลายระดับ<br><br>"

                        + "<b>- คำสั่ง switch</b><br>"
                        + "• ใช้แทน `if-else` หลายเงื่อนไข<br>"
                        + "• ใช้เปรียบเทียบค่ากับหลายกรณี (`case`)<br>"
                        + "• ควรใช้ `break` เพื่อหยุดการทำงานหลังจากเข้าเงื่อนไขที่ถูกต้อง<br><br>"

                        + "<font color='#F7DF1E'>━━━━━━━━━━━━━━━━━━</font><br>"

                        + "<h2>🔹 2. คำสั่งวนซ้ำ (Looping Statements)</h2><br>"
                        + "ใช้สำหรับทำซ้ำคำสั่งเดิมหลายครั้งจนกว่าเงื่อนไขจะเป็น `false`<br><br>"

                        + "<b>- คำสั่ง for</b><br>"
                        + "• ใช้ในกรณีที่รู้จำนวนรอบแน่นอน เช่น วนลูปจาก 1 ถึง 10<br><br>"

                        + "<b>- คำสั่ง while และ do...while</b><br>"
                        + "• ใช้ในกรณีที่ไม่รู้จำนวนรอบแน่นอน และต้องการให้โปรแกรมทำซ้ำจนกว่าเงื่อนไขจะ `false`<br>"
                        + "• `while` ตรวจสอบเงื่อนไขก่อนทำงาน<br>"
                        + "• `do...while` ทำงานอย่างน้อย 1 ครั้งก่อนตรวจสอบเงื่อนไข<br><br>"

                        + "<font color='#F7DF1E'>━━━━━━━━━━━━━━━━━━</font><br>"

                        + "<h2>🔹 3. คำสั่งควบคุมการทำงานของลูป (Loop Control Statements)</h2><br>"
                        + "ใช้เพื่อควบคุมการทำงานของลูปโดยเฉพาะ<br><br>"

                        + "<b>- คำสั่ง break</b><br>"
                        + "• ใช้เพื่อหยุดการทำงานของลูปทันทีเมื่อเข้าเงื่อนไข<br><br>"

                        + "<b>- คำสั่ง continue</b><br>"
                        + "• ใช้เพื่อข้ามการทำงานของรอบปัจจุบัน แล้วไปทำรอบถัดไปแทน<br><br>"

                        + "<font color='#F7DF1E'>━━━━━━━━━━━━━━━━━━</font><br>"

                        + "<h2>🔹 4. การจัดการข้อผิดพลาด (Error Handling)</h2><br>"
                        + "ใช้เพื่อป้องกันโปรแกรมหยุดทำงานเมื่อเกิดข้อผิดพลาด<br><br>"

                        + "<b>- คำสั่ง try...catch</b><br>"
                        + "• ใช้สำหรับดักจับข้อผิดพลาด (`try` ใส่โค้ดที่อาจเกิดข้อผิดพลาด และ `catch` ใช้จัดการข้อผิดพลาดนั้น)<br><br>"

                        + "<b>💡 Tips:</b> ใช้ `try...catch` ควบคู่กับ `throw` เพื่อสร้างข้อผิดพลาดเอง เช่น `throw new Error('เกิดข้อผิดพลาด')`<br>"
        });
        lessonExamples.put(4, new String[]{
                "// คำสั่ง if, else if, else\nlet score = 85;\nif (score >= 90) {\n  console.log('A');\n} else if (score >= 80) {\n  console.log('B');\n} else {\n  console.log('C');\n}",
                "// คำสั่ง switch\nlet day = 3;\nswitch (day) {\n  case 1: console.log('วันจันทร์'); break;\n  case 2: console.log('วันอังคาร'); break;\n  default: console.log('วันอื่นๆ');\n}",
                "// คำสั่ง for\nfor (let i = 1; i <= 5; i++) {\n  console.log('รอบที่ ' + i);\n}",
                "// คำสั่ง while\nlet x = 0;\nwhile (x < 3) {\n  console.log('x = ' + x);\n  x++;\n}",
                "// คำสั่ง break และ continue\nfor (let i = 1; i <= 5; i++) {\n  if (i == 3) break;\n  console.log(i);\n}",
                "// การจัดการข้อผิดพลาด\ntry {\n  let a = 10 / 0;\n  if (!isFinite(a)) throw new Error('หารด้วยศูนย์ไม่ได้');\n} catch (error) {\n  console.log(error.message);\n}"
        });
        lessonOutputs.put(4, new String[]{
                "✅ ผลลัพธ์:\nB",  // เงื่อนไข if-else
                "✅ ผลลัพธ์:\nวันอื่นๆ",  // switch-case
                "✅ ผลลัพธ์:\nรอบที่ 1\nรอบที่ 2\nรอบที่ 3\nรอบที่ 4\nรอบที่ 5",  // for loop
                "✅ ผลลัพธ์:\nx = 0\nx = 1\nx = 2",  // while loop
                "✅ ผลลัพธ์:\n1\n2",  // break หยุดลูปที่ค่า 3
                "✅ ผลลัพธ์:\nหารด้วยศูนย์ไม่ได้"  // try-catch ตรวจจับข้อผิดพลาด
        });

        // บทที่ 5
        lessonData.put(5, new String[]{
                "บทที่ 5: ฟังก์ชันใน JavaScript",
                "ฟังก์ชัน (Function) คือ กลุ่มของคำสั่งที่สามารถนำกลับมาใช้ซ้ำได้ ทำให้โค้ดเป็นระบบมากขึ้น และช่วยลดความซับซ้อนของโปรแกรม",

                "<h2>🔹 1. ความหมายและประโยชน์ของฟังก์ชัน</h2><br>"
                        + "ฟังก์ชันใน JavaScript เป็นโครงสร้างสำคัญที่ช่วยให้การพัฒนาโปรแกรมมีความยืดหยุ่นและมีประสิทธิภาพ<br><br>"
                        + "<b>📌 ประโยชน์ของฟังก์ชัน</b><br>"
                        + "• <b>ลดการเขียนโค้ดซ้ำ (Code Reusability)</b> – สามารถเรียกใช้โค้ดเดิมซ้ำได้ โดยไม่ต้องเขียนใหม่<br>"
                        + "• <b>ช่วยให้โค้ดอ่านง่ายขึ้น (Readable Code)</b> – ทำให้โปรแกรมอ่านง่ายและเป็นระบบ<br>"
                        + "• <b>ช่วยลดข้อผิดพลาด (Less Errors)</b> – แยกโค้ดออกเป็นโมดูล ทำให้แก้ไขได้ง่ายขึ้น<br>"
                        + "• <b>ช่วยให้โปรแกรมขยายตัวได้ง่าย (Scalability)</b> – สามารถเพิ่มฟีเจอร์ใหม่ได้ง่ายโดยใช้ฟังก์ชัน<br><br>"
                        + "<b>💡 Tips:</b> ใช้ฟังก์ชันเพื่อแบ่งโค้ดเป็นส่วนเล็ก ๆ ตามหน้าที่ เช่น `calculateTotal()`, `getUserInfo()` เพื่อให้โค้ดอ่านง่ายขึ้น<br><br>"

                        + "<font color='#F7DF1E'>━━━━━━━━━━━━━━━━━━</font><br>"

                        + "<h2>🔹 2. การประกาศฟังก์ชัน (`function` keyword)</h2><br>"
                        + "JavaScript รองรับการประกาศฟังก์ชันโดยใช้คำสั่ง `function` ตามด้วยชื่อฟังก์ชัน และวงเล็บ `()`<br><br>"
                        + "<b>📌 โครงสร้างของฟังก์ชัน</b><br>"
                        + "<code>function ชื่อฟังก์ชัน(พารามิเตอร์) {\n  // คำสั่งที่ต้องการให้ฟังก์ชันทำงาน\n}</code><br><br>"
                        + "• ชื่อฟังก์ชันควรตั้งให้สื่อความหมาย เช่น `calculateTotal()` หรือ `getUserData()`<br>"
                        + "• สามารถกำหนดพารามิเตอร์ (`parameters`) เพื่อรับค่าภายนอกเข้ามาในฟังก์ชันได้<br><br>"
                        + "<b>💡 Tips:</b> ใช้ชื่อฟังก์ชันที่สื่อความหมาย และควรใช้ <b>verb + noun</b> เช่น `getData()`, `calculateSum()` เพื่อให้โค้ดเข้าใจง่าย<br><br>"

                        + "<font color='#F7DF1E'>━━━━━━━━━━━━━━━━━━</font><br>"

                        + "<h2>🔹 3. การเรียกใช้ฟังก์ชัน</h2><br>"
                        + "หลังจากที่สร้างฟังก์ชันแล้ว จะต้องเรียกใช้โดยพิมพ์ชื่อฟังก์ชันตามด้วยวงเล็บ `()`<br><br>"
                        + "<b>📌 ตัวอย่าง</b><br>"
                        + "<code>function sayHello() {\n  console.log('Hello!');\n}\nsayHello();</code><br><br>"
                        + "• ฟังก์ชันจะทำงานก็ต่อเมื่อถูกเรียกใช้เท่านั้น ไม่ทำงานอัตโนมัติเมื่อประกาศเสร็จ<br><br>"
                        + "<b>💡 Tips:</b> หลีกเลี่ยงการเรียกใช้ฟังก์ชันที่ยังไม่ได้ประกาศ (Hoisting อาจทำให้เกิดข้อผิดพลาดได้) ควรประกาศฟังก์ชันก่อนใช้งานเสมอ<br><br>"

                        + "<font color='#F7DF1E'>━━━━━━━━━━━━━━━━━━</font><br>"

                        + "<h2>🔹 4. พารามิเตอร์ (Parameters) และอาร์กิวเมนต์ (Arguments)</h2><br>"
                        + "• <b>พารามิเตอร์</b> คือค่าที่ระบุไว้ในวงเล็บตอนประกาศฟังก์ชัน<br>"
                        + "• <b>อาร์กิวเมนต์</b> คือค่าที่ส่งเข้าไปในฟังก์ชันตอนเรียกใช้<br><br>"
                        + "<b>📌 ตัวอย่าง</b><br>"
                        + "<code>function greet(name) {\n  console.log('สวัสดี ' + name);\n}\ngreet('Alice');</code><br><br>"
                        + "<b>💡 Tips:</b> กำหนดค่าเริ่มต้นให้กับพารามิเตอร์ เช่น `function greet(name = 'Guest')` เพื่อป้องกันค่าที่ไม่ได้ส่งมา<br><br>"

                        + "<font color='#F7DF1E'>━━━━━━━━━━━━━━━━━━</font><br>"

                        + "<h2>🔹 5. ค่าที่ฟังก์ชันส่งกลับ (Return Values)</h2><br>"
                        + "สามารถใช้ `return` เพื่อส่งค่ากลับจากฟังก์ชัน<br><br>"
                        + "<b>📌 ตัวอย่าง</b><br>"
                        + "<code>function add(a, b) {\n  return a + b;\n}\nlet result = add(5, 10);\nconsole.log(result);</code><br><br>"
                        + "<b>💡 Tips:</b> ฟังก์ชันควรทำงานให้สั้นและมีหน้าที่เดียว (Single Responsibility Principle) เพื่อให้ง่ายต่อการจัดการ<br><br>"

                        + "<font color='#F7DF1E'>━━━━━━━━━━━━━━━━━━</font><br>"

                        + "<h2>🔹 6. ฟังก์ชันนิรนาม (Anonymous Functions)</h2><br>"
                        + "ฟังก์ชันที่ไม่มีชื่อ และสามารถเก็บไว้ในตัวแปรเพื่อเรียกใช้ภายหลังได้<br><br>"
                        + "<b>📌 ตัวอย่าง</b><br>"
                        + "<code>const multiply = function(a, b) {\n  return a * b;\n};\nconsole.log(multiply(4, 3));</code><br><br>"
                        + "<b>💡 Tips:</b> ใช้ฟังก์ชันนิรนามเมื่อฟังก์ชันไม่มีความจำเป็นต้องใช้ชื่อ เช่น callback function หรือ event handler<br><br>"

                        + "<font color='#F7DF1E'>━━━━━━━━━━━━━━━━━━</font><br>"

                        + "<h2>🔹 7. ฟังก์ชันลูกศร (Arrow Functions)</h2><br>"
                        + "ฟังก์ชันแบบย่อ ใช้ `=>` แทน `function` เพื่อทำให้โค้ดกระชับขึ้น<br><br>"
                        + "<b>📌 ตัวอย่าง</b><br>"
                        + "<code>const square = x => x * x;\nconsole.log(square(5));</code><br><br>"
                        + "<b>💡 Tips:</b> ใช้ฟังก์ชันลูกศรเมื่อไม่ต้องการ `this` เช่น callback function หรือ map/filter/reduce<br><br>"

                        + "<font color='#F7DF1E'>━━━━━━━━━━━━━━━━━━</font><br>"

                        + "<h2>🔹 8. ฟังก์ชันเรียกตัวเอง (Recursive Functions)</h2><br>"
                        + "ฟังก์ชันที่เรียกใช้ตัวเอง เหมาะสำหรับการคำนวณเชิงซ้ำ เช่น แฟกทอเรียล (Factorial)<br><br>"
                        + "<b>📌 ตัวอย่าง</b><br>"
                        + "<code>function factorial(n) {\n  if (n === 1) return 1;\n  return n * factorial(n - 1);\n}\nconsole.log(factorial(5));</code><br><br>"
                        + "<b>💡 Tips:</b> ใช้เงื่อนไขหยุด (`base case`) เสมอ เพื่อป้องกันลูปที่ไม่มีที่สิ้นสุดใน recursive function<br><br>"

                        + "<font color='#F7DF1E'>━━━━━━━━━━━━━━━━━━</font><br>"

                        + "<h2>🔹 9. การจัดการขอบเขตของ `this` ภายในฟังก์ชัน</h2><br>"
                        + "ค่าของ `this` ขึ้นอยู่กับวิธีที่ฟังก์ชันถูกเรียกใช้<br><br>"
                        + "<b>📌 ตัวอย่าง</b><br>"
                        + "<code>const person = {\n  name: 'John',\n  greet: function() {\n    console.log('Hello, ' + this.name);\n  }\n};\nperson.greet();</code><br><br>"

                        + "<b>💡 Tips:</b> ฟังก์ชันลูกศร (`=>`) ไม่มี `this` ของตัวเอง ค่าของ `this` จะถูกอ้างอิงจากบริบทที่อยู่ข้างนอกฟังก์ชัน<br>"
        });
        lessonExamples.put(5, new String[]{
                "// การประกาศและเรียกใช้ฟังก์ชัน\nfunction greet() {\n  console.log('Hello!');\n}\ngreet();",
                "// พารามิเตอร์และอาร์กิวเมนต์\nfunction add(a, b) {\n  return a + b;\n}\nconsole.log(add(3, 5));",
                "// ฟังก์ชันนิรนาม\nconst sayHello = function() {\n  console.log('Hi!');\n};\nsayHello();",
                "// ฟังก์ชันลูกศร\nconst multiply = (x, y) => x * y;\nconsole.log(multiply(4, 6));",
                "// ฟังก์ชันเรียกตัวเอง\nfunction factorial(n) {\n  if (n === 1) return 1;\n  return n * factorial(n - 1);\n}\nconsole.log(factorial(5));",
                "// การใช้ this ในฟังก์ชัน\nconst person = {\n  name: 'John',\n  greet: function() {\n    console.log('Hello, ' + this.name);\n  }\n};\nperson.greet();"
        });
        lessonOutputs.put(5, new String[]{
                "✅ ผลลัพธ์:\nHello!",  // ฟังก์ชันพื้นฐาน
                "✅ ผลลัพธ์:\n8",  // ฟังก์ชันที่มีพารามิเตอร์และ return
                "✅ ผลลัพธ์:\nHi!",  // ฟังก์ชันนิรนาม
                "✅ ผลลัพธ์:\n24",  // ฟังก์ชันลูกศร
                "✅ ผลลัพธ์:\n120",  // ฟังก์ชันเรียกตัวเอง (Factorial)
                "✅ ผลลัพธ์:\nHello, John"  // การใช้ this ในฟังก์ชัน
        });
    }

    public static String[] getLessonData(int lessonNumber) {
        return lessonData.getOrDefault(lessonNumber, new String[]{"","",""});
    }

    public static int getLessonDataSize() {
        return lessonData.size();
    }

    public static String[] getLessonExamples(int lessonNumber) {
        return lessonExamples.getOrDefault(lessonNumber, new String[]{});
    }

    public static String[] getLessonOutputs(int lessonNumber) {
        return lessonOutputs.getOrDefault(lessonNumber, new String[]{});
    }
}
