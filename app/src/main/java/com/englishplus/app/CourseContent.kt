package com.englishplus.app

data class CourseUnit(val number: Int, val title: String, val lessons: List<CourseLesson>)
data class CourseLesson(val number: Int, val title: String, val exercises: List<Exercise>)

object CourseContent {
    val units: List<CourseUnit> = listOf(
        CourseUnit(1, "التعارف والتحيات", listOf(
            CourseLesson(1, "التحية والتوديع", listOf(
                Exercise("HELLO", "hello", "ما معنى هذه الكلمة؟", listOf("مرحباً", "إلى اللقاء", "من فضلك"), "مرحباً", I can say "hello".),
                Exercise("GOODBYE", "goodbye", "ما معنى هذه الكلمة؟", listOf("من فضلك", "شكراً", "إلى اللقاء"), "إلى اللقاء", I can say "goodbye".),
                Exercise("PLEASE", "please", "ما معنى هذه الكلمة؟", listOf("أهلاً بك", "من فضلك", "شكراً"), "من فضلك", I can say "please".),
                Exercise("THANKS", "thanks", "ما معنى هذه الكلمة؟", listOf("شكراً", "أهلاً بك", "اسم"), "شكراً", I can say "thanks".),
                Exercise("WELCOME", "welcome", "ما معنى هذه الكلمة؟", listOf("اسم", "الاسم الشخصي", "أهلاً بك"), "أهلاً بك", I can say "welcome".)
            )),
            CourseLesson(2, "التعريف بالنفس", listOf(
                Exercise("NAME", "name", "ما معنى هذه الكلمة؟", listOf("الاسم الشخصي", "اسم العائلة", "اسم"), "اسم", I can say "name".),
                Exercise("FIRST NAME", "first name", "ما معنى هذه الكلمة؟", listOf("العمر", "الاسم الشخصي", "اسم العائلة"), "الاسم الشخصي", I can say "first name".),
                Exercise("LAST NAME", "last name", "ما معنى هذه الكلمة؟", listOf("اسم العائلة", "العمر", "العنوان"), "اسم العائلة", I can say "last name".),
                Exercise("AGE", "age", "ما معنى هذه الكلمة؟", listOf("العنوان", "بلد", "العمر"), "العمر", I can say "age".),
                Exercise("ADDRESS", "address", "ما معنى هذه الكلمة؟", listOf("مدينة", "العنوان", "بلد"), "العنوان", I can say "address".)
            )),
            CourseLesson(3, "البلدان واللغات", listOf(
                Exercise("COUNTRY", "country", "ما معنى هذه الكلمة؟", listOf("لغة", "بلد", "مدينة"), "بلد", I can say "country".),
                Exercise("CITY", "city", "ما معنى هذه الكلمة؟", listOf("مدينة", "لغة", "الجنسية"), "مدينة", I can say "city".),
                Exercise("LANGUAGE", "language", "ما معنى هذه الكلمة؟", listOf("الجنسية", "المغرب", "لغة"), "لغة", I can say "language".),
                Exercise("NATIONALITY", "nationality", "ما معنى هذه الكلمة؟", listOf("بخير", "الجنسية", "المغرب"), "الجنسية", I can say "nationality".),
                Exercise("MOROCCO", "morocco", "ما معنى هذه الكلمة؟", listOf("المغرب", "بخير", "سعيد"), "المغرب", I can say "morocco".)
            )),
            CourseLesson(4, "السؤال عن الحال", listOf(
                Exercise("FINE", "fine", "ما معنى هذه الكلمة؟", listOf("بخير", "سعيد", "متعب"), "بخير", I can say "fine".),
                Exercise("HAPPY", "happy", "ما معنى هذه الكلمة؟", listOf("متعب", "آسف", "سعيد"), "سعيد", I can say "happy".),
                Exercise("TIRED", "tired", "ما معنى هذه الكلمة؟", listOf("عذراً", "متعب", "آسف"), "متعب", I can say "tired".),
                Exercise("SORRY", "sorry", "ما معنى هذه الكلمة؟", listOf("آسف", "عذراً", "يلتقي"), "آسف", I can say "sorry".),
                Exercise("EXCUSE ME", "excuse me", "ما معنى هذه الكلمة؟", listOf("يلتقي", "يعرّف", "عذراً"), "عذراً", I can say "excuse me".)
            )),
            CourseLesson(5, "مراجعة التعارف", listOf(
                Exercise("MEET", "meet", "ما معنى هذه الكلمة؟", listOf("يعرّف", "يتحدث", "يلتقي"), "يلتقي", I can say "meet".),
                Exercise("INTRODUCE", "introduce", "ما معنى هذه الكلمة؟", listOf("يعيش", "يعرّف", "يتحدث"), "يعرّف", I can say "introduce".),
                Exercise("SPEAK", "speak", "ما معنى هذه الكلمة؟", listOf("يتحدث", "يعيش", "من"), "يتحدث", I can say "speak".),
                Exercise("LIVE", "live", "ما معنى هذه الكلمة؟", listOf("من", "مرحباً", "يعيش"), "يعيش", I can say "live".),
                Exercise("FROM", "from", "ما معنى هذه الكلمة؟", listOf("إلى اللقاء", "من", "مرحباً"), "من", I can say "from".)
            ))
        )),
        CourseUnit(2, "الأرقام والعائلة", listOf(
            CourseLesson(6, "الأرقام الأساسية", listOf(
                Exercise("ONE", "one", "ما معنى هذه الكلمة؟", listOf("واحد", "اثنان", "ثلاثة"), "واحد", I can say "one".),
                Exercise("TWO", "two", "ما معنى هذه الكلمة؟", listOf("ثلاثة", "أربعة", "اثنان"), "اثنان", I can say "two".),
                Exercise("THREE", "three", "ما معنى هذه الكلمة؟", listOf("خمسة", "ثلاثة", "أربعة"), "ثلاثة", I can say "three".),
                Exercise("FOUR", "four", "ما معنى هذه الكلمة؟", listOf("أربعة", "خمسة", "ستة"), "أربعة", I can say "four".),
                Exercise("FIVE", "five", "ما معنى هذه الكلمة؟", listOf("ستة", "سبعة", "خمسة"), "خمسة", I can say "five".)
            )),
            CourseLesson(7, "أفراد العائلة", listOf(
                Exercise("SIX", "six", "ما معنى هذه الكلمة؟", listOf("سبعة", "ثمانية", "ستة"), "ستة", I can say "six".),
                Exercise("SEVEN", "seven", "ما معنى هذه الكلمة؟", listOf("تسعة", "سبعة", "ثمانية"), "سبعة", I can say "seven".),
                Exercise("EIGHT", "eight", "ما معنى هذه الكلمة؟", listOf("ثمانية", "تسعة", "عشرة"), "ثمانية", I can say "eight".),
                Exercise("NINE", "nine", "ما معنى هذه الكلمة؟", listOf("عشرة", "أم", "تسعة"), "تسعة", I can say "nine".),
                Exercise("TEN", "ten", "ما معنى هذه الكلمة؟", listOf("أب", "عشرة", "أم"), "عشرة", I can say "ten".)
            )),
            CourseLesson(8, "العمر والعدد", listOf(
                Exercise("MOTHER", "mother", "ما معنى هذه الكلمة؟", listOf("أخ", "أم", "أب"), "أم", I can say "mother".),
                Exercise("FATHER", "father", "ما معنى هذه الكلمة؟", listOf("أب", "أخ", "أخت"), "أب", I can say "father".),
                Exercise("BROTHER", "brother", "ما معنى هذه الكلمة؟", listOf("أخت", "الوالدان", "أخ"), "أخ", I can say "brother".),
                Exercise("SISTER", "sister", "ما معنى هذه الكلمة؟", listOf("ابن", "أخت", "الوالدان"), "أخت", I can say "sister".),
                Exercise("PARENTS", "parents", "ما معنى هذه الكلمة؟", listOf("الوالدان", "ابن", "ابنة"), "الوالدان", I can say "parents".)
            )),
            CourseLesson(9, "وصف العائلة", listOf(
                Exercise("SON", "son", "ما معنى هذه الكلمة؟", listOf("ابن", "ابنة", "جدة"), "ابن", I can say "son".),
                Exercise("DAUGHTER", "daughter", "ما معنى هذه الكلمة؟", listOf("جدة", "جد", "ابنة"), "ابنة", I can say "daughter".),
                Exercise("GRANDMOTHER", "grandmother", "ما معنى هذه الكلمة؟", listOf("عائلة", "جدة", "جد"), "جدة", I can say "grandmother".),
                Exercise("GRANDFATHER", "grandfather", "ما معنى هذه الكلمة؟", listOf("جد", "عائلة", "طفل"), "جد", I can say "grandfather".),
                Exercise("FAMILY", "family", "ما معنى هذه الكلمة؟", listOf("طفل", "أطفال", "عائلة"), "عائلة", I can say "family".)
            )),
            CourseLesson(10, "مراجعة العائلة والأرقام", listOf(
                Exercise("CHILD", "child", "ما معنى هذه الكلمة؟", listOf("أطفال", "صغير السن", "طفل"), "طفل", I can say "child".),
                Exercise("CHILDREN", "children", "ما معنى هذه الكلمة؟", listOf("كبير السن", "أطفال", "صغير السن"), "أطفال", I can say "children".),
                Exercise("YOUNG", "young", "ما معنى هذه الكلمة؟", listOf("صغير السن", "كبير السن", "ابن العم أو الخال"), "صغير السن", I can say "young".),
                Exercise("OLD", "old", "ما معنى هذه الكلمة؟", listOf("ابن العم أو الخال", "واحد", "كبير السن"), "كبير السن", I can say "old".),
                Exercise("COUSIN", "cousin", "ما معنى هذه الكلمة؟", listOf("اثنان", "ابن العم أو الخال", "واحد"), "ابن العم أو الخال", I can say "cousin".)
            ))
        )),
        CourseUnit(3, "المنزل والأشياء", listOf(
            CourseLesson(11, "غرف المنزل", listOf(
                Exercise("HOUSE", "house", "ما معنى هذه الكلمة؟", listOf("منزل", "شقة", "غرفة"), "منزل", I can say "house".),
                Exercise("APARTMENT", "apartment", "ما معنى هذه الكلمة؟", listOf("غرفة", "مطبخ", "شقة"), "شقة", I can say "apartment".),
                Exercise("ROOM", "room", "ما معنى هذه الكلمة؟", listOf("غرفة نوم", "غرفة", "مطبخ"), "غرفة", I can say "room".),
                Exercise("KITCHEN", "kitchen", "ما معنى هذه الكلمة؟", listOf("مطبخ", "غرفة نوم", "حمام"), "مطبخ", I can say "kitchen".),
                Exercise("BEDROOM", "bedroom", "ما معنى هذه الكلمة؟", listOf("حمام", "غرفة الجلوس", "غرفة نوم"), "غرفة نوم", I can say "bedroom".)
            )),
            CourseLesson(12, "الأثاث", listOf(
                Exercise("BATHROOM", "bathroom", "ما معنى هذه الكلمة؟", listOf("غرفة الجلوس", "باب", "حمام"), "حمام", I can say "bathroom".),
                Exercise("LIVING ROOM", "living room", "ما معنى هذه الكلمة؟", listOf("نافذة", "غرفة الجلوس", "باب"), "غرفة الجلوس", I can say "living room".),
                Exercise("DOOR", "door", "ما معنى هذه الكلمة؟", listOf("باب", "نافذة", "حديقة"), "باب", I can say "door".),
                Exercise("WINDOW", "window", "ما معنى هذه الكلمة؟", listOf("حديقة", "طاولة", "نافذة"), "نافذة", I can say "window".),
                Exercise("GARDEN", "garden", "ما معنى هذه الكلمة؟", listOf("كرسي", "حديقة", "طاولة"), "حديقة", I can say "garden".)
            )),
            CourseLesson(13, "أشياء يومية", listOf(
                Exercise("TABLE", "table", "ما معنى هذه الكلمة؟", listOf("سرير", "طاولة", "كرسي"), "طاولة", I can say "table".),
                Exercise("CHAIR", "chair", "ما معنى هذه الكلمة؟", listOf("كرسي", "سرير", "أريكة"), "كرسي", I can say "chair".),
                Exercise("BED", "bed", "ما معنى هذه الكلمة؟", listOf("أريكة", "مكتب", "سرير"), "سرير", I can say "bed".),
                Exercise("SOFA", "sofa", "ما معنى هذه الكلمة؟", listOf("مفتاح", "أريكة", "مكتب"), "أريكة", I can say "sofa".),
                Exercise("DESK", "desk", "ما معنى هذه الكلمة؟", listOf("مكتب", "مفتاح", "هاتف"), "مكتب", I can say "desk".)
            )),
            CourseLesson(14, "وصف المنزل", listOf(
                Exercise("KEY", "key", "ما معنى هذه الكلمة؟", listOf("مفتاح", "هاتف", "كتاب"), "مفتاح", I can say "key".),
                Exercise("PHONE", "phone", "ما معنى هذه الكلمة؟", listOf("كتاب", "قلم", "هاتف"), "هاتف", I can say "phone".),
                Exercise("BOOK", "book", "ما معنى هذه الكلمة؟", listOf("حقيبة", "كتاب", "قلم"), "كتاب", I can say "book".),
                Exercise("PEN", "pen", "ما معنى هذه الكلمة؟", listOf("قلم", "حقيبة", "نظيف"), "قلم", I can say "pen".),
                Exercise("BAG", "bag", "ما معنى هذه الكلمة؟", listOf("نظيف", "كبير", "حقيبة"), "حقيبة", I can say "bag".)
            )),
            CourseLesson(15, "مراجعة المنزل", listOf(
                Exercise("CLEAN", "clean", "ما معنى هذه الكلمة؟", listOf("كبير", "صغير", "نظيف"), "نظيف", I can say "clean".),
                Exercise("BIG", "big", "ما معنى هذه الكلمة؟", listOf("مفتوح", "كبير", "صغير"), "كبير", I can say "big".),
                Exercise("SMALL", "small", "ما معنى هذه الكلمة؟", listOf("صغير", "مفتوح", "مغلق"), "صغير", I can say "small".),
                Exercise("OPEN", "open", "ما معنى هذه الكلمة؟", listOf("مغلق", "منزل", "مفتوح"), "مفتوح", I can say "open".),
                Exercise("CLOSED", "closed", "ما معنى هذه الكلمة؟", listOf("شقة", "مغلق", "منزل"), "مغلق", I can say "closed".)
            ))
        )),
        CourseUnit(4, "الطعام والشراب", listOf(
            CourseLesson(16, "الفواكه والخضروات", listOf(
                Exercise("APPLE", "apple", "ما معنى هذه الكلمة؟", listOf("تفاحة", "موزة", "برتقالة"), "تفاحة", I can say "apple".),
                Exercise("BANANA", "banana", "ما معنى هذه الكلمة؟", listOf("برتقالة", "عنب", "موزة"), "موزة", I can say "banana".),
                Exercise("ORANGE", "orange", "ما معنى هذه الكلمة؟", listOf("ليمون", "برتقالة", "عنب"), "برتقالة", I can say "orange".),
                Exercise("GRAPES", "grapes", "ما معنى هذه الكلمة؟", listOf("عنب", "ليمون", "طماطم"), "عنب", I can say "grapes".),
                Exercise("LEMON", "lemon", "ما معنى هذه الكلمة؟", listOf("طماطم", "بطاطس", "ليمون"), "ليمون", I can say "lemon".)
            )),
            CourseLesson(17, "الوجبات", listOf(
                Exercise("TOMATO", "tomato", "ما معنى هذه الكلمة؟", listOf("بطاطس", "جزر", "طماطم"), "طماطم", I can say "tomato".),
                Exercise("POTATO", "potato", "ما معنى هذه الكلمة؟", listOf("بصل", "بطاطس", "جزر"), "بطاطس", I can say "potato".),
                Exercise("CARROT", "carrot", "ما معنى هذه الكلمة؟", listOf("جزر", "بصل", "سلطة"), "جزر", I can say "carrot".),
                Exercise("ONION", "onion", "ما معنى هذه الكلمة؟", listOf("سلطة", "خبز", "بصل"), "بصل", I can say "onion".),
                Exercise("SALAD", "salad", "ما معنى هذه الكلمة؟", listOf("أرز", "سلطة", "خبز"), "سلطة", I can say "salad".)
            )),
            CourseLesson(18, "المشروبات", listOf(
                Exercise("BREAD", "bread", "ما معنى هذه الكلمة؟", listOf("بيضة", "خبز", "أرز"), "خبز", I can say "bread".),
                Exercise("RICE", "rice", "ما معنى هذه الكلمة؟", listOf("أرز", "بيضة", "جبن"), "أرز", I can say "rice".),
                Exercise("EGG", "egg", "ما معنى هذه الكلمة؟", listOf("جبن", "دجاج", "بيضة"), "بيضة", I can say "egg".),
                Exercise("CHEESE", "cheese", "ما معنى هذه الكلمة؟", listOf("فطور", "جبن", "دجاج"), "جبن", I can say "cheese".),
                Exercise("CHICKEN", "chicken", "ما معنى هذه الكلمة؟", listOf("دجاج", "فطور", "غداء"), "دجاج", I can say "chicken".)
            )),
            CourseLesson(19, "في المطعم", listOf(
                Exercise("BREAKFAST", "breakfast", "ما معنى هذه الكلمة؟", listOf("فطور", "غداء", "عشاء"), "فطور", I can say "breakfast".),
                Exercise("LUNCH", "lunch", "ما معنى هذه الكلمة؟", listOf("عشاء", "وجبة", "غداء"), "غداء", I can say "lunch".),
                Exercise("DINNER", "dinner", "ما معنى هذه الكلمة؟", listOf("قائمة الطعام", "عشاء", "وجبة"), "عشاء", I can say "dinner".),
                Exercise("MEAL", "meal", "ما معنى هذه الكلمة؟", listOf("وجبة", "قائمة الطعام", "ماء"), "وجبة", I can say "meal".),
                Exercise("MENU", "menu", "ما معنى هذه الكلمة؟", listOf("ماء", "حليب", "قائمة الطعام"), "قائمة الطعام", I can say "menu".)
            )),
            CourseLesson(20, "مراجعة الطعام", listOf(
                Exercise("WATER", "water", "ما معنى هذه الكلمة؟", listOf("حليب", "شاي", "ماء"), "ماء", I can say "water".),
                Exercise("MILK", "milk", "ما معنى هذه الكلمة؟", listOf("عصير", "حليب", "شاي"), "حليب", I can say "milk".),
                Exercise("TEA", "tea", "ما معنى هذه الكلمة؟", listOf("شاي", "عصير", "جائع"), "شاي", I can say "tea".),
                Exercise("JUICE", "juice", "ما معنى هذه الكلمة؟", listOf("جائع", "تفاحة", "عصير"), "عصير", I can say "juice".),
                Exercise("HUNGRY", "hungry", "ما معنى هذه الكلمة؟", listOf("موزة", "جائع", "تفاحة"), "جائع", I can say "hungry".)
            ))
        )),
        CourseUnit(5, "الحياة اليومية", listOf(
            CourseLesson(21, "أفعال يومية", listOf(
                Exercise("WAKE UP", "wake up", "ما معنى هذه الكلمة؟", listOf("يستيقظ", "ينهض", "يغسل"), "يستيقظ", I can say "wake up".),
                Exercise("GET UP", "get up", "ما معنى هذه الكلمة؟", listOf("يغسل", "استحمام", "ينهض"), "ينهض", I can say "get up".),
                Exercise("WASH", "wash", "ما معنى هذه الكلمة؟", listOf("يرتدي", "يغسل", "استحمام"), "يغسل", I can say "wash".),
                Exercise("SHOWER", "shower", "ما معنى هذه الكلمة؟", listOf("استحمام", "يرتدي", "يأكل"), "استحمام", I can say "shower".),
                Exercise("DRESS", "dress", "ما معنى هذه الكلمة؟", listOf("يأكل", "يشرب", "يرتدي"), "يرتدي", I can say "dress".)
            )),
            CourseLesson(22, "الاستيقاظ والنوم", listOf(
                Exercise("EAT", "eat", "ما معنى هذه الكلمة؟", listOf("يشرب", "يذهب", "يأكل"), "يأكل", I can say "eat".),
                Exercise("DRINK", "drink", "ما معنى هذه الكلمة؟", listOf("يأتي", "يشرب", "يذهب"), "يشرب", I can say "drink".),
                Exercise("GO", "go", "ما معنى هذه الكلمة؟", listOf("يذهب", "يأتي", "يعود"), "يذهب", I can say "go".),
                Exercise("COME", "come", "ما معنى هذه الكلمة؟", listOf("يعود", "يعمل", "يأتي"), "يأتي", I can say "come".),
                Exercise("RETURN", "return", "ما معنى هذه الكلمة؟", listOf("يدرس", "يعود", "يعمل"), "يعود", I can say "return".)
            )),
            CourseLesson(23, "العمل والدراسة", listOf(
                Exercise("WORK", "work", "ما معنى هذه الكلمة؟", listOf("يقرأ", "يعمل", "يدرس"), "يعمل", I can say "work".),
                Exercise("STUDY", "study", "ما معنى هذه الكلمة؟", listOf("يدرس", "يقرأ", "يكتب"), "يدرس", I can say "study".),
                Exercise("READ", "read", "ما معنى هذه الكلمة؟", listOf("يكتب", "يستمع", "يقرأ"), "يقرأ", I can say "read".),
                Exercise("WRITE", "write", "ما معنى هذه الكلمة؟", listOf("يشاهد", "يكتب", "يستمع"), "يكتب", I can say "write".),
                Exercise("LISTEN", "listen", "ما معنى هذه الكلمة؟", listOf("يستمع", "يشاهد", "ينام"), "يستمع", I can say "listen".)
            )),
            CourseLesson(24, "أوقات الفراغ", listOf(
                Exercise("WATCH", "watch", "ما معنى هذه الكلمة؟", listOf("يشاهد", "ينام", "يطبخ"), "يشاهد", I can say "watch".),
                Exercise("SLEEP", "sleep", "ما معنى هذه الكلمة؟", listOf("يطبخ", "ينظف", "ينام"), "ينام", I can say "sleep".),
                Exercise("COOK", "cook", "ما معنى هذه الكلمة؟", listOf("يمشي", "يطبخ", "ينظف"), "يطبخ", I can say "cook".),
                Exercise("CLEAN", "clean", "ما معنى هذه الكلمة؟", listOf("ينظف", "يمشي", "عادةً"), "ينظف", I can say "clean".),
                Exercise("WALK", "walk", "ما معنى هذه الكلمة؟", listOf("عادةً", "دائماً", "يمشي"), "يمشي", I can say "walk".)
            )),
            CourseLesson(25, "مراجعة الروتين", listOf(
                Exercise("USUALLY", "usually", "ما معنى هذه الكلمة؟", listOf("دائماً", "أحياناً", "عادةً"), "عادةً", I can say "usually".),
                Exercise("ALWAYS", "always", "ما معنى هذه الكلمة؟", listOf("أبداً", "دائماً", "أحياناً"), "دائماً", I can say "always".),
                Exercise("SOMETIMES", "sometimes", "ما معنى هذه الكلمة؟", listOf("أحياناً", "أبداً", "كل يوم"), "أحياناً", I can say "sometimes".),
                Exercise("NEVER", "never", "ما معنى هذه الكلمة؟", listOf("كل يوم", "يستيقظ", "أبداً"), "أبداً", I can say "never".),
                Exercise("EVERY DAY", "every day", "ما معنى هذه الكلمة؟", listOf("ينهض", "كل يوم", "يستيقظ"), "كل يوم", I can say "every day".)
            ))
        )),
        CourseUnit(6, "الوقت والتقويم", listOf(
            CourseLesson(26, "أيام الأسبوع", listOf(
                Exercise("MONDAY", "monday", "ما معنى هذه الكلمة؟", listOf("الاثنين", "الثلاثاء", "الأربعاء"), "الاثنين", I can say "monday".),
                Exercise("TUESDAY", "tuesday", "ما معنى هذه الكلمة؟", listOf("الأربعاء", "الخميس", "الثلاثاء"), "الثلاثاء", I can say "tuesday".),
                Exercise("WEDNESDAY", "wednesday", "ما معنى هذه الكلمة؟", listOf("الجمعة", "الأربعاء", "الخميس"), "الأربعاء", I can say "wednesday".),
                Exercise("THURSDAY", "thursday", "ما معنى هذه الكلمة؟", listOf("الخميس", "الجمعة", "السبت"), "الخميس", I can say "thursday".),
                Exercise("FRIDAY", "friday", "ما معنى هذه الكلمة؟", listOf("السبت", "الأحد", "الجمعة"), "الجمعة", I can say "friday".)
            )),
            CourseLesson(27, "أشهر السنة", listOf(
                Exercise("SATURDAY", "saturday", "ما معنى هذه الكلمة؟", listOf("الأحد", "يناير", "السبت"), "السبت", I can say "saturday".),
                Exercise("SUNDAY", "sunday", "ما معنى هذه الكلمة؟", listOf("فبراير", "الأحد", "يناير"), "الأحد", I can say "sunday".),
                Exercise("JANUARY", "january", "ما معنى هذه الكلمة؟", listOf("يناير", "فبراير", "مارس"), "يناير", I can say "january".),
                Exercise("FEBRUARY", "february", "ما معنى هذه الكلمة؟", listOf("مارس", "أبريل", "فبراير"), "فبراير", I can say "february".),
                Exercise("MARCH", "march", "ما معنى هذه الكلمة؟", listOf("مايو", "مارس", "أبريل"), "مارس", I can say "march".)
            )),
            CourseLesson(28, "قراءة الساعة", listOf(
                Exercise("APRIL", "april", "ما معنى هذه الكلمة؟", listOf("يونيو", "أبريل", "مايو"), "أبريل", I can say "april".),
                Exercise("MAY", "may", "ما معنى هذه الكلمة؟", listOf("مايو", "يونيو", "يوليو"), "مايو", I can say "may".),
                Exercise("JUNE", "june", "ما معنى هذه الكلمة؟", listOf("يوليو", "أغسطس", "يونيو"), "يونيو", I can say "june".),
                Exercise("JULY", "july", "ما معنى هذه الكلمة؟", listOf("سبتمبر", "يوليو", "أغسطس"), "يوليو", I can say "july".),
                Exercise("AUGUST", "august", "ما معنى هذه الكلمة؟", listOf("أغسطس", "سبتمبر", "أكتوبر"), "أغسطس", I can say "august".)
            )),
            CourseLesson(29, "التواريخ", listOf(
                Exercise("SEPTEMBER", "september", "ما معنى هذه الكلمة؟", listOf("سبتمبر", "أكتوبر", "نوفمبر"), "سبتمبر", I can say "september".),
                Exercise("OCTOBER", "october", "ما معنى هذه الكلمة؟", listOf("نوفمبر", "ديسمبر", "أكتوبر"), "أكتوبر", I can say "october".),
                Exercise("NOVEMBER", "november", "ما معنى هذه الكلمة؟", listOf("عطلة نهاية الأسبوع", "نوفمبر", "ديسمبر"), "نوفمبر", I can say "november".),
                Exercise("DECEMBER", "december", "ما معنى هذه الكلمة؟", listOf("ديسمبر", "عطلة نهاية الأسبوع", "اليوم"), "ديسمبر", I can say "december".),
                Exercise("WEEKEND", "weekend", "ما معنى هذه الكلمة؟", listOf("اليوم", "غداً", "عطلة نهاية الأسبوع"), "عطلة نهاية الأسبوع", I can say "weekend".)
            )),
            CourseLesson(30, "مراجعة الوقت", listOf(
                Exercise("TODAY", "today", "ما معنى هذه الكلمة؟", listOf("غداً", "أمس", "اليوم"), "اليوم", I can say "today".),
                Exercise("TOMORROW", "tomorrow", "ما معنى هذه الكلمة؟", listOf("الصباح", "غداً", "أمس"), "غداً", I can say "tomorrow".),
                Exercise("YESTERDAY", "yesterday", "ما معنى هذه الكلمة؟", listOf("أمس", "الصباح", "المساء"), "أمس", I can say "yesterday".),
                Exercise("MORNING", "morning", "ما معنى هذه الكلمة؟", listOf("المساء", "الاثنين", "الصباح"), "الصباح", I can say "morning".),
                Exercise("EVENING", "evening", "ما معنى هذه الكلمة؟", listOf("الثلاثاء", "المساء", "الاثنين"), "المساء", I can say "evening".)
            ))
        )),
        CourseUnit(7, "الدراسة والعمل", listOf(
            CourseLesson(31, "المدرسة والمواد", listOf(
                Exercise("SCHOOL", "school", "ما معنى هذه الكلمة؟", listOf("مدرسة", "فصل دراسي", "طالب"), "مدرسة", I can say "school".),
                Exercise("CLASSROOM", "classroom", "ما معنى هذه الكلمة؟", listOf("طالب", "معلم", "فصل دراسي"), "فصل دراسي", I can say "classroom".),
                Exercise("STUDENT", "student", "ما معنى هذه الكلمة؟", listOf("درس", "طالب", "معلم"), "طالب", I can say "student".),
                Exercise("TEACHER", "teacher", "ما معنى هذه الكلمة؟", listOf("معلم", "درس", "اللغة الإنجليزية"), "معلم", I can say "teacher".),
                Exercise("LESSON", "lesson", "ما معنى هذه الكلمة؟", listOf("اللغة الإنجليزية", "اللغة العربية", "درس"), "درس", I can say "lesson".)
            )),
            CourseLesson(32, "أدوات الدراسة", listOf(
                Exercise("ENGLISH", "english", "ما معنى هذه الكلمة؟", listOf("اللغة العربية", "رياضيات", "اللغة الإنجليزية"), "اللغة الإنجليزية", I can say "english".),
                Exercise("ARABIC", "arabic", "ما معنى هذه الكلمة؟", listOf("علوم", "اللغة العربية", "رياضيات"), "اللغة العربية", I can say "arabic".),
                Exercise("MATH", "math", "ما معنى هذه الكلمة؟", listOf("رياضيات", "علوم", "تاريخ"), "رياضيات", I can say "math".),
                Exercise("SCIENCE", "science", "ما معنى هذه الكلمة؟", listOf("تاريخ", "دفتر", "علوم"), "علوم", I can say "science".),
                Exercise("HISTORY", "history", "ما معنى هذه الكلمة؟", listOf("قلم رصاص", "تاريخ", "دفتر"), "تاريخ", I can say "history".)
            )),
            CourseLesson(33, "المهن", listOf(
                Exercise("NOTEBOOK", "notebook", "ما معنى هذه الكلمة؟", listOf("ممحاة", "دفتر", "قلم رصاص"), "دفتر", I can say "notebook".),
                Exercise("PENCIL", "pencil", "ما معنى هذه الكلمة؟", listOf("قلم رصاص", "ممحاة", "مسطرة"), "قلم رصاص", I can say "pencil".),
                Exercise("ERASER", "eraser", "ما معنى هذه الكلمة؟", listOf("مسطرة", "حاسوب", "ممحاة"), "ممحاة", I can say "eraser".),
                Exercise("RULER", "ruler", "ما معنى هذه الكلمة؟", listOf("طبيب", "مسطرة", "حاسوب"), "مسطرة", I can say "ruler".),
                Exercise("COMPUTER", "computer", "ما معنى هذه الكلمة؟", listOf("حاسوب", "طبيب", "ممرض"), "حاسوب", I can say "computer".)
            )),
            CourseLesson(34, "مكان العمل", listOf(
                Exercise("DOCTOR", "doctor", "ما معنى هذه الكلمة؟", listOf("طبيب", "ممرض", "سائق"), "طبيب", I can say "doctor".),
                Exercise("NURSE", "nurse", "ما معنى هذه الكلمة؟", listOf("سائق", "مهندس", "ممرض"), "ممرض", I can say "nurse".),
                Exercise("DRIVER", "driver", "ما معنى هذه الكلمة؟", listOf("طباخ", "سائق", "مهندس"), "سائق", I can say "driver".),
                Exercise("ENGINEER", "engineer", "ما معنى هذه الكلمة؟", listOf("مهندس", "طباخ", "مكتب"), "مهندس", I can say "engineer".),
                Exercise("COOK", "cook", "ما معنى هذه الكلمة؟", listOf("مكتب", "مدير", "طباخ"), "طباخ", I can say "cook".)
            )),
            CourseLesson(35, "مراجعة الدراسة والعمل", listOf(
                Exercise("OFFICE", "office", "ما معنى هذه الكلمة؟", listOf("مدير", "زميل عمل", "مكتب"), "مكتب", I can say "office".),
                Exercise("MANAGER", "manager", "ما معنى هذه الكلمة؟", listOf("وظيفة", "مدير", "زميل عمل"), "مدير", I can say "manager".),
                Exercise("COLLEAGUE", "colleague", "ما معنى هذه الكلمة؟", listOf("زميل عمل", "وظيفة", "مشغول"), "زميل عمل", I can say "colleague".),
                Exercise("JOB", "job", "ما معنى هذه الكلمة؟", listOf("مشغول", "مدرسة", "وظيفة"), "وظيفة", I can say "job".),
                Exercise("BUSY", "busy", "ما معنى هذه الكلمة؟", listOf("فصل دراسي", "مشغول", "مدرسة"), "مشغول", I can say "busy".)
            ))
        )),
        CourseUnit(8, "المدينة والمواصلات", listOf(
            CourseLesson(36, "أماكن في المدينة", listOf(
                Exercise("STREET", "street", "ما معنى هذه الكلمة؟", listOf("شارع", "طريق", "بنك"), "شارع", I can say "street".),
                Exercise("ROAD", "road", "ما معنى هذه الكلمة؟", listOf("بنك", "مستشفى", "طريق"), "طريق", I can say "road".),
                Exercise("BANK", "bank", "ما معنى هذه الكلمة؟", listOf("صيدلية", "بنك", "مستشفى"), "بنك", I can say "bank".),
                Exercise("HOSPITAL", "hospital", "ما معنى هذه الكلمة؟", listOf("مستشفى", "صيدلية", "مدرسة"), "مستشفى", I can say "hospital".),
                Exercise("PHARMACY", "pharmacy", "ما معنى هذه الكلمة؟", listOf("مدرسة", "مسجد", "صيدلية"), "صيدلية", I can say "pharmacy".)
            )),
            CourseLesson(37, "الاتجاهات", listOf(
                Exercise("SCHOOL", "school", "ما معنى هذه الكلمة؟", listOf("مسجد", "حديقة عامة", "مدرسة"), "مدرسة", I can say "school".),
                Exercise("MOSQUE", "mosque", "ما معنى هذه الكلمة؟", listOf("محطة", "مسجد", "حديقة عامة"), "مسجد", I can say "mosque".),
                Exercise("PARK", "park", "ما معنى هذه الكلمة؟", listOf("حديقة عامة", "محطة", "سوق"), "حديقة عامة", I can say "park".),
                Exercise("STATION", "station", "ما معنى هذه الكلمة؟", listOf("سوق", "يسار", "محطة"), "محطة", I can say "station".),
                Exercise("MARKET", "market", "ما معنى هذه الكلمة؟", listOf("يمين", "سوق", "يسار"), "سوق", I can say "market".)
            )),
            CourseLesson(38, "وسائل النقل", listOf(
                Exercise("LEFT", "left", "ما معنى هذه الكلمة؟", listOf("مستقيماً", "يسار", "يمين"), "يسار", I can say "left".),
                Exercise("RIGHT", "right", "ما معنى هذه الكلمة؟", listOf("يمين", "مستقيماً", "قريب"), "يمين", I can say "right".),
                Exercise("STRAIGHT", "straight", "ما معنى هذه الكلمة؟", listOf("قريب", "بعيد", "مستقيماً"), "مستقيماً", I can say "straight".),
                Exercise("NEAR", "near", "ما معنى هذه الكلمة؟", listOf("حافلة", "قريب", "بعيد"), "قريب", I can say "near".),
                Exercise("FAR", "far", "ما معنى هذه الكلمة؟", listOf("بعيد", "حافلة", "قطار"), "بعيد", I can say "far".)
            )),
            CourseLesson(39, "السؤال عن الطريق", listOf(
                Exercise("BUS", "bus", "ما معنى هذه الكلمة؟", listOf("حافلة", "قطار", "سيارة"), "حافلة", I can say "bus".),
                Exercise("TRAIN", "train", "ما معنى هذه الكلمة؟", listOf("سيارة", "سيارة أجرة", "قطار"), "قطار", I can say "train".),
                Exercise("CAR", "car", "ما معنى هذه الكلمة؟", listOf("دراجة", "سيارة", "سيارة أجرة"), "سيارة", I can say "car".),
                Exercise("TAXI", "taxi", "ما معنى هذه الكلمة؟", listOf("سيارة أجرة", "دراجة", "تذكرة"), "سيارة أجرة", I can say "taxi".),
                Exercise("BICYCLE", "bicycle", "ما معنى هذه الكلمة؟", listOf("تذكرة", "خريطة", "دراجة"), "دراجة", I can say "bicycle".)
            )),
            CourseLesson(40, "مراجعة المدينة", listOf(
                Exercise("TICKET", "ticket", "ما معنى هذه الكلمة؟", listOf("خريطة", "يتوقف", "تذكرة"), "تذكرة", I can say "ticket".),
                Exercise("MAP", "map", "ما معنى هذه الكلمة؟", listOf("ينعطف", "خريطة", "يتوقف"), "خريطة", I can say "map".),
                Exercise("STOP", "stop", "ما معنى هذه الكلمة؟", listOf("يتوقف", "ينعطف", "يسافر"), "يتوقف", I can say "stop".),
                Exercise("TURN", "turn", "ما معنى هذه الكلمة؟", listOf("يسافر", "شارع", "ينعطف"), "ينعطف", I can say "turn".),
                Exercise("TRAVEL", "travel", "ما معنى هذه الكلمة؟", listOf("طريق", "يسافر", "شارع"), "يسافر", I can say "travel".)
            ))
        )),
        CourseUnit(9, "التسوق والملابس", listOf(
            CourseLesson(41, "الملابس الأساسية", listOf(
                Exercise("SHIRT", "shirt", "ما معنى هذه الكلمة؟", listOf("قميص", "سروال", "فستان"), "قميص", I can say "shirt".),
                Exercise("TROUSERS", "trousers", "ما معنى هذه الكلمة؟", listOf("فستان", "سترة", "سروال"), "سروال", I can say "trousers".),
                Exercise("DRESS", "dress", "ما معنى هذه الكلمة؟", listOf("حذاء", "فستان", "سترة"), "فستان", I can say "dress".),
                Exercise("JACKET", "jacket", "ما معنى هذه الكلمة؟", listOf("سترة", "حذاء", "جوارب"), "سترة", I can say "jacket".),
                Exercise("SHOES", "shoes", "ما معنى هذه الكلمة؟", listOf("جوارب", "قبعة", "حذاء"), "حذاء", I can say "shoes".)
            )),
            CourseLesson(42, "الألوان والمقاسات", listOf(
                Exercise("SOCKS", "socks", "ما معنى هذه الكلمة؟", listOf("قبعة", "وشاح", "جوارب"), "جوارب", I can say "socks".),
                Exercise("HAT", "hat", "ما معنى هذه الكلمة؟", listOf("معطف", "قبعة", "وشاح"), "قبعة", I can say "hat".),
                Exercise("SCARF", "scarf", "ما معنى هذه الكلمة؟", listOf("وشاح", "معطف", "تنورة"), "وشاح", I can say "scarf".),
                Exercise("COAT", "coat", "ما معنى هذه الكلمة؟", listOf("تنورة", "أحمر", "معطف"), "معطف", I can say "coat".),
                Exercise("SKIRT", "skirt", "ما معنى هذه الكلمة؟", listOf("أزرق", "تنورة", "أحمر"), "تنورة", I can say "skirt".)
            )),
            CourseLesson(43, "الأسعار والمال", listOf(
                Exercise("RED", "red", "ما معنى هذه الكلمة؟", listOf("أخضر", "أحمر", "أزرق"), "أحمر", I can say "red".),
                Exercise("BLUE", "blue", "ما معنى هذه الكلمة؟", listOf("أزرق", "أخضر", "أسود"), "أزرق", I can say "blue".),
                Exercise("GREEN", "green", "ما معنى هذه الكلمة؟", listOf("أسود", "أبيض", "أخضر"), "أخضر", I can say "green".),
                Exercise("BLACK", "black", "ما معنى هذه الكلمة؟", listOf("مقاس", "أسود", "أبيض"), "أسود", I can say "black".),
                Exercise("WHITE", "white", "ما معنى هذه الكلمة؟", listOf("أبيض", "مقاس", "صغير"), "أبيض", I can say "white".)
            )),
            CourseLesson(44, "في المتجر", listOf(
                Exercise("SIZE", "size", "ما معنى هذه الكلمة؟", listOf("مقاس", "صغير", "متوسط"), "مقاس", I can say "size".),
                Exercise("SMALL", "small", "ما معنى هذه الكلمة؟", listOf("متوسط", "كبير", "صغير"), "صغير", I can say "small".),
                Exercise("MEDIUM", "medium", "ما معنى هذه الكلمة؟", listOf("سعر", "متوسط", "كبير"), "متوسط", I can say "medium".),
                Exercise("LARGE", "large", "ما معنى هذه الكلمة؟", listOf("كبير", "سعر", "مال"), "كبير", I can say "large".),
                Exercise("PRICE", "price", "ما معنى هذه الكلمة؟", listOf("مال", "نقداً", "سعر"), "سعر", I can say "price".)
            )),
            CourseLesson(45, "مراجعة التسوق", listOf(
                Exercise("MONEY", "money", "ما معنى هذه الكلمة؟", listOf("نقداً", "رخيص", "مال"), "مال", I can say "money".),
                Exercise("CASH", "cash", "ما معنى هذه الكلمة؟", listOf("غالي", "نقداً", "رخيص"), "نقداً", I can say "cash".),
                Exercise("CHEAP", "cheap", "ما معنى هذه الكلمة؟", listOf("رخيص", "غالي", "متجر"), "رخيص", I can say "cheap".),
                Exercise("EXPENSIVE", "expensive", "ما معنى هذه الكلمة؟", listOf("متجر", "قميص", "غالي"), "غالي", I can say "expensive".),
                Exercise("SHOP", "shop", "ما معنى هذه الكلمة؟", listOf("سروال", "متجر", "قميص"), "متجر", I can say "shop".)
            ))
        )),
        CourseUnit(10, "الطقس والطبيعة", listOf(
            CourseLesson(46, "حالة الطقس", listOf(
                Exercise("SUN", "sun", "ما معنى هذه الكلمة؟", listOf("شمس", "مطر", "رياح"), "شمس", I can say "sun".),
                Exercise("RAIN", "rain", "ما معنى هذه الكلمة؟", listOf("رياح", "سحابة", "مطر"), "مطر", I can say "rain".),
                Exercise("WIND", "wind", "ما معنى هذه الكلمة؟", listOf("ثلج", "رياح", "سحابة"), "رياح", I can say "wind".),
                Exercise("CLOUD", "cloud", "ما معنى هذه الكلمة؟", listOf("سحابة", "ثلج", "حار"), "سحابة", I can say "cloud".),
                Exercise("SNOW", "snow", "ما معنى هذه الكلمة؟", listOf("حار", "بارد", "ثلج"), "ثلج", I can say "snow".)
            )),
            CourseLesson(47, "الفصول", listOf(
                Exercise("HOT", "hot", "ما معنى هذه الكلمة؟", listOf("بارد", "دافئ", "حار"), "حار", I can say "hot".),
                Exercise("COLD", "cold", "ما معنى هذه الكلمة؟", listOf("معتدل البرودة", "بارد", "دافئ"), "بارد", I can say "cold".),
                Exercise("WARM", "warm", "ما معنى هذه الكلمة؟", listOf("دافئ", "معتدل البرودة", "طقس"), "دافئ", I can say "warm".),
                Exercise("COOL", "cool", "ما معنى هذه الكلمة؟", listOf("طقس", "الربيع", "معتدل البرودة"), "معتدل البرودة", I can say "cool".),
                Exercise("WEATHER", "weather", "ما معنى هذه الكلمة؟", listOf("الصيف", "طقس", "الربيع"), "طقس", I can say "weather".)
            )),
            CourseLesson(48, "الطبيعة", listOf(
                Exercise("SPRING", "spring", "ما معنى هذه الكلمة؟", listOf("الخريف", "الربيع", "الصيف"), "الربيع", I can say "spring".),
                Exercise("SUMMER", "summer", "ما معنى هذه الكلمة؟", listOf("الصيف", "الخريف", "الشتاء"), "الصيف", I can say "summer".),
                Exercise("AUTUMN", "autumn", "ما معنى هذه الكلمة؟", listOf("الشتاء", "فصل", "الخريف"), "الخريف", I can say "autumn".),
                Exercise("WINTER", "winter", "ما معنى هذه الكلمة؟", listOf("شجرة", "الشتاء", "فصل"), "الشتاء", I can say "winter".),
                Exercise("SEASON", "season", "ما معنى هذه الكلمة؟", listOf("فصل", "شجرة", "زهرة"), "فصل", I can say "season".)
            )),
            CourseLesson(49, "وصف الجو", listOf(
                Exercise("TREE", "tree", "ما معنى هذه الكلمة؟", listOf("شجرة", "زهرة", "نهر"), "شجرة", I can say "tree".),
                Exercise("FLOWER", "flower", "ما معنى هذه الكلمة؟", listOf("نهر", "جبل", "زهرة"), "زهرة", I can say "flower".),
                Exercise("RIVER", "river", "ما معنى هذه الكلمة؟", listOf("بحر", "نهر", "جبل"), "نهر", I can say "river".),
                Exercise("MOUNTAIN", "mountain", "ما معنى هذه الكلمة؟", listOf("جبل", "بحر", "سماء"), "جبل", I can say "mountain".),
                Exercise("SEA", "sea", "ما معنى هذه الكلمة؟", listOf("سماء", "عشب", "بحر"), "بحر", I can say "sea".)
            )),
            CourseLesson(50, "مراجعة الطقس والطبيعة", listOf(
                Exercise("SKY", "sky", "ما معنى هذه الكلمة؟", listOf("عشب", "حيوان", "سماء"), "سماء", I can say "sky".),
                Exercise("GRASS", "grass", "ما معنى هذه الكلمة؟", listOf("جميل", "عشب", "حيوان"), "عشب", I can say "grass".),
                Exercise("ANIMAL", "animal", "ما معنى هذه الكلمة؟", listOf("حيوان", "جميل", "غائم"), "حيوان", I can say "animal".),
                Exercise("BEAUTIFUL", "beautiful", "ما معنى هذه الكلمة؟", listOf("غائم", "شمس", "جميل"), "جميل", I can say "beautiful".),
                Exercise("CLOUDY", "cloudy", "ما معنى هذه الكلمة؟", listOf("مطر", "غائم", "شمس"), "غائم", I can say "cloudy".)
            ))
        )),
        CourseUnit(11, "الصحة والجسم", listOf(
            CourseLesson(51, "أجزاء الجسم", listOf(
                Exercise("HEAD", "head", "ما معنى هذه الكلمة؟", listOf("رأس", "عين", "أذن"), "رأس", I can say "head".),
                Exercise("EYE", "eye", "ما معنى هذه الكلمة؟", listOf("أذن", "أنف", "عين"), "عين", I can say "eye".),
                Exercise("EAR", "ear", "ما معنى هذه الكلمة؟", listOf("فم", "أذن", "أنف"), "أذن", I can say "ear".),
                Exercise("NOSE", "nose", "ما معنى هذه الكلمة؟", listOf("أنف", "فم", "يد"), "أنف", I can say "nose".),
                Exercise("MOUTH", "mouth", "ما معنى هذه الكلمة؟", listOf("يد", "ذراع", "فم"), "فم", I can say "mouth".)
            )),
            CourseLesson(52, "المشاعر والأعراض", listOf(
                Exercise("HAND", "hand", "ما معنى هذه الكلمة؟", listOf("ذراع", "ساق", "يد"), "يد", I can say "hand".),
                Exercise("ARM", "arm", "ما معنى هذه الكلمة؟", listOf("قدم", "ذراع", "ساق"), "ذراع", I can say "arm".),
                Exercise("LEG", "leg", "ما معنى هذه الكلمة؟", listOf("ساق", "قدم", "جسم"), "ساق", I can say "leg".),
                Exercise("FOOT", "foot", "ما معنى هذه الكلمة؟", listOf("جسم", "مريض", "قدم"), "قدم", I can say "foot".),
                Exercise("BODY", "body", "ما معنى هذه الكلمة؟", listOf("مريض", "جسم", "مريض"), "جسم", I can say "body".)
            )),
            CourseLesson(53, "زيارة الطبيب", listOf(
                Exercise("ILL", "ill", "ما معنى هذه الكلمة؟", listOf("ألم", "مريض", "مريض"), "مريض", I can say "ill".),
                Exercise("SICK", "sick", "ما معنى هذه الكلمة؟", listOf("مريض", "ألم", "صداع"), "مريض", I can say "sick".),
                Exercise("PAIN", "pain", "ما معنى هذه الكلمة؟", listOf("صداع", "حمى", "ألم"), "ألم", I can say "pain".),
                Exercise("HEADACHE", "headache", "ما معنى هذه الكلمة؟", listOf("طبيب", "صداع", "حمى"), "صداع", I can say "headache".),
                Exercise("FEVER", "fever", "ما معنى هذه الكلمة؟", listOf("حمى", "طبيب", "دواء"), "حمى", I can say "fever".)
            )),
            CourseLesson(54, "العادات الصحية", listOf(
                Exercise("DOCTOR", "doctor", "ما معنى هذه الكلمة؟", listOf("طبيب", "دواء", "موعد"), "طبيب", I can say "doctor".),
                Exercise("MEDICINE", "medicine", "ما معنى هذه الكلمة؟", listOf("موعد", "مساعدة", "دواء"), "دواء", I can say "medicine".),
                Exercise("APPOINTMENT", "appointment", "ما معنى هذه الكلمة؟", listOf("راحة", "موعد", "مساعدة"), "موعد", I can say "appointment".),
                Exercise("HELP", "help", "ما معنى هذه الكلمة؟", listOf("مساعدة", "راحة", "صحي"), "مساعدة", I can say "help".),
                Exercise("REST", "rest", "ما معنى هذه الكلمة؟", listOf("صحي", "تمرين", "راحة"), "راحة", I can say "rest".)
            )),
            CourseLesson(55, "مراجعة الصحة", listOf(
                Exercise("HEALTHY", "healthy", "ما معنى هذه الكلمة؟", listOf("تمرين", "طعام", "صحي"), "صحي", I can say "healthy".),
                Exercise("EXERCISE", "exercise", "ما معنى هذه الكلمة؟", listOf("نوم", "تمرين", "طعام"), "تمرين", I can say "exercise".),
                Exercise("FOOD", "food", "ما معنى هذه الكلمة؟", listOf("طعام", "نوم", "قوي"), "طعام", I can say "food".),
                Exercise("SLEEP", "sleep", "ما معنى هذه الكلمة؟", listOf("قوي", "رأس", "نوم"), "نوم", I can say "sleep".),
                Exercise("STRONG", "strong", "ما معنى هذه الكلمة؟", listOf("عين", "قوي", "رأس"), "قوي", I can say "strong".)
            ))
        )),
        CourseUnit(12, "الهوايات والسفر", listOf(
            CourseLesson(56, "الهوايات", listOf(
                Exercise("HOBBY", "hobby", "ما معنى هذه الكلمة؟", listOf("هواية", "القراءة", "الرسم"), "هواية", I can say "hobby".),
                Exercise("READING", "reading", "ما معنى هذه الكلمة؟", listOf("الرسم", "الطبخ", "القراءة"), "القراءة", I can say "reading".),
                Exercise("DRAWING", "drawing", "ما معنى هذه الكلمة؟", listOf("البستنة", "الرسم", "الطبخ"), "الرسم", I can say "drawing".),
                Exercise("COOKING", "cooking", "ما معنى هذه الكلمة؟", listOf("الطبخ", "البستنة", "كرة القدم"), "الطبخ", I can say "cooking".),
                Exercise("GARDENING", "gardening", "ما معنى هذه الكلمة؟", listOf("كرة القدم", "السباحة", "البستنة"), "البستنة", I can say "gardening".)
            )),
            CourseLesson(57, "الرياضة", listOf(
                Exercise("FOOTBALL", "football", "ما معنى هذه الكلمة؟", listOf("السباحة", "الجري", "كرة القدم"), "كرة القدم", I can say "football".),
                Exercise("SWIMMING", "swimming", "ما معنى هذه الكلمة؟", listOf("التنس", "السباحة", "الجري"), "السباحة", I can say "swimming".),
                Exercise("RUNNING", "running", "ما معنى هذه الكلمة؟", listOf("الجري", "التنس", "لعبة"), "الجري", I can say "running".),
                Exercise("TENNIS", "tennis", "ما معنى هذه الكلمة؟", listOf("لعبة", "عطلة", "التنس"), "التنس", I can say "tennis".),
                Exercise("GAME", "game", "ما معنى هذه الكلمة؟", listOf("رحلة", "لعبة", "عطلة"), "لعبة", I can say "game".)
            )),
            CourseLesson(58, "العطلات والسفر", listOf(
                Exercise("HOLIDAY", "holiday", "ما معنى هذه الكلمة؟", listOf("يزور", "عطلة", "رحلة"), "عطلة", I can say "holiday".),
                Exercise("TRIP", "trip", "ما معنى هذه الكلمة؟", listOf("رحلة", "يزور", "كاميرا"), "رحلة", I can say "trip".),
                Exercise("VISIT", "visit", "ما معنى هذه الكلمة؟", listOf("كاميرا", "صورة", "يزور"), "يزور", I can say "visit".),
                Exercise("CAMERA", "camera", "ما معنى هذه الكلمة؟", listOf("فندق", "كاميرا", "صورة"), "كاميرا", I can say "camera".),
                Exercise("PHOTO", "photo", "ما معنى هذه الكلمة؟", listOf("صورة", "فندق", "مطار"), "صورة", I can say "photo".)
            )),
            CourseLesson(59, "الفندق والمطار", listOf(
                Exercise("HOTEL", "hotel", "ما معنى هذه الكلمة؟", listOf("فندق", "مطار", "جواز سفر"), "فندق", I can say "hotel".),
                Exercise("AIRPORT", "airport", "ما معنى هذه الكلمة؟", listOf("جواز سفر", "أمتعة", "مطار"), "مطار", I can say "airport".),
                Exercise("PASSPORT", "passport", "ما معنى هذه الكلمة؟", listOf("حجز", "جواز سفر", "أمتعة"), "جواز سفر", I can say "passport".),
                Exercise("LUGGAGE", "luggage", "ما معنى هذه الكلمة؟", listOf("أمتعة", "حجز", "شاطئ"), "أمتعة", I can say "luggage".),
                Exercise("RESERVATION", "reservation", "ما معنى هذه الكلمة؟", listOf("شاطئ", "متحف", "حجز"), "حجز", I can say "reservation".)
            )),
            CourseLesson(60, "مراجعة عامة", listOf(
                Exercise("BEACH", "beach", "ما معنى هذه الكلمة؟", listOf("متحف", "جميل", "شاطئ"), "شاطئ", I can say "beach".),
                Exercise("MUSEUM", "museum", "ما معنى هذه الكلمة؟", listOf("يستمتع", "متحف", "جميل"), "متحف", I can say "museum".),
                Exercise("BEAUTIFUL", "beautiful", "ما معنى هذه الكلمة؟", listOf("جميل", "يستمتع", "مفضل"), "جميل", I can say "beautiful".),
                Exercise("ENJOY", "enjoy", "ما معنى هذه الكلمة؟", listOf("مفضل", "هواية", "يستمتع"), "يستمتع", I can say "enjoy".),
                Exercise("FAVORITE", "favorite", "ما معنى هذه الكلمة؟", listOf("القراءة", "مفضل", "هواية"), "مفضل", I can say "favorite".)
            ))
        ))
    )
}
