CREATE TABLE "APRICOT_IMAGES"
(
    "APRICOT_IMAGE_ID" NUMBER(10,0),
    "APRICOT_ID" NUMBER(10,0),
    "IMAGE_FILE" VARCHAR2(120 CHAR)
);
Insert into APRICOT_IMAGES (APRICOT_IMAGE_ID,APRICOT_ID,IMAGE_FILE) values ('26','20','BlackPeach2.jpg');
Insert into APRICOT_IMAGES (APRICOT_IMAGE_ID,APRICOT_ID,IMAGE_FILE) values ('1','1','Svitlogradskiy1.jpg');
Insert into APRICOT_IMAGES (APRICOT_IMAGE_ID,APRICOT_ID,IMAGE_FILE) values ('2','1','Svitlogradskiy2.jpg');
Insert into APRICOT_IMAGES (APRICOT_IMAGE_ID,APRICOT_ID,IMAGE_FILE) values ('27','20','BlackPeach3.jpg');
Insert into APRICOT_IMAGES (APRICOT_IMAGE_ID,APRICOT_ID,IMAGE_FILE) values ('28','21','Bergeron1.jpg');
Insert into APRICOT_IMAGES (APRICOT_IMAGE_ID,APRICOT_ID,IMAGE_FILE) values ('29','21','Bergeron2.jpg');
Insert into APRICOT_IMAGES (APRICOT_IMAGE_ID,APRICOT_ID,IMAGE_FILE) values ('30','22','BigRed1.jpg');
Insert into APRICOT_IMAGES (APRICOT_IMAGE_ID,APRICOT_ID,IMAGE_FILE) values ('31','22','BigRed2.jpg');
Insert into APRICOT_IMAGES (APRICOT_IMAGE_ID,APRICOT_ID,IMAGE_FILE) values ('32','22','BigRed3.jpg');
Insert into APRICOT_IMAGES (APRICOT_IMAGE_ID,APRICOT_ID,IMAGE_FILE) values ('33','22','BigRed4.jpg');
Insert into APRICOT_IMAGES (APRICOT_IMAGE_ID,APRICOT_ID,IMAGE_FILE) values ('3','2','NJA1.jpg');
Insert into APRICOT_IMAGES (APRICOT_IMAGE_ID,APRICOT_ID,IMAGE_FILE) values ('4','2','NJA2.jpg');
Insert into APRICOT_IMAGES (APRICOT_IMAGE_ID,APRICOT_ID,IMAGE_FILE) values ('5','3','Ledana1.jpg');
Insert into APRICOT_IMAGES (APRICOT_IMAGE_ID,APRICOT_ID,IMAGE_FILE) values ('6','4','CeglediBiber1.jpg');
Insert into APRICOT_IMAGES (APRICOT_IMAGE_ID,APRICOT_ID,IMAGE_FILE) values ('7','5','DzhumboTardiv1.jpg');
Insert into APRICOT_IMAGES (APRICOT_IMAGE_ID,APRICOT_ID,IMAGE_FILE) values ('8','6','Kyoto1.jpg');
Insert into APRICOT_IMAGES (APRICOT_IMAGE_ID,APRICOT_ID,IMAGE_FILE) values ('9','7','Hargrand1.jpg');
Insert into APRICOT_IMAGES (APRICOT_IMAGE_ID,APRICOT_ID,IMAGE_FILE) values ('10','8','Aprium1.jpg');
Insert into APRICOT_IMAGES (APRICOT_IMAGE_ID,APRICOT_ID,IMAGE_FILE) values ('11','9','Banzai1.jpg');
Insert into APRICOT_IMAGES (APRICOT_IMAGE_ID,APRICOT_ID,IMAGE_FILE) values ('12','10','EgyptianPharaoh1.jpg');
Insert into APRICOT_IMAGES (APRICOT_IMAGE_ID,APRICOT_ID,IMAGE_FILE) values ('13','11','Peachy1.jpg');
Insert into APRICOT_IMAGES (APRICOT_IMAGE_ID,APRICOT_ID,IMAGE_FILE) values ('14','12','Pricia1.jpg');
Insert into APRICOT_IMAGES (APRICOT_IMAGE_ID,APRICOT_ID,IMAGE_FILE) values ('15','12','Pricia2.jpg');
Insert into APRICOT_IMAGES (APRICOT_IMAGE_ID,APRICOT_ID,IMAGE_FILE) values ('16','13','RedTardiv1.jpg');
Insert into APRICOT_IMAGES (APRICOT_IMAGE_ID,APRICOT_ID,IMAGE_FILE) values ('17','14','Rubista1.jpg');
Insert into APRICOT_IMAGES (APRICOT_IMAGE_ID,APRICOT_ID,IMAGE_FILE) values ('18','15','TomCot1.jpg');
Insert into APRICOT_IMAGES (APRICOT_IMAGE_ID,APRICOT_ID,IMAGE_FILE) values ('19','16','Farbaly1.jpg');
Insert into APRICOT_IMAGES (APRICOT_IMAGE_ID,APRICOT_ID,IMAGE_FILE) values ('20','16','Farbaly2jpg');
Insert into APRICOT_IMAGES (APRICOT_IMAGE_ID,APRICOT_ID,IMAGE_FILE) values ('21','17','Fardao1.jpg');
Insert into APRICOT_IMAGES (APRICOT_IMAGE_ID,APRICOT_ID,IMAGE_FILE) values ('22','18','Farklo1.jpg');
Insert into APRICOT_IMAGES (APRICOT_IMAGE_ID,APRICOT_ID,IMAGE_FILE) values ('23','18','Farklo2.jpg');
Insert into APRICOT_IMAGES (APRICOT_IMAGE_ID,APRICOT_ID,IMAGE_FILE) values ('24','19','Tsunami1.jpg');
Insert into APRICOT_IMAGES (APRICOT_IMAGE_ID,APRICOT_ID,IMAGE_FILE) values ('25','20','BlackPeach1.jpg');
CREATE UNIQUE INDEX "APRICOT_IMAGES_PK" ON "APRICOT_IMAGES" ("APRICOT_IMAGE_ID");
ALTER TABLE "APRICOT_IMAGES" MODIFY ("APRICOT_IMAGE_ID" NOT NULL ENABLE);
ALTER TABLE "APRICOT_IMAGES" ADD CONSTRAINT "APRICOT_IMAGES_PK" PRIMARY KEY ("APRICOT_IMAGE_ID") USING INDEX;
ALTER TABLE "APRICOT_IMAGES" MODIFY ("APRICOT_ID" NOT NULL ENABLE);
CREATE TABLE "APRICOTS"
(
    "APRICOT_ID" NUMBER(10,0),
    "APRICOT_NAME" VARCHAR2(100 CHAR),
    "INFO" VARCHAR2(2000 CHAR),
    "PRICE" NUMBER(10,2)
);
Insert into APRICOTS (APRICOT_ID,APRICOT_NAME,INFO,PRICE) values ('18','Фаркло','Абрикос Фаркло – новий надпізній сорт абрикосу селекції Франції. Плоди великі, масою 50 - 70 грам, округло-овальної форми, звужені до вершини, чітким швом, іноді чітко виділяється "носик" вершини плода, яскраво-жовтого кольору, іноді з нечітким крапчастим рум''янцем з сонячного боку. В основному плоди монотонні у кольорі, на що позначаються пізні терміни дозрівання та нестача тепла в цей період. М''якуш щільний, середньої соковитості, злегка сухуватий, хрумкий, що властиво багатьом пізнім сортам. Смакові якості хороші, солодкі, із невеликим вмістом кислоти.','5.95');
Insert into APRICOTS (APRICOT_ID,APRICOT_NAME,INFO,PRICE) values ('19','Цунамі','Абрикос Цунамі – новий ранній сорт абрикосу французької селекції. Плоди дуже великі, масою 70 - 90 грам і більше, подовжено-циліндричної форми, оранжево-жовті, покриті на 60-70% червоним рум''янцем. М''якуш помаранчевий, соковитий, смак солодкий, дуже хороший, збалансований.','6.29');
Insert into APRICOTS (APRICOT_ID,APRICOT_NAME,INFO,PRICE) values ('20','Чорний Персиковий','Абрикос Чорний Персиковий - гібрид між абрикосом та аличем, взяв усе найкраще від батьків, відрізняється привабливими плодами та високими смаковими якостями. Це літній сорт, плоди дозрівають пізно у серпні. М''якуш має ніжний, абрикосовий аромат. Маса плодів дорівнює приблизно 40 грам, формою вони нагадують кулю, можуть бути округло-овальними. М''якуш має темно-бордовий колір, кісточка від м''якоті відокремлюється з легкістю. Плоди придатні для транспортування, зберігання, тому сорт застосовується як промисловий.','5.49');
Insert into APRICOTS (APRICOT_ID,APRICOT_NAME,INFO,PRICE) values ('21','Бержерон','Абрикос Бержерон – сорт абрикоса середньо-пізнього терміну дозрівання, французька селекція. Дозрівання плодів Бержерона – 20-ті числа липня. Маса плодів - 50 - 60 грам і більше, округлої форми, з яскраво-червоним точковим, яскравим рум''янцем на більшій частині плода. Зовні плоди дуже гарні, товарні. Плоди мають яскравий аромат. М''якуш дуже щільний, оранжевого кольору, солодкий, з приємною кислинкою. Смак дуже добрий, ароматний, високих смакових якостей.','6');
Insert into APRICOTS (APRICOT_ID,APRICOT_NAME,INFO,PRICE) values ('22','Біг Ред','Абрикос Біг Ред - унікальний червоний абрикос французької селекції, середнього терміну дозрівання (друга декада липня). Плоди виглядають дуже привабливо та апетитно, яскраво-червоний рум''янець, що покриває половину абрикоса. Маса плоду досягає 100 грам, сорт транспортабельний. М''якуш ніжний, соковитий, солодкий, добре відділяється від кісточки.','5.79');
Insert into APRICOTS (APRICOT_ID,APRICOT_NAME,INFO,PRICE) values ('1','Світлоградський','Абрикос "Світлоградський" - це ранній, літній сорт, дозріває в другій декаді червня. Розмір плодів 50-60 грам. Плоди помаранчевого забарвлення без рум''янцю, м''якоть оранжева. Використовується для вживання в свіжому вигляді, транспортабельність гарна. Поодинокі плоди розтріскуються, але не більше 3-5% і ще в зеленому вигляді.','6');
Insert into APRICOTS (APRICOT_ID,APRICOT_NAME,INFO,PRICE) values ('2','NJA-19','Абрикос NJA-19 - це літній середньостиглий сорт (збирання врожаю в середині липня), великоплідний із медовим смаком. Плоди великі, масою від 100 до 180 грам, кулястої форми, жовто-жовтогарячого кольору з червонуватим рум''янцем на сонячній стороні. М''якуш світло-жовтий, середньощільний, м''ясистий і соковитий, з медовим присмаком і ароматом. Кісточка невеликих розмірів, солодка, добре відокремляться від м''якоті. Абрикос використовують як у свіжому вигляді, так і в приготуванні компотів, для заморозки, варення та інших заготовок.','5.9');
Insert into APRICOTS (APRICOT_ID,APRICOT_NAME,INFO,PRICE) values ('3','Ледана','Абрикос Ледана – середній сорт абрикосу чеської селекції. Плоди дозрівають на початку липня, округло-овальної форми, оранжеві, без вираженого рум''янцю, маса 50-70 грам, м''якуш щільний, високі смакові якості, ароматні. Плоди стійкі до несприятливих погодних умов.','5.95');
Insert into APRICOTS (APRICOT_ID,APRICOT_NAME,INFO,PRICE) values ('4','Цегледі Бібер','Абрикос Цегледі Бібер – це старий сорт, який вже перевірений часом. Плоди світло-помаранчеві, присутні розмитий червоний рум’янець, маса 75-85 грам, окремі екземпляри можуть важити 100 грам. Смак фрукта дуже збалансований. Колір м’якоті – помаранчевий. Плоди великі і смачні. Їх можна використовувати для вживання як в свіжому вигляді, так і для переробки.','6.29');
Insert into APRICOTS (APRICOT_ID,APRICOT_NAME,INFO,PRICE) values ('5','Джумбо Тардив','Абрикос Джумбо Тардів – новий сорт абрикосу канадської селекції, середнього терміну дозрівання, збирання врожаю з другої декади липня. Плоди великі, трохи довгастої форми, середньою масою 120 - 150 грам, найбільші до 200 грам. Кісточка відокремлюється добре. Плоди яскраво-жовтогарячого забарвлення з невеликою засмагою, з щільною дуже приємною на смак ароматною м''якоттю, з гарною транспортабельністю.','5.49');
Insert into APRICOTS (APRICOT_ID,APRICOT_NAME,INFO,PRICE) values ('6','Кіото','Абрикос Кіото - новий сорт абрикоса французької селекції середнього терміну дозрівання (у середині липня). Середня вага плодів - 65 грам, окремі плоди більші. Плоди округло-подовженої форми, оранжеві, з яскраво-червоним рум''янцем на 30-70% поверхні плода. Смак дуже добрий, солодкий, ароматний. М''якуш помаранчевий.','6');
Insert into APRICOTS (APRICOT_ID,APRICOT_NAME,INFO,PRICE) values ('7','Харгранд','Абрикос Харгранд - канадський сорт абрикоса, пізнього терміну дозрівання. Знімання плодів у другій половині липня. Плоди дуже великі, середньою вагою 70 г, окремі плоди часто досягають маси до 120 г, подовжено-овальної форми. Колір плодів оранжевий, з невеликим червоним рум''янцем. Зовні дуже привабливі і мають гарний попит на ринку. Плоди високих смакових якостей, з медовим присмаком, дуже солодкі, м''якуш дуже соковитий, ароматний, універсального призначення, транспортабельний. Кісточка відокремлюється у недозрілому стані і не відокремлюється при повному дозріванні.','5.9');
Insert into APRICOTS (APRICOT_ID,APRICOT_NAME,INFO,PRICE) values ('8','Апріум','Абрикос Апріум - колоновидний абрикос схрещений із сливою (склад 75% абрикоса + 25% сливи). Вам буде чим здивувати Ваших гостей, такого Ви ще не коштували. Зовнішній вигляд плодів більше схожий на абрикоси, він помаранчевий, але без характерного опушування і волокнистості. Шкірка гладка з блиском як у сливи. Дозрівання з перших чисел серпня, середня маса плодів 60 - 70 грам, м''якуш дуже приємного смаку, щільний, дуже солодкий з апельсиновим післясмаком і незвичайним приємним ароматом. Кісточка відділяється добре. Плоди мають властивість дозрівання, після зриву можуть деякий час зберігатися і дозрівати.','5.95');
Insert into APRICOTS (APRICOT_ID,APRICOT_NAME,INFO,PRICE) values ('9','Банзай','Абрикос Банзай виведений у Франції, селекція характеризується супер ранніми термінами дозрівання плодів. Збирання врожаю в умовах півдня України з другої половини червня. Плоди великі, середньою масою 50 - 65 грам, овальні, насичено помаранчевого забарвлення з розмитим червоним рум''янцем. М''якуш щільний, волокнистий, солодкий, з приємним ароматом.','6.29');
Insert into APRICOTS (APRICOT_ID,APRICOT_NAME,INFO,PRICE) values ('10','Єгипетський Фараон','Абрикос Єгипетський Фараон відрізняється надраннім терміном дозрівання, на початку червня. Плоди великі 80 - 100 грам, м''якуш соковитий, без прожилок. Забарвлення плодів жовте-жовтогаряче. Плоди мають незрівнянний аромат і високі смакові якості.','5.49');
Insert into APRICOTS (APRICOT_ID,APRICOT_NAME,INFO,PRICE) values ('11','Персиковий','Абрикос Персиковий – середньостиглий сорт, першими плодами можна поласувати наприкінці липня – на початку серпня. Плоди великі, масою 40 - 60 грам, світло-жовтого кольору з рожевим рум''янцем. Вони вкриті легким пушком, як персики, звідси, мабуть, назва сорту. Форма плодів витягнута, горбиста, явно виражений черевний шов посередині. М''якуш абрикосів жовтий, солодкий, досить щільний, без кислинки. Встигають плоди нерівномірно, можна збирати кілька разів на літо. Є слабкий персиковий аромат. Кісточка відокремлюється погано. ','6');
Insert into APRICOTS (APRICOT_ID,APRICOT_NAME,INFO,PRICE) values ('12','Пріція','Абрикос Пріція – новий дуже ранній сорт абрикосу селекції Франції. Дозрівання врожаю на початку червня. Належить до надранніх сортів абрикоса. Плоди середніх та великих розмірів масою 60 - 80 грам, що для дуже раннього сорту є відмінним показником. Плоди округлої форми, помаранчевого забарвлення, з рівномірним малиновим рум''янцем на більшій поверхні плода, який часто заповнює 100% поверхні при гарному освітленні сонцем. Плоди зовні дуже красиві і привабливі. М''якуш плодів помаранчевий, дуже соковитий, щільний, з відмінним збалансованим кисло-солодким смаком.','5.9');
Insert into APRICOTS (APRICOT_ID,APRICOT_NAME,INFO,PRICE) values ('13','Ред Тардів','Абрикос Ред Тардів - середньо-ранній, великоплідний, невибагливий. Це новий цікавий сорт канадського походження. Плоди дуже великі, в середньому маса становить 120-150 грам (деякі плоди можуть досягати до 200 г), округлої форми, повністю покриті насиченим червоним рум''янцем. М''якуш оранжевого забарвлення, дуже ароматний, з кислинкою. Плоди абрикоса Ред Тардів споживаються у свіжому та переробленому вигляді (компоти, джеми, варення, сухофрукти).','5.95');
Insert into APRICOTS (APRICOT_ID,APRICOT_NAME,INFO,PRICE) values ('14','Рубіста','Абрикос Рубіста - новий ранній сорт абрикоса селекції Франції. Дозрівання врожаю – 15-20 червня. Сорт відноситься до нових великоплідних ранніх сортів з інтенсивним забарвленням плодів. Маса плодів 70 - 80 грам, окремі плоди більші. Форма плодів округла. Забарвлення плодів інтенсивне, рубіново-червоного кольору, дуже помітне. На сонячному боці плоди практично повністю покриті рум''янцем. М''якуш плодів дуже соковитий, середньої щільності, відмінного збалансованого кисло-солодкого смаку, з запашним абрикосовим ароматом.','6.29');
Insert into APRICOTS (APRICOT_ID,APRICOT_NAME,INFO,PRICE) values ('15','Том Кот','Абрикос Том Кот - американський сорт абрикоса середнього терміну дозрівання. Отриманий від схрещування сортів Rival та Goldrich. Плоди великі середньою вагою 80 грам, окремі екземпляри досягають 110 грам, видовжено-кулястої форми, вершина плода злегка звужена. Рум''янець червоного кольору на 10-40% поверхні. Дуже хороший збалансований смак, із специфічним присмаком. М''якуш помаранчевий, дуже щільний. Плоди привабливі та товарні.','5.49');
Insert into APRICOTS (APRICOT_ID,APRICOT_NAME,INFO,PRICE) values ('16','Фарбелі','Абрикос Фарбелі - новий пізній сорт абрикоса. Селекція Франції. Плоди дуже великі, округло-подовженої форми, масою 90 - 100 грам, окремі більші, досягають 140 грам, насичено-оранжевого кольору, з червоним рум''янцем на 30-60% поверхні плода. При повному дозріванні плоди майже повністю стають червоні. Смакові якості сорту високі.','6');
Insert into APRICOTS (APRICOT_ID,APRICOT_NAME,INFO,PRICE) values ('17','Фардао','Абрикос Фардао – новий дуже пізній сорт абрикосу з дозріванням плодів у вересні. Селекція Франції. Плоди масою близько 50 грам, окремі крупніше, видовжено-конічної форми, злегка загострені до вершини, вираженим швом, привабливого яскраво-жовтогарячого забарвлення з не сильно вираженим точковим червоним рум''янцем. М''якуш щільної консистенції, помаранчевий, дуже соковитий, хрящуватий і повністю м''який при дозріванні. Смакові якості, високі, смак практично повністю солодкий, із невеликим вмістом кислоти, дуже ароматні.','5.9');
CREATE UNIQUE INDEX "APRICOTS_PK" ON "APRICOTS" ("APRICOT_ID");
ALTER TABLE "APRICOTS" MODIFY ("APRICOT_ID" NOT NULL ENABLE);
ALTER TABLE "APRICOTS" MODIFY ("APRICOT_NAME" NOT NULL ENABLE);
ALTER TABLE "APRICOTS" MODIFY ("INFO" NOT NULL ENABLE);
ALTER TABLE "APRICOTS" MODIFY ("PRICE" NOT NULL ENABLE);
ALTER TABLE "APRICOTS" ADD CONSTRAINT "APRICOTS_PK" PRIMARY KEY ("APRICOT_ID") USING INDEX;
CREATE TABLE "GALLERY"
(
    "GROUP_ID" NUMBER,
    "GROUP_NAME" VARCHAR2(100 CHAR)
);
Insert into GALLERY (GROUP_ID,GROUP_NAME) values ('1','Догляд за садом');
Insert into GALLERY (GROUP_ID,GROUP_NAME) values ('2','Дерева');
Insert into GALLERY (GROUP_ID,GROUP_NAME) values ('3','Плоди');
Insert into GALLERY (GROUP_ID,GROUP_NAME) values ('5','Садівля');
Insert into GALLERY (GROUP_ID,GROUP_NAME) values ('4','Цвітіння');
CREATE UNIQUE INDEX "GALLERY_PK" ON "GALLERY" ("GROUP_ID");
ALTER TABLE "GALLERY" MODIFY ("GROUP_ID" NOT NULL ENABLE);
ALTER TABLE "GALLERY" MODIFY ("GROUP_NAME" NOT NULL ENABLE);
ALTER TABLE "GALLERY" ADD CONSTRAINT "GALLERY_PK" PRIMARY KEY ("GROUP_ID") USING INDEX;
CREATE TABLE "GALLERY_IMAGES"
(
  "IMAGE_ID"   NUMBER,
  "GROUP_ID"   NUMBER,
  "IMAGE_FILE" VARCHAR2(120 BYTE)
);
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('1','1','1(1).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('2','1','1(2).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('3','1','1(3).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('4','1','1(4).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('5','1','1(5).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('6','1','1(6).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('7','1','1(7).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('8','1','1(8).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('9','2','2(1).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('10','2','2(2).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('11','2','2(3).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('12','2','2(4).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('13','2','2(5).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('14','2','2(6).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('15','2','2(7).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('16','2','2(8).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('17','2','2(9).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('18','2','2(10).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('19','2','2(11).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('20','2','2(12).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('21','2','2(13).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('22','2','2(14).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('23','2','2(15).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('24','2','2(16).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('25','2','2(17).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('26','2','2(18).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('27','2','2(19).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('28','2','2(20).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('29','2','2(21).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('30','2','2(22).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('31','3','3(1).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('32','3','3(2).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('33','3','3(3).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('34','3','3(4).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('35','3','3(5).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('36','3','3(6).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('37','3','3(7).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('38','3','3(8).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('39','3','3(9).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('40','3','3(10).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('41','3','3(11).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('42','3','3(12).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('43','3','3(13).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('44','3','3(14).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('45','3','3(15).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('46','4','4(1).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('47','4','4(2).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('48','4','4(3).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('49','4','4(4).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('50','4','4(5).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('51','4','4(6).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('52','4','4(7).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('53','4','4(8).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('54','5','5(1).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('55','5','5(2).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('56','5','5(3).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('57','5','5(4).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('58','5','5(5).jpg');
Insert into GALLERY_IMAGES (IMAGE_ID,GROUP_ID,IMAGE_FILE) values ('59','5','5(6).jpg');
CREATE UNIQUE INDEX "GALLERY_IMAGES_PK" ON "GALLERY_IMAGES" ("IMAGE_ID");
ALTER TABLE "GALLERY_IMAGES" MODIFY ("IMAGE_ID" NOT NULL ENABLE);
ALTER TABLE "GALLERY_IMAGES" MODIFY ("GROUP_ID" NOT NULL ENABLE);
ALTER TABLE "GALLERY_IMAGES" ADD CONSTRAINT "GALLERY_IMAGES_PK" PRIMARY KEY ("IMAGE_ID") USING INDEX;
CREATE TABLE "ORDER_ITEMS"
(
  "ITEM_ID"    NUMBER(10,0),
  "APRICOT_ID" NUMBER(10,0),
  "ORDER_ID"   NUMBER(10,0),
  "QUANTITY"   NUMBER
);
CREATE UNIQUE INDEX "ORDER_ITEMS_PK" ON "ORDER_ITEMS" ("ITEM_ID");
ALTER TABLE "ORDER_ITEMS" MODIFY ("ITEM_ID" NOT NULL ENABLE);
ALTER TABLE "ORDER_ITEMS" MODIFY ("APRICOT_ID" NOT NULL ENABLE);
ALTER TABLE "ORDER_ITEMS" MODIFY ("ORDER_ID" NOT NULL ENABLE);
ALTER TABLE "ORDER_ITEMS" ADD CONSTRAINT "ORDER_ITEMS_PK" PRIMARY KEY ("ITEM_ID") USING INDEX;
CREATE TABLE "ORDERS"
(
  "ORDER_ID"            NUMBER(10,0),
  "USER_ID"             NUMBER(10,0),
  "ORDER_DATE"          DATE,
  "TOTAL_PRICE"         NUMBER,
  "ORDER_DETAILS"       VARCHAR2(512 CHAR),
  "ADDRESS"             VARCHAR2(255 CHAR),
  "CITY"                VARCHAR2(255 CHAR),
  "EMAIL"               VARCHAR2(255 CHAR),
  "FULLNAME"            VARCHAR2(255 CHAR),
  "PAYMENT"             VARCHAR2(255 CHAR),
  "TOTAL_PRICE_HRYVNIA" FLOAT(126)
);
CREATE UNIQUE INDEX "ORDERS_PK" ON "ORDERS" ("ORDER_ID");
ALTER TABLE "ORDERS" MODIFY ("ORDER_ID" NOT NULL ENABLE);
ALTER TABLE "ORDERS" MODIFY ("USER_ID" NOT NULL ENABLE);
ALTER TABLE "ORDERS" MODIFY ("ORDER_DATE" NOT NULL ENABLE);
ALTER TABLE "ORDERS" MODIFY ("TOTAL_PRICE" NOT NULL ENABLE);
ALTER TABLE "ORDERS" ADD CONSTRAINT "ORDERS_PK" PRIMARY KEY ("ORDER_ID") USING INDEX;
CREATE TABLE "USERS"
(
  "USER_ID"    NUMBER(10,0),
  "PASSWORD"   VARCHAR2(255 CHAR),
  "FIRST_NAME" VARCHAR2(255 CHAR),
  "LAST_NAME"  VARCHAR2(255 CHAR),
  "EMAIL"      VARCHAR2(255 CHAR)
);
CREATE UNIQUE INDEX "UK_TPNK0STT195GBCYLVLVTIXMSL" ON "USERS" ("EMAIL");
CREATE UNIQUE INDEX "USERS_PK" ON "USERS" ("USER_ID");
ALTER TABLE "USERS" MODIFY ("USER_ID" NOT NULL ENABLE);
ALTER TABLE "USERS" MODIFY ("PASSWORD" NOT NULL ENABLE);
ALTER TABLE "USERS" MODIFY ("EMAIL" NOT NULL ENABLE);
ALTER TABLE "USERS" ADD CONSTRAINT "USERS_PK" PRIMARY KEY ("USER_ID") USING INDEX;
ALTER TABLE "USERS" MODIFY ("FIRST_NAME" NOT NULL ENABLE);
ALTER TABLE "USERS" MODIFY ("LAST_NAME" NOT NULL ENABLE);
ALTER TABLE "USERS" ADD CONSTRAINT "UK_TPNK0STT195GBCYLVLVTIXMSL" UNIQUE ("EMAIL") USING INDEX;
ALTER TABLE "APRICOT_IMAGES" ADD CONSTRAINT "APRICOT_IMAGES_FK1" FOREIGN KEY ("APRICOT_ID")
  REFERENCES "APRICOTS" ("APRICOT_ID") ENABLE;
ALTER TABLE "GALLERY_IMAGES" ADD CONSTRAINT "GALLERY_IMAGES_FK1" FOREIGN KEY ("GROUP_ID")
  REFERENCES "GALLERY" ("GROUP_ID") ENABLE;
ALTER TABLE "ORDER_ITEMS" ADD CONSTRAINT "ORDER_ITEMS_FK1" FOREIGN KEY ("APRICOT_ID")
  REFERENCES "APRICOTS" ("APRICOT_ID") ENABLE;
ALTER TABLE "ORDER_ITEMS" ADD CONSTRAINT "ORDER_ITEMS_FK2" FOREIGN KEY ("ORDER_ID")
  REFERENCES "ORDERS" ("ORDER_ID") ENABLE;
ALTER TABLE "ORDERS" ADD CONSTRAINT "ORDERS_FK1" FOREIGN KEY ("USER_ID")
  REFERENCES "USERS" ("USER_ID") ENABLE;