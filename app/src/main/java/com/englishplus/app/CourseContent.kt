package com.englishplus.app

data class CourseUnit(val number: Int, val title: String, val lessons: List<CourseLesson>)
data class CourseLesson(val number: Int, val title: String, val exercises: List<Exercise>)

object CourseContent {
    val units: List<CourseUnit> = listOf(
        CourseUnit(1, "التعارف والتحيات", listOf(
            CourseLesson(1, "التحية والتوديع", listOf(
                Exercise("HELLO", "hello", "ما معنى هذه الكلمة؟", listOf("مرحباً", "إلى اللقاء", "من فضلك"), "مرحباً", "I like hello."),
                Exercise("GOODBYE", "goodbye", "ما معنى هذه الكلمة؟", listOf("من فضلك", "شكراً", "إلى اللقاء"), "إلى اللقاء", "I like goodbye."),
                Exercise("PLEASE", "please", "ما معنى هذه الكلمة؟", listOf("أهلاً بك", "من فضلك", "شكراً"), "من فضلك", "I like please."),
                Exercise("THANKS", "thanks", "ما معنى هذه الكلمة؟", listOf("شكراً", "أهلاً بك", "اسم"), "شكراً", "I like thanks."),
                Exercise("WELCOME", "welcome", "ما معنى هذه الكلمة؟", listOf("اسم", "الاسم الشخصي", "أهلاً بك"), "أهلاً بك", "I like welcome.")
            )),
            CourseLesson(2, "التعريف بالنفس", listOf(
                Exercise("NAME", "name", "ما معنى هذه الكلمة؟", listOf("الاسم الشخصي", "اسم العائلة", "اسم"), "اسم", "I like name."),
                Exercise("FIRST NAME", "first name", "ما معنى هذه الكلمة؟", listOf("العمر", "الاسم الشخصي", "اسم العائلة"), "الاسم الشخصي", "I like first name."),
                Exercise("LAST NAME", "last name", "ما معنى هذه الكلمة؟", listOf("اسم العائلة", "العمر", "العنوان"), "اسم العائلة", "I like last name."),
                Exercise("AGE", "age", "ما معنى هذه الكلمة؟", listOf("العنوان", "بلد", "العمر"), "العمر", "I like age."),
                Exercise("ADDRESS", "address", "ما معنى هذه الكلمة؟", listOf("مدينة", "العنوان", "بلد"), "العنوان", "I like address.")
            )),
            CourseLesson(3, "البلدان واللغات", listOf(
                Exercise("COUNTRY", "country", "ما معنى هذه الكلمة؟", listOf("لغة", "بلد", "مدينة"), "بلد", "I like country."),
                Exercise("CITY", "city", "ما معنى هذه الكلمة؟", listOf("مدينة", "لغة", "الجنسية"), "مدينة", "I like city."),
                Exercise("LANGUAGE", "language", "ما معنى هذه الكلمة؟", listOf("الجنسية", "المغرب", "لغة"), "لغة", "I like language."),
                Exercise("NATIONALITY", "nationality", "ما معنى هذه الكلمة؟", listOf("بخير", "الجنسية", "المغرب"), "الجنسية", "I like nationality."),
                Exercise("MOROCCO", "morocco", "ما معنى هذه الكلمة؟", listOf("المغرب", "بخير", "سعيد"), "المغرب", "I like morocco.")
            )),
            CourseLesson(4, "السؤال عن الحال", listOf(
                Exercise("FINE", "fine", "ما معنى هذه الكلمة؟", listOf("بخير", "سعيد", "متعب"), "بخير", "I like fine."),
                Exercise("HAPPY", "happy", "ما معنى هذه الكلمة؟", listOf("متعب", "آسف", "سعيد"), "سعيد", "I like happy."),
                Exercise("TIRED", "tired", "ما معنى هذه الكلمة؟", listOf("عذراً", "متعب", "آسف"), "متعب", "I like tired."),
                Exercise("SORRY", "sorry", "ما معنى هذه الكلمة؟", listOf("آسف", "عذراً", "يلتقي"), "آسف", "I like sorry."),
                Exercise("EXCUSE ME", "excuse me", "ما معنى هذه الكلمة؟", listOf("يلتقي", "يعرّف", "عذراً"), "عذراً", "I like excuse me.")
            )),
            CourseLesson(5, "مراجعة التعارف", listOf(
                Exercise("MEET", "meet", "ما معنى هذه الكلمة؟", listOf("يعرّف", "يتحدث", "يلتقي"), "يلتقي", "I like meet."),
                Exercise("INTRODUCE", "introduce", "ما معنى هذه الكلمة؟", listOf("يعيش", "يعرّف", "يتحدث"), "يعرّف", "I like introduce."),
                Exercise("SPEAK", "speak", "ما معنى هذه الكلمة؟", listOf("يتحدث", "يعيش", "من"), "يتحدث", "I like speak."),
                Exercise("LIVE", "live", "ما معنى هذه الكلمة؟", listOf("من", "مرحباً", "يعيش"), "يعيش", "I like live."),
                Exercise("FROM", "from", "ما معنى هذه الكلمة؟", listOf("إلى اللقاء", "من", "مرحباً"), "من", "I like from.")
            ))
        )),
        CourseUnit(2, "الأرقام والعائلة", listOf(
            CourseLesson(6, "الأرقام الأساسية", listOf(
                Exercise("ONE", "one", "ما معنى هذه الكلمة؟", listOf("واحد", "اثنان", "ثلاثة"), "واحد", "I like one."),
                Exercise("TWO", "two", "ما معنى هذه الكلمة؟", listOf("ثلاثة", "أربعة", "اثنان"), "اثنان", "I like two."),
                Exercise("THREE", "three", "ما معنى هذه الكلمة؟", listOf("خمسة", "ثلاثة", "أربعة"), "ثلاثة", "I like three."),
                Exercise("FOUR", "four", "ما معنى هذه الكلمة؟", listOf("أربعة", "خمسة", "ستة"), "أربعة", "I like four."),
                Exercise("FIVE", "five", "ما معنى هذه الكلمة؟", listOf("ستة", "سبعة", "خمسة"), "خمسة", "I like five.")
            )),
            CourseLesson(7, "أفراد العائلة", listOf(
                Exercise("SIX", "six", "ما معنى هذه الكلمة؟", listOf("سبعة", "ثمانية", "ستة"), "ستة", "I like six."),
                Exercise("SEVEN", "seven", "ما معنى هذه الكلمة؟", listOf("تسعة", "سبعة", "ثمانية"), "سبعة", "I like seven."),
                Exercise("EIGHT", "eight", "ما معنى هذه الكلمة؟", listOf("ثمانية", "تسعة", "عشرة"), "ثمانية", "I like eight."),
                Exercise("NINE", "nine", "ما معنى هذه الكلمة؟", listOf("عشرة", "أم", "تسعة"), "تسعة", "I like nine."),
                Exercise("TEN", "ten", "ما معنى هذه الكلمة؟", listOf("أب", "عشرة", "أم"), "عشرة", "I like ten.")
            )),
            CourseLesson(8, "العمر والعدد", listOf(
                Exercise("MOTHER", "mother", "ما معنى هذه الكلمة؟", listOf("أخ", "أم", "أب"), "أم", "I like mother."),
                Exercise("FATHER", "father", "ما معنى هذه الكلمة؟", listOf("أب", "أخ", "أخت"), "أب", "I like father."),
                Exercise("BROTHER", "brother", "ما معنى هذه الكلمة؟", listOf("أخت", "الوالدان", "أخ"), "أخ", "I like brother."),
                Exercise("SISTER", "sister", "ما معنى هذه الكلمة؟", listOf("ابن", "أخت", "الوالدان"), "أخت", "I like sister."),
                Exercise("PARENTS", "parents", "ما معنى هذه الكلمة؟", listOf("الوالدان", "ابن", "ابنة"), "الوالدان", "I like parents.")
            )),
            CourseLesson(9, "وصف العائلة", listOf(
                Exercise("SON", "son", "ما معنى هذه الكلمة؟", listOf("ابن", "ابنة", "جدة"), "ابن", "I like son."),
                Exercise("DAUGHTER", "daughter", "ما معنى هذه الكلمة؟", listOf("جدة", "جد", "ابنة"), "ابنة", "I like daughter."),
                Exercise("GRANDMOTHER", "grandmother", "ما معنى هذه الكلمة؟", listOf("عائلة", "جدة", "جد"), "جدة", "I like grandmother."),
                Exercise("GRANDFATHER", "grandfather", "ما معنى هذه الكلمة؟", listOf("جد", "عائلة", "طفل"), "جد", "I like grandfather."),
                Exercise("FAMILY", "family", "ما معنى هذه الكلمة؟", listOf("طفل", "أطفال", "عائلة"), "عائلة", "I like family.")
            )),
            CourseLesson(10, "مراجعة العائلة والأرقام", listOf(
                Exercise("CHILD", "child", "ما معنى هذه الكلمة؟", listOf("أطفال", "صغير السن", "طفل"), "طفل", "I like child."),
                Exercise("CHILDREN", "children", "ما معنى هذه الكلمة؟", listOf("كبير السن", "أطفال", "صغير السن"), "أطفال", "I like children."),
                Exercise("YOUNG", "young", "ما معنى هذه الكلمة؟", listOf("صغير السن", "كبير السن", "ابن العم أو الخال"), "صغير السن", "I like young."),
                Exercise("OLD", "old", "ما معنى هذه الكلمة؟", listOf("ابن العم أو الخال", "واحد", "كبير السن"), "كبير السن", "I like old."),
                Exercise("COUSIN", "cousin", "ما معنى هذه الكلمة؟", listOf("اثنان", "ابن العم أو الخال", "واحد"), "ابن العم أو الخال", "I like cousin.")
            ))
        )),
        CourseUnit(3, "المنزل والأشياء", listOf(
            CourseLesson(11, "غرف المنزل", listOf(
                Exercise("HOUSE", "house", "ما معنى هذه الكلمة؟", listOf("منزل", "شقة", "غرفة"), "منزل", "I like house."),
                Exercise("APARTMENT", "apartment", "ما معنى هذه الكلمة؟", listOf("غرفة", "مطبخ", "شقة"), "شقة", "I like apartment."),
                Exercise("ROOM", "room", "ما معنى هذه الكلمة؟", listOf("غرفة نوم", "غرفة", "مطبخ"), "غرفة", "I like room."),
                Exercise("KITCHEN", "kitchen", "ما معنى هذه الكلمة؟", listOf("مطبخ", "غرفة نوم", "حمام"), "مطبخ", "I like kitchen."),
                Exercise("BEDROOM", "bedroom", "ما معنى هذه الكلمة؟", listOf("حمام", "غرفة الجلوس", "غرفة نوم"), "غرفة نوم", "I like bedroom.")
            )),
            CourseLesson(12, "الأثاث", listOf(
                Exercise("BATHROOM", "bathroom", "ما معنى هذه الكلمة؟", listOf("غرفة الجلوس", "باب", "حمام"), "حمام", "I like bathroom."),
                Exercise("LIVING ROOM", "living room", "ما معنى هذه الكلمة؟", listOf("نافذة", "غرفة الجلوس", "باب"), "غرفة الجلوس", "I like living room."),
                Exercise("DOOR", "door", "ما معنى هذه الكلمة؟", listOf("باب", "نافذة", "حديقة"), "باب", "I like door."),
                Exercise("WINDOW", "window", "ما معنى هذه الكلمة؟", listOf("حديقة", "طاولة", "نافذة"), "نافذة", "I like window."),
                Exercise("GARDEN", "garden", "ما معنى هذه الكلمة؟", listOf("كرسي", "حديقة", "طاولة"), "حديقة", "I like garden.")
            )),
            CourseLesson(13, "أشياء يومية", listOf(
                Exercise("TABLE", "table", "ما معنى هذه الكلمة؟", listOf("سرير", "طاولة", "كرسي"), "طاولة", "I like table."),
                Exercise("CHAIR", "chair", "ما معنى هذه الكلمة؟", listOf("كرسي", "سرير", "أريكة"), "كرسي", "I like chair."),
                Exercise("BED", "bed", "ما معنى هذه الكلمة؟", listOf("أريكة", "مكتب", "سرير"), "سرير", "I like bed."),
                Exercise("SOFA", "sofa", "ما معنى هذه الكلمة؟", listOf("مفتاح", "أريكة", "مكتب"), "أريكة", "I like sofa."),
                Exercise("DESK", "desk", "ما معنى هذه الكلمة؟", listOf("مكتب", "مفتاح", "هاتف"), "مكتب", "I like desk.")
            )),
            CourseLesson(14, "وصف المنزل", listOf(
                Exercise("KEY", "key", "ما معنى هذه الكلمة؟", listOf("مفتاح", "هاتف", "كتاب"), "مفتاح", "I like key."),
                Exercise("PHONE", "phone", "ما معنى هذه الكلمة؟", listOf("كتاب", "قلم", "هاتف"), "هاتف", "I like phone."),
                Exercise("BOOK", "book", "ما معنى هذه الكلمة؟", listOf("حقيبة", "كتاب", "قلم"), "كتاب", "I like book."),
                Exercise("PEN", "pen", "ما معنى هذه الكلمة؟", listOf("قلم", "حقيبة", "نظيف"), "قلم", "I like pen."),
                Exercise("BAG", "bag", "ما معنى هذه الكلمة؟", listOf("نظيف", "كبير", "حقيبة"), "حقيبة", "I like bag.")
            )),
            CourseLesson(15, "مراجعة المنزل", listOf(
                Exercise("CLEAN", "clean", "ما معنى هذه الكلمة؟", listOf("كبير", "صغير", "نظيف"), "نظيف", "I like clean."),
                Exercise("BIG", "big", "ما معنى هذه الكلمة؟", listOf("مفتوح", "كبير", "صغير"), "كبير", "I like big."),
                Exercise("SMALL", "small", "ما معنى هذه الكلمة؟", listOf("صغير", "مفتوح", "مغلق"), "صغير", "I like small."),
                Exercise("OPEN", "open", "ما معنى هذه الكلمة؟", listOf("مغلق", "منزل", "مفتوح"), "مفتوح", "I like open."),
                Exercise("CLOSED", "closed", "ما معنى هذه الكلمة؟", listOf("شقة", "مغلق", "منزل"), "مغلق", "I like closed.")
            ))
        )),
        CourseUnit(4, "الطعام والشراب", listOf(
            CourseLesson(16, "الفواكه والخضروات", listOf(
                Exercise("APPLE", "apple", "ما معنى هذه الكلمة؟", listOf("تفاحة", "موزة", "برتقالة"), "تفاحة", "I like apple."),
                Exercise("BANANA", "banana", "ما معنى هذه الكلمة؟", listOf("برتقالة", "عنب", "موزة"), "موزة", "I like banana."),
                Exercise("ORANGE", "orange", "ما معنى هذه الكلمة؟", listOf("ليمون", "برتقالة", "عنب"), "برتقالة", "I like orange."),
                Exercise("GRAPES", "grapes", "ما معنى هذه الكلمة؟", listOf("عنب", "ليمون", "طماطم"), "عنب", "I like grapes."),
                Exercise("LEMON", "lemon", "ما معنى هذه الكلمة؟", listOf("طماطم", "بطاطس", "ليمون"), "ليمون", "I like lemon.")
            )),
            CourseLesson(17, "الوجبات", listOf(
                Exercise("TOMATO", "tomato", "ما معنى هذه الكلمة؟", listOf("بطاطس", "جزر", "طماطم"), "طماطم", "I like tomato."),
                Exercise("POTATO", "potato", "ما معنى هذه الكلمة؟", listOf("بصل", "بطاطس", "جزر"), "بطاطس", "I like potato."),
                Exercise("CARROT", "carrot", "ما معنى هذه الكلمة؟", listOf("جزر", "بصل", "سلطة"), "جزر", "I like carrot."),
                Exercise("ONION", "onion", "ما معنى هذه الكلمة؟", listOf("سلطة", "خبز", "بصل"), "بصل", "I like onion."),
                Exercise("SALAD", "salad", "ما معنى هذه الكلمة؟", listOf("أرز", "سلطة", "خبز"), "سلطة", "I like salad.")
            )),
            CourseLesson(18, "المشروبات", listOf(
                Exercise("BREAD", "bread", "ما معنى هذه الكلمة؟", listOf("بيضة", "خبز", "أرز"), "خبز", "I like bread."),
                Exercise("RICE", "rice", "ما معنى هذه الكلمة؟", listOf("أرز", "بيضة", "جبن"), "أرز", "I like rice."),
                Exercise("EGG", "egg", "ما معنى هذه الكلمة؟", listOf("جبن", "دجاج", "بيضة"), "بيضة", "I like egg."),
                Exercise("CHEESE", "cheese", "ما معنى هذه الكلمة؟", listOf("فطور", "جبن", "دجاج"), "جبن", "I like cheese."),
                Exercise("CHICKEN", "chicken", "ما معنى هذه الكلمة؟", listOf("دجاج", "فطور", "غداء"), "دجاج", "I like chicken.")
            )),
            CourseLesson(19, "في المطعم", listOf(
                Exercise("BREAKFAST", "breakfast", "ما معنى هذه الكلمة؟", listOf("فطور", "غداء", "عشاء"), "فطور", "I like breakfast."),
                Exercise("LUNCH", "lunch", "ما معنى هذه الكلمة؟", listOf("عشاء", "وجبة", "غداء"), "غداء", "I like lunch."),
                Exercise("DINNER", "dinner", "ما معنى هذه الكلمة؟", listOf("قائمة الطعام", "عشاء", "وجبة"), "عشاء", "I like dinner."),
                Exercise("MEAL", "meal", "ما معنى هذه الكلمة؟", listOf("وجبة", "قائمة الطعام", "ماء"), "وجبة", "I like meal."),
                Exercise("MENU", "menu", "ما معنى هذه الكلمة؟", listOf("ماء", "حليب", "قائمة الطعام"), "قائمة الطعام", "I like menu.")
            )),
            CourseLesson(20, "مراجعة الطعام", listOf(
                Exercise("WATER", "water", "ما معنى هذه الكلمة؟", listOf("حليب", "شاي", "ماء"), "ماء", "I like water."),
                Exercise("MILK", "milk", "ما معنى هذه الكلمة؟", listOf("عصير", "حليب", "شاي"), "حليب", "I like milk."),
                Exercise("TEA", "tea", "ما معنى هذه الكلمة؟", listOf("شاي", "عصير", "جائع"), "شاي", "I like tea."),
                Exercise("JUICE", "juice", "ما معنى هذه الكلمة؟", listOf("جائع", "تفاحة", "عصير"), "عصير", "I like juice."),
                Exercise("HUNGRY", "hungry", "ما معنى هذه الكلمة؟", listOf("موزة", "جائع", "تفاحة"), "جائع", "I like hungry.")
            ))
        )),
        CourseUnit(5, "الحياة اليومية", listOf(
            CourseLesson(21, "أفعال يومية", listOf(
                Exercise("WAKE UP", "wake up", "ما معنى هذه الكلمة؟", listOf("يستيقظ", "ينهض", "يغسل"), "يستيقظ", "I like wake up."),
                Exercise("GET UP", "get up", "ما معنى هذه الكلمة؟", listOf("يغسل", "استحمام", "ينهض"), "ينهض", "I like get up."),
                Exercise("WASH", "wash", "ما معنى هذه الكلمة؟", listOf("يرتدي", "يغسل", "استحمام"), "يغسل", "I like wash."),
                Exercise("SHOWER", "shower", "ما معنى هذه الكلمة؟", listOf("استحمام", "يرتدي", "يأكل"), "استحمام", "I like shower."),
                Exercise("DRESS", "dress", "ما معنى هذه الكلمة؟", listOf("يأكل", "يشرب", "يرتدي"), "يرتدي", "I like dress.")
            )),
            CourseLesson(22, "الاستيقاظ والنوم", listOf(
                Exercise("EAT", "eat", "ما معنى هذه الكلمة؟", listOf("يشرب", "يذهب", "يأكل"), "يأكل", "I like eat."),
                Exercise("DRINK", "drink", "ما معنى هذه الكلمة؟", listOf("يأتي", "يشرب", "يذهب"), "يشرب", "I like drink."),
                Exercise("GO", "go", "ما معنى هذه الكلمة؟", listOf("يذهب", "يأتي", "يعود"), "يذهب", "I like go."),
                Exercise("COME", "come", "ما معنى هذه الكلمة؟", listOf("يعود", "يعمل", "يأتي"), "يأتي", "I like come."),
                Exercise("RETURN", "return", "ما معنى هذه الكلمة؟", listOf("يدرس", "يعود", "يعمل"), "يعود", "I like return.")
            )),
            CourseLesson(23, "العمل والدراسة", listOf(
                Exercise("WORK", "work", "ما معنى هذه الكلمة؟", listOf("يقرأ", "يعمل", "يدرس"), "يعمل", "I like work."),
                Exercise("STUDY", "study", "ما معنى هذه الكلمة؟", listOf("يدرس", "يقرأ", "يكتب"), "يدرس", "I like study."),
                Exercise("READ", "read", "ما معنى هذه الكلمة؟", listOf("يكتب", "يستمع", "يقرأ"), "يقرأ", "I like read."),
                Exercise("WRITE", "write", "ما معنى هذه الكلمة؟", listOf("يشاهد", "يكتب", "يستمع"), "يكتب", "I like write."),
                Exercise("LISTEN", "listen", "ما معنى هذه الكلمة؟", listOf("يستمع", "يشاهد", "ينام"), "يستمع", "I like listen.")
            )),
            CourseLesson(24, "أوقات الفراغ", listOf(
                Exercise("WATCH", "watch", "ما معنى هذه الكلمة؟", listOf("يشاهد", "ينام", "يطبخ"), "يشاهد", "I like watch."),
                Exercise("SLEEP", "sleep", "ما معنى هذه الكلمة؟", listOf("يطبخ", "ينظف", "ينام"), "ينام", "I like sleep."),
                Exercise("COOK", "cook", "ما معنى هذه الكلمة؟", listOf("يمشي", "يطبخ", "ينظف"), "يطبخ", "I like cook."),
                Exercise("CLEAN", "clean", "ما معنى هذه الكلمة؟", listOf("ينظف", "يمشي", "عادةً"), "ينظف", "I like clean."),
                Exercise("WALK", "walk", "ما معنى هذه الكلمة؟", listOf("عادةً", "دائماً", "يمشي"), "يمشي", "I like walk.")
            )),
            CourseLesson(25, "مراجعة الروتين", listOf(
                Exercise("USUALLY", "usually", "ما معنى هذه الكلمة؟", listOf("دائماً", "أحياناً", "عادةً"), "عادةً", "I like usually."),
                Exercise("ALWAYS", "always", "ما معنى هذه الكلمة؟", listOf("أبداً", "دائماً", "أحياناً"), "دائماً", "I like always."),
                Exercise("SOMETIMES", "sometimes", "ما معنى هذه الكلمة؟", listOf("أحياناً", "أبداً", "كل يوم"), "أحياناً", "I like sometimes."),
                Exercise("NEVER", "never", "ما معنى هذه الكلمة؟", listOf("كل يوم", "يستيقظ", "أبداً"), "أبداً", "I like never."),
                Exercise("EVERY DAY", "every day", "ما معنى هذه الكلمة؟", listOf("ينهض", "كل يوم", "يستيقظ"), "كل يوم", "I like every day.")
            ))
        )),
        CourseUnit(6, "الوقت والتقويم", listOf(
            CourseLesson(26, "أيام الأسبوع", listOf(
                Exercise("MONDAY", "monday", "ما معنى هذه الكلمة؟", listOf("الاثنين", "الثلاثاء", "الأربعاء"), "الاثنين", "I like monday."),
                Exercise("TUESDAY", "tuesday", "ما معنى هذه الكلمة؟", listOf("الأربعاء", "الخميس", "الثلاثاء"), "الثلاثاء", "I like tuesday."),
                Exercise("WEDNESDAY", "wednesday", "ما معنى هذه الكلمة؟", listOf("الجمعة", "الأربعاء", "الخميس"), "الأربعاء", "I like wednesday."),
                Exercise("THURSDAY", "thursday", "ما معنى هذه الكلمة؟", listOf("الخميس", "الجمعة", "السبت"), "الخميس", "I like thursday."),
                Exercise("FRIDAY", "friday", "ما معنى هذه الكلمة؟", listOf("السبت", "الأحد", "الجمعة"), "الجمعة", "I like friday.")
            )),
            CourseLesson(27, "أشهر السنة", listOf(
                Exercise("SATURDAY", "saturday", "ما معنى هذه الكلمة؟", listOf("الأحد", "يناير", "السبت"), "السبت", "I like saturday."),
                Exercise("SUNDAY", "sunday", "ما معنى هذه الكلمة؟", listOf("فبراير", "الأحد", "يناير"), "الأحد", "I like sunday."),
                Exercise("JANUARY", "january", "ما معنى هذه الكلمة؟", listOf("يناير", "فبراير", "مارس"), "يناير", "I like january."),
                Exercise("FEBRUARY", "february", "ما معنى هذه الكلمة؟", listOf("مارس", "أبريل", "فبراير"), "فبراير", "I like february."),
                Exercise("MARCH", "march", "ما معنى هذه الكلمة؟", listOf("مايو", "مارس", "أبريل"), "مارس", "I like march.")
            )),
            CourseLesson(28, "قراءة الساعة", listOf(
                Exercise("APRIL", "april", "ما معنى هذه الكلمة؟", listOf("يونيو", "أبريل", "مايو"), "أبريل", "I like april."),
                Exercise("MAY", "may", "ما معنى هذه الكلمة؟", listOf("مايو", "يونيو", "يوليو"), "مايو", "I like may."),
                Exercise("JUNE", "june", "ما معنى هذه الكلمة؟", listOf("يوليو", "أغسطس", "يونيو"), "يونيو", "I like june."),
                Exercise("JULY", "july", "ما معنى هذه الكلمة؟", listOf("سبتمبر", "يوليو", "أغسطس"), "يوليو", "I like july."),
                Exercise("AUGUST", "august", "ما معنى هذه الكلمة؟", listOf("أغسطس", "سبتمبر", "أكتوبر"), "أغسطس", "I like august.")
            )),
            CourseLesson(29, "التواريخ", listOf(
                Exercise("SEPTEMBER", "september", "ما معنى هذه الكلمة؟", listOf("سبتمبر", "أكتوبر", "نوفمبر"), "سبتمبر", "I like september."),
                Exercise("OCTOBER", "october", "ما معنى هذه الكلمة؟", listOf("نوفمبر", "ديسمبر", "أكتوبر"), "أكتوبر", "I like october."),
                Exercise("NOVEMBER", "november", "ما معنى هذه الكلمة؟", listOf("عطلة نهاية الأسبوع", "نوفمبر", "ديسمبر"), "نوفمبر", "I like november."),
                Exercise("DECEMBER", "december", "ما معنى هذه الكلمة؟", listOf("ديسمبر", "عطلة نهاية الأسبوع", "اليوم"), "ديسمبر", "I like december."),
                Exercise("WEEKEND", "weekend", "ما معنى هذه الكلمة؟", listOf("اليوم", "غداً", "عطلة نهاية الأسبوع"), "عطلة نهاية الأسبوع", "I like weekend.")
            )),
            CourseLesson(30, "مراجعة الوقت", listOf(
                Exercise("TODAY", "today", "ما معنى هذه الكلمة؟", listOf("غداً", "أمس", "اليوم"), "اليوم", "I like today."),
                Exercise("TOMORROW", "tomorrow", "ما معنى هذه الكلمة؟", listOf("الصباح", "غداً", "أمس"), "غداً", "I like tomorrow."),
                Exercise("YESTERDAY", "yesterday", "ما معنى هذه الكلمة؟", listOf("أمس", "الصباح", "المساء"), "أمس", "I like yesterday."),
                Exercise("MORNING", "morning", "ما معنى هذه الكلمة؟", listOf("المساء", "الاثنين", "الصباح"), "الصباح", "I like morning."),
                Exercise("EVENING", "evening", "ما معنى هذه الكلمة؟", listOf("الثلاثاء", "المساء", "الاثنين"), "المساء", "I like evening.")
            ))
        )),
        CourseUnit(7, "الدراسة والعمل", listOf(
            CourseLesson(31, "المدرسة والمواد", listOf(
                Exercise("SCHOOL", "school", "ما معنى هذه الكلمة؟", listOf("مدرسة", "فصل دراسي", "طالب"), "مدرسة", "I like school."),
                Exercise("CLASSROOM", "classroom", "ما معنى هذه الكلمة؟", listOf("طالب", "معلم", "فصل دراسي"), "فصل دراسي", "I like classroom."),
                Exercise("STUDENT", "student", "ما معنى هذه الكلمة؟", listOf("درس", "طالب", "معلم"), "طالب", "I like student."),
                Exercise("TEACHER", "teacher", "ما معنى هذه الكلمة؟", listOf("معلم", "درس", "اللغة الإنجليزية"), "معلم", "I like teacher."),
                Exercise("LESSON", "lesson", "ما معنى هذه الكلمة؟", listOf("اللغة الإنجليزية", "اللغة العربية", "درس"), "درس", "I like lesson.")
            )),
            CourseLesson(32, "أدوات الدراسة", listOf(
                Exercise("ENGLISH", "english", "ما معنى هذه الكلمة؟", listOf("اللغة العربية", "رياضيات", "اللغة الإنجليزية"), "اللغة الإنجليزية", "I like english."),
                Exercise("ARABIC", "arabic", "ما معنى هذه الكلمة؟", listOf("علوم", "اللغة العربية", "رياضيات"), "اللغة العربية", "I like arabic."),
                Exercise("MATH", "math", "ما معنى هذه الكلمة؟", listOf("رياضيات", "علوم", "تاريخ"), "رياضيات", "I like math."),
                Exercise("SCIENCE", "science", "ما معنى هذه الكلمة؟", listOf("تاريخ", "دفتر", "علوم"), "علوم", "I like science."),
                Exercise("HISTORY", "history", "ما معنى هذه الكلمة؟", listOf("قلم رصاص", "تاريخ", "دفتر"), "تاريخ", "I like history.")
            )),
            CourseLesson(33, "المهن", listOf(
                Exercise("NOTEBOOK", "notebook", "ما معنى هذه الكلمة؟", listOf("ممحاة", "دفتر", "قلم رصاص"), "دفتر", "I like notebook."),
                Exercise("PENCIL", "pencil", "ما معنى هذه الكلمة؟", listOf("قلم رصاص", "ممحاة", "مسطرة"), "قلم رصاص", "I like pencil."),
                Exercise("ERASER", "eraser", "ما معنى هذه الكلمة؟", listOf("مسطرة", "حاسوب", "ممحاة"), "ممحاة", "I like eraser."),
                Exercise("RULER", "ruler", "ما معنى هذه الكلمة؟", listOf("طبيب", "مسطرة", "حاسوب"), "مسطرة", "I like ruler."),
                Exercise("COMPUTER", "computer", "ما معنى هذه الكلمة؟", listOf("حاسوب", "طبيب", "ممرض"), "حاسوب", "I like computer.")
            )),
            CourseLesson(34, "مكان العمل", listOf(
                Exercise("DOCTOR", "doctor", "ما معنى هذه الكلمة؟", listOf("طبيب", "ممرض", "سائق"), "طبيب", "I like doctor."),
                Exercise("NURSE", "nurse", "ما معنى هذه الكلمة؟", listOf("سائق", "مهندس", "ممرض"), "ممرض", "I like nurse."),
                Exercise("DRIVER", "driver", "ما معنى هذه الكلمة؟", listOf("طباخ", "سائق", "مهندس"), "سائق", "I like driver."),
                Exercise("ENGINEER", "engineer", "ما معنى هذه الكلمة؟", listOf("مهندس", "طباخ", "مكتب"), "مهندس", "I like engineer."),
                Exercise("COOK", "cook", "ما معنى هذه الكلمة؟", listOf("مكتب", "مدير", "طباخ"), "طباخ", "I like cook.")
            )),
            CourseLesson(35, "مراجعة الدراسة والعمل", listOf(
                Exercise("OFFICE", "office", "ما معنى هذه الكلمة؟", listOf("مدير", "زميل عمل", "مكتب"), "مكتب", "I like office."),
                Exercise("MANAGER", "manager", "ما معنى هذه الكلمة؟", listOf("وظيفة", "مدير", "زميل عمل"), "مدير", "I like manager."),
                Exercise("COLLEAGUE", "colleague", "ما معنى هذه الكلمة؟", listOf("زميل عمل", "وظيفة", "مشغول"), "زميل عمل", "I like colleague."),
                Exercise("JOB", "job", "ما معنى هذه الكلمة؟", listOf("مشغول", "مدرسة", "وظيفة"), "وظيفة", "I like job."),
                Exercise("BUSY", "busy", "ما معنى هذه الكلمة؟", listOf("فصل دراسي", "مشغول", "مدرسة"), "مشغول", "I like busy.")
            ))
        )),
        CourseUnit(8, "المدينة والمواصلات", listOf(
            CourseLesson(36, "أماكن في المدينة", listOf(
                Exercise("STREET", "street", "ما معنى هذه الكلمة؟", listOf("شارع", "طريق", "بنك"), "شارع", "I like street."),
                Exercise("ROAD", "road", "ما معنى هذه الكلمة؟", listOf("بنك", "مستشفى", "طريق"), "طريق", "I like road."),
                Exercise("BANK", "bank", "ما معنى هذه الكلمة؟", listOf("صيدلية", "بنك", "مستشفى"), "بنك", "I like bank."),
                Exercise("HOSPITAL", "hospital", "ما معنى هذه الكلمة؟", listOf("مستشفى", "صيدلية", "مدرسة"), "مستشفى", "I like hospital."),
                Exercise("PHARMACY", "pharmacy", "ما معنى هذه الكلمة؟", listOf("مدرسة", "مسجد", "صيدلية"), "صيدلية", "I like pharmacy.")
            )),
            CourseLesson(37, "الاتجاهات", listOf(
                Exercise("SCHOOL", "school", "ما معنى هذه الكلمة؟", listOf("مسجد", "حديقة عامة", "مدرسة"), "مدرسة", "I like school."),
                Exercise("MOSQUE", "mosque", "ما معنى هذه الكلمة؟", listOf("محطة", "مسجد", "حديقة عامة"), "مسجد", "I like mosque."),
                Exercise("PARK", "park", "ما معنى هذه الكلمة؟", listOf("حديقة عامة", "محطة", "سوق"), "حديقة عامة", "I like park."),
                Exercise("STATION", "station", "ما معنى هذه الكلمة؟", listOf("سوق", "يسار", "محطة"), "محطة", "I like station."),
                Exercise("MARKET", "market", "ما معنى هذه الكلمة؟", listOf("يمين", "سوق", "يسار"), "سوق", "I like market.")
            )),
            CourseLesson(38, "وسائل النقل", listOf(
                Exercise("LEFT", "left", "ما معنى هذه الكلمة؟", listOf("مستقيماً", "يسار", "يمين"), "يسار", "I like left."),
                Exercise("RIGHT", "right", "ما معنى هذه الكلمة؟", listOf("يمين", "مستقيماً", "قريب"), "يمين", "I like right."),
                Exercise("STRAIGHT", "straight", "ما معنى هذه الكلمة؟", listOf("قريب", "بعيد", "مستقيماً"), "مستقيماً", "I like straight."),
                Exercise("NEAR", "near", "ما معنى هذه الكلمة؟", listOf("حافلة", "قريب", "بعيد"), "قريب", "I like near."),
                Exercise("FAR", "far", "ما معنى هذه الكلمة؟", listOf("بعيد", "حافلة", "قطار"), "بعيد", "I like far.")
            )),
            CourseLesson(39, "السؤال عن الطريق", listOf(
                Exercise("BUS", "bus", "ما معنى هذه الكلمة؟", listOf("حافلة", "قطار", "سيارة"), "حافلة", "I like bus."),
                Exercise("TRAIN", "train", "ما معنى هذه الكلمة؟", listOf("سيارة", "سيارة أجرة", "قطار"), "قطار", "I like train."),
                Exercise("CAR", "car", "ما معنى هذه الكلمة؟", listOf("دراجة", "سيارة", "سيارة أجرة"), "سيارة", "I like car."),
                Exercise("TAXI", "taxi", "ما معنى هذه الكلمة؟", listOf("سيارة أجرة", "دراجة", "تذكرة"), "سيارة أجرة", "I like taxi."),
                Exercise("BICYCLE", "bicycle", "ما معنى هذه الكلمة؟", listOf("تذكرة", "خريطة", "دراجة"), "دراجة", "I like bicycle.")
            )),
            CourseLesson(40, "مراجعة المدينة", listOf(
                Exercise("TICKET", "ticket", "ما معنى هذه الكلمة؟", listOf("خريطة", "يتوقف", "تذكرة"), "تذكرة", "I like ticket."),
                Exercise("MAP", "map", "ما معنى هذه الكلمة؟", listOf("ينعطف", "خريطة", "يتوقف"), "خريطة", "I like map."),
                Exercise("STOP", "stop", "ما معنى هذه الكلمة؟", listOf("يتوقف", "ينعطف", "يسافر"), "يتوقف", "I like stop."),
                Exercise("TURN", "turn", "ما معنى هذه الكلمة؟", listOf("يسافر", "شارع", "ينعطف"), "ينعطف", "I like turn."),
                Exercise("TRAVEL", "travel", "ما معنى هذه الكلمة؟", listOf("طريق", "يسافر", "شارع"), "يسافر", "I like travel.")
            ))
        )),
        CourseUnit(9, "التسوق والملابس", listOf(
            CourseLesson(41, "الملابس الأساسية", listOf(
                Exercise("SHIRT", "shirt", "ما معنى هذه الكلمة؟", listOf("قميص", "سروال", "فستان"), "قميص", "I like shirt."),
                Exercise("TROUSERS", "trousers", "ما معنى هذه الكلمة؟", listOf("فستان", "سترة", "سروال"), "سروال", "I like trousers."),
                Exercise("DRESS", "dress", "ما معنى هذه الكلمة؟", listOf("حذاء", "فستان", "سترة"), "فستان", "I like dress."),
                Exercise("JACKET", "jacket", "ما معنى هذه الكلمة؟", listOf("سترة", "حذاء", "جوارب"), "سترة", "I like jacket."),
                Exercise("SHOES", "shoes", "ما معنى هذه الكلمة؟", listOf("جوارب", "قبعة", "حذاء"), "حذاء", "I like shoes.")
            )),
            CourseLesson(42, "الألوان والمقاسات", listOf(
                Exercise("SOCKS", "socks", "ما معنى هذه الكلمة؟", listOf("قبعة", "وشاح", "جوارب"), "جوارب", "I like socks."),
                Exercise("HAT", "hat", "ما معنى هذه الكلمة؟", listOf("معطف", "قبعة", "وشاح"), "قبعة", "I like hat."),
                Exercise("SCARF", "scarf", "ما معنى هذه الكلمة؟", listOf("وشاح", "معطف", "تنورة"), "وشاح", "I like scarf."),
                Exercise("COAT", "coat", "ما معنى هذه الكلمة؟", listOf("تنورة", "أحمر", "معطف"), "معطف", "I like coat."),
                Exercise("SKIRT", "skirt", "ما معنى هذه الكلمة؟", listOf("أزرق", "تنورة", "أحمر"), "تنورة", "I like skirt.")
            )),
            CourseLesson(43, "الأسعار والمال", listOf(
                Exercise("RED", "red", "ما معنى هذه الكلمة؟", listOf("أخضر", "أحمر", "أزرق"), "أحمر", "I like red."),
                Exercise("BLUE", "blue", "ما معنى هذه الكلمة؟", listOf("أزرق", "أخضر", "أسود"), "أزرق", "I like blue."),
                Exercise("GREEN", "green", "ما معنى هذه الكلمة؟", listOf("أسود", "أبيض", "أخضر"), "أخضر", "I like green."),
                Exercise("BLACK", "black", "ما معنى هذه الكلمة؟", listOf("مقاس", "أسود", "أبيض"), "أسود", "I like black."),
                Exercise("WHITE", "white", "ما معنى هذه الكلمة؟", listOf("أبيض", "مقاس", "صغير"), "أبيض", "I like white.")
            )),
            CourseLesson(44, "في المتجر", listOf(
                Exercise("SIZE", "size", "ما معنى هذه الكلمة؟", listOf("مقاس", "صغير", "متوسط"), "مقاس", "I like size."),
                Exercise("SMALL", "small", "ما معنى هذه الكلمة؟", listOf("متوسط", "كبير", "صغير"), "صغير", "I like small."),
                Exercise("MEDIUM", "medium", "ما معنى هذه الكلمة؟", listOf("سعر", "متوسط", "كبير"), "متوسط", "I like medium."),
                Exercise("LARGE", "large", "ما معنى هذه الكلمة؟", listOf("كبير", "سعر", "مال"), "كبير", "I like large."),
                Exercise("PRICE", "price", "ما معنى هذه الكلمة؟", listOf("مال", "نقداً", "سعر"), "سعر", "I like price.")
            )),
            CourseLesson(45, "مراجعة التسوق", listOf(
                Exercise("MONEY", "money", "ما معنى هذه الكلمة؟", listOf("نقداً", "رخيص", "مال"), "مال", "I like money."),
                Exercise("CASH", "cash", "ما معنى هذه الكلمة؟", listOf("غالي", "نقداً", "رخيص"), "نقداً", "I like cash."),
                Exercise("CHEAP", "cheap", "ما معنى هذه الكلمة؟", listOf("رخيص", "غالي", "متجر"), "رخيص", "I like cheap."),
                Exercise("EXPENSIVE", "expensive", "ما معنى هذه الكلمة؟", listOf("متجر", "قميص", "غالي"), "غالي", "I like expensive."),
                Exercise("SHOP", "shop", "ما معنى هذه الكلمة؟", listOf("سروال", "متجر", "قميص"), "متجر", "I like shop.")
            ))
        )),
        CourseUnit(10, "الطقس والطبيعة", listOf(
            CourseLesson(46, "حالة الطقس", listOf(
                Exercise("SUN", "sun", "ما معنى هذه الكلمة؟", listOf("شمس", "مطر", "رياح"), "شمس", "I like sun."),
                Exercise("RAIN", "rain", "ما معنى هذه الكلمة؟", listOf("رياح", "سحابة", "مطر"), "مطر", "I like rain."),
                Exercise("WIND", "wind", "ما معنى هذه الكلمة؟", listOf("ثلج", "رياح", "سحابة"), "رياح", "I like wind."),
                Exercise("CLOUD", "cloud", "ما معنى هذه الكلمة؟", listOf("سحابة", "ثلج", "حار"), "سحابة", "I like cloud."),
                Exercise("SNOW", "snow", "ما معنى هذه الكلمة؟", listOf("حار", "بارد", "ثلج"), "ثلج", "I like snow.")
            )),
            CourseLesson(47, "الفصول", listOf(
                Exercise("HOT", "hot", "ما معنى هذه الكلمة؟", listOf("بارد", "دافئ", "حار"), "حار", "I like hot."),
                Exercise("COLD", "cold", "ما معنى هذه الكلمة؟", listOf("معتدل البرودة", "بارد", "دافئ"), "بارد", "I like cold."),
                Exercise("WARM", "warm", "ما معنى هذه الكلمة؟", listOf("دافئ", "معتدل البرودة", "طقس"), "دافئ", "I like warm."),
                Exercise("COOL", "cool", "ما معنى هذه الكلمة؟", listOf("طقس", "الربيع", "معتدل البرودة"), "معتدل البرودة", "I like cool."),
                Exercise("WEATHER", "weather", "ما معنى هذه الكلمة؟", listOf("الصيف", "طقس", "الربيع"), "طقس", "I like weather.")
            )),
            CourseLesson(48, "الطبيعة", listOf(
                Exercise("SPRING", "spring", "ما معنى هذه الكلمة؟", listOf("الخريف", "الربيع", "الصيف"), "الربيع", "I like spring."),
                Exercise("SUMMER", "summer", "ما معنى هذه الكلمة؟", listOf("الصيف", "الخريف", "الشتاء"), "الصيف", "I like summer."),
                Exercise("AUTUMN", "autumn", "ما معنى هذه الكلمة؟", listOf("الشتاء", "فصل", "الخريف"), "الخريف", "I like autumn."),
                Exercise("WINTER", "winter", "ما معنى هذه الكلمة؟", listOf("شجرة", "الشتاء", "فصل"), "الشتاء", "I like winter."),
                Exercise("SEASON", "season", "ما معنى هذه الكلمة؟", listOf("فصل", "شجرة", "زهرة"), "فصل", "I like season.")
            )),
            CourseLesson(49, "وصف الجو", listOf(
                Exercise("TREE", "tree", "ما معنى هذه الكلمة؟", listOf("شجرة", "زهرة", "نهر"), "شجرة", "I like tree."),
                Exercise("FLOWER", "flower", "ما معنى هذه الكلمة؟", listOf("نهر", "جبل", "زهرة"), "زهرة", "I like flower."),
                Exercise("RIVER", "river", "ما معنى هذه الكلمة؟", listOf("بحر", "نهر", "جبل"), "نهر", "I like river."),
                Exercise("MOUNTAIN", "mountain", "ما معنى هذه الكلمة؟", listOf("جبل", "بحر", "سماء"), "جبل", "I like mountain."),
                Exercise("SEA", "sea", "ما معنى هذه الكلمة؟", listOf("سماء", "عشب", "بحر"), "بحر", "I like sea.")
            )),
            CourseLesson(50, "مراجعة الطقس والطبيعة", listOf(
                Exercise("SKY", "sky", "ما معنى هذه الكلمة؟", listOf("عشب", "حيوان", "سماء"), "سماء", "I like sky."),
                Exercise("GRASS", "grass", "ما معنى هذه الكلمة؟", listOf("جميل", "عشب", "حيوان"), "عشب", "I like grass."),
                Exercise("ANIMAL", "animal", "ما معنى هذه الكلمة؟", listOf("حيوان", "جميل", "غائم"), "حيوان", "I like animal."),
                Exercise("BEAUTIFUL", "beautiful", "ما معنى هذه الكلمة؟", listOf("غائم", "شمس", "جميل"), "جميل", "I like beautiful."),
                Exercise("CLOUDY", "cloudy", "ما معنى هذه الكلمة؟", listOf("مطر", "غائم", "شمس"), "غائم", "I like cloudy.")
            ))
        )),
        CourseUnit(11, "الصحة والجسم", listOf(
            CourseLesson(51, "أجزاء الجسم", listOf(
                Exercise("HEAD", "head", "ما معنى هذه الكلمة؟", listOf("رأس", "عين", "أذن"), "رأس", "I like head."),
                Exercise("EYE", "eye", "ما معنى هذه الكلمة؟", listOf("أذن", "أنف", "عين"), "عين", "I like eye."),
                Exercise("EAR", "ear", "ما معنى هذه الكلمة؟", listOf("فم", "أذن", "أنف"), "أذن", "I like ear."),
                Exercise("NOSE", "nose", "ما معنى هذه الكلمة؟", listOf("أنف", "فم", "يد"), "أنف", "I like nose."),
                Exercise("MOUTH", "mouth", "ما معنى هذه الكلمة؟", listOf("يد", "ذراع", "فم"), "فم", "I like mouth.")
            )),
            CourseLesson(52, "المشاعر والأعراض", listOf(
                Exercise("HAND", "hand", "ما معنى هذه الكلمة؟", listOf("ذراع", "ساق", "يد"), "يد", "I like hand."),
                Exercise("ARM", "arm", "ما معنى هذه الكلمة؟", listOf("قدم", "ذراع", "ساق"), "ذراع", "I like arm."),
                Exercise("LEG", "leg", "ما معنى هذه الكلمة؟", listOf("ساق", "قدم", "جسم"), "ساق", "I like leg."),
                Exercise("FOOT", "foot", "ما معنى هذه الكلمة؟", listOf("جسم", "مريض", "قدم"), "قدم", "I like foot."),
                Exercise("BODY", "body", "ما معنى هذه الكلمة؟", listOf("مريض", "جسم", "مريض"), "جسم", "I like body.")
            )),
            CourseLesson(53, "زيارة الطبيب", listOf(
                Exercise("ILL", "ill", "ما معنى هذه الكلمة؟", listOf("ألم", "مريض", "مريض"), "مريض", "I like ill."),
                Exercise("SICK", "sick", "ما معنى هذه الكلمة؟", listOf("مريض", "ألم", "صداع"), "مريض", "I like sick."),
                Exercise("PAIN", "pain", "ما معنى هذه الكلمة؟", listOf("صداع", "حمى", "ألم"), "ألم", "I like pain."),
                Exercise("HEADACHE", "headache", "ما معنى هذه الكلمة؟", listOf("طبيب", "صداع", "حمى"), "صداع", "I like headache."),
                Exercise("FEVER", "fever", "ما معنى هذه الكلمة؟", listOf("حمى", "طبيب", "دواء"), "حمى", "I like fever.")
            )),
            CourseLesson(54, "العادات الصحية", listOf(
                Exercise("DOCTOR", "doctor", "ما معنى هذه الكلمة؟", listOf("طبيب", "دواء", "موعد"), "طبيب", "I like doctor."),
                Exercise("MEDICINE", "medicine", "ما معنى هذه الكلمة؟", listOf("موعد", "مساعدة", "دواء"), "دواء", "I like medicine."),
                Exercise("APPOINTMENT", "appointment", "ما معنى هذه الكلمة؟", listOf("راحة", "موعد", "مساعدة"), "موعد", "I like appointment."),
                Exercise("HELP", "help", "ما معنى هذه الكلمة؟", listOf("مساعدة", "راحة", "صحي"), "مساعدة", "I like help."),
                Exercise("REST", "rest", "ما معنى هذه الكلمة؟", listOf("صحي", "تمرين", "راحة"), "راحة", "I like rest.")
            )),
            CourseLesson(55, "مراجعة الصحة", listOf(
                Exercise("HEALTHY", "healthy", "ما معنى هذه الكلمة؟", listOf("تمرين", "طعام", "صحي"), "صحي", "I like healthy."),
                Exercise("EXERCISE", "exercise", "ما معنى هذه الكلمة؟", listOf("نوم", "تمرين", "طعام"), "تمرين", "I like exercise."),
                Exercise("FOOD", "food", "ما معنى هذه الكلمة؟", listOf("طعام", "نوم", "قوي"), "طعام", "I like food."),
                Exercise("SLEEP", "sleep", "ما معنى هذه الكلمة؟", listOf("قوي", "رأس", "نوم"), "نوم", "I like sleep."),
                Exercise("STRONG", "strong", "ما معنى هذه الكلمة؟", listOf("عين", "قوي", "رأس"), "قوي", "I like strong.")
            ))
        )),
        CourseUnit(12, "الهوايات والسفر", listOf(
            CourseLesson(56, "الهوايات", listOf(
                Exercise("HOBBY", "hobby", "ما معنى هذه الكلمة؟", listOf("هواية", "القراءة", "الرسم"), "هواية", "I like hobby."),
                Exercise("READING", "reading", "ما معنى هذه الكلمة؟", listOf("الرسم", "الطبخ", "القراءة"), "القراءة", "I like reading."),
                Exercise("DRAWING", "drawing", "ما معنى هذه الكلمة؟", listOf("البستنة", "الرسم", "الطبخ"), "الرسم", "I like drawing."),
                Exercise("COOKING", "cooking", "ما معنى هذه الكلمة؟", listOf("الطبخ", "البستنة", "كرة القدم"), "الطبخ", "I like cooking."),
                Exercise("GARDENING", "gardening", "ما معنى هذه الكلمة؟", listOf("كرة القدم", "السباحة", "البستنة"), "البستنة", "I like gardening.")
            )),
            CourseLesson(57, "الرياضة", listOf(
                Exercise("FOOTBALL", "football", "ما معنى هذه الكلمة؟", listOf("السباحة", "الجري", "كرة القدم"), "كرة القدم", "I like football."),
                Exercise("SWIMMING", "swimming", "ما معنى هذه الكلمة؟", listOf("التنس", "السباحة", "الجري"), "السباحة", "I like swimming."),
                Exercise("RUNNING", "running", "ما معنى هذه الكلمة؟", listOf("الجري", "التنس", "لعبة"), "الجري", "I like running."),
                Exercise("TENNIS", "tennis", "ما معنى هذه الكلمة؟", listOf("لعبة", "عطلة", "التنس"), "التنس", "I like tennis."),
                Exercise("GAME", "game", "ما معنى هذه الكلمة؟", listOf("رحلة", "لعبة", "عطلة"), "لعبة", "I like game.")
            )),
            CourseLesson(58, "العطلات والسفر", listOf(
                Exercise("HOLIDAY", "holiday", "ما معنى هذه الكلمة؟", listOf("يزور", "عطلة", "رحلة"), "عطلة", "I like holiday."),
                Exercise("TRIP", "trip", "ما معنى هذه الكلمة؟", listOf("رحلة", "يزور", "كاميرا"), "رحلة", "I like trip."),
                Exercise("VISIT", "visit", "ما معنى هذه الكلمة؟", listOf("كاميرا", "صورة", "يزور"), "يزور", "I like visit."),
                Exercise("CAMERA", "camera", "ما معنى هذه الكلمة؟", listOf("فندق", "كاميرا", "صورة"), "كاميرا", "I like camera."),
                Exercise("PHOTO", "photo", "ما معنى هذه الكلمة؟", listOf("صورة", "فندق", "مطار"), "صورة", "I like photo.")
            )),
            CourseLesson(59, "الفندق والمطار", listOf(
                Exercise("HOTEL", "hotel", "ما معنى هذه الكلمة؟", listOf("فندق", "مطار", "جواز سفر"), "فندق", "I like hotel."),
                Exercise("AIRPORT", "airport", "ما معنى هذه الكلمة؟", listOf("جواز سفر", "أمتعة", "مطار"), "مطار", "I like airport."),
                Exercise("PASSPORT", "passport", "ما معنى هذه الكلمة؟", listOf("حجز", "جواز سفر", "أمتعة"), "جواز سفر", "I like passport."),
                Exercise("LUGGAGE", "luggage", "ما معنى هذه الكلمة؟", listOf("أمتعة", "حجز", "شاطئ"), "أمتعة", "I like luggage."),
                Exercise("RESERVATION", "reservation", "ما معنى هذه الكلمة؟", listOf("شاطئ", "متحف", "حجز"), "حجز", "I like reservation.")
            )),
            CourseLesson(60, "مراجعة عامة", listOf(
                Exercise("BEACH", "beach", "ما معنى هذه الكلمة؟", listOf("متحف", "جميل", "شاطئ"), "شاطئ", "I like beach."),
                Exercise("MUSEUM", "museum", "ما معنى هذه الكلمة؟", listOf("يستمتع", "متحف", "جميل"), "متحف", "I like museum."),
                Exercise("BEAUTIFUL", "beautiful", "ما معنى هذه الكلمة؟", listOf("جميل", "يستمتع", "مفضل"), "جميل", "I like beautiful."),
                Exercise("ENJOY", "enjoy", "ما معنى هذه الكلمة؟", listOf("مفضل", "هواية", "يستمتع"), "يستمتع", "I like enjoy."),
                Exercise("FAVORITE", "favorite", "ما معنى هذه الكلمة؟", listOf("القراءة", "مفضل", "هواية"), "مفضل", "I like favorite.")
            ))
        ))
    )
}
