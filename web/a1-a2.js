(()=>{"use strict";
const lessons=[
{lv:"A1",title:"الأشخاص",icon:"girl",words:[["boy","ولد","boy","👦"],["girl","بنت","girl","👧"],["man","رجل","man","👨"],["woman","امرأة","mother","👩"],["grandfather","جدّ","grandpa","👴"],["grandmother","جدّة","grandma","👵"]]},
{lv:"A1",title:"العائلة",icon:"father",np:true,words:[["father","أب","father","👨"],["mother","أم","mother","👩"],["brother","أخ","boyf","👦"],["sister","أخت","girlf","👧"],["son","ابن","boy","👦"],["daughter","ابنة","student","👧"]]},
{lv:"A1",title:"المنزل",icon:"house",words:[["house","بيت","house","🏠"],["door","باب","door","🚪"],["window","نافذة","window","🪟"],["key","مفتاح","key","🔑"],["bed","سرير","bed","🛏️"],["lamp","مصباح","lamp","💡"]]},
{lv:"A1",title:"الأثاث",icon:"chair",words:[["chair","كرسي","chair","🪑"],["table","طاولة","table","🪑"],["wardrobe","خزانة","wardrobe","🚪"],["mirror","مرآة","mirror","🪞"],["television","تلفاز","tv","📺"],["clock","ساعة","clock","🕒"]]},
{lv:"A1",title:"المطبخ",icon:"pot",words:[["spoon","ملعقة","spoon","🥄"],["fork","شوكة","fork","🍴"],["plate","صحن","plate","🍽️"],["cup","كوب","cup","☕"],["pot","قدر","pot","🍲"],["pan","مقلاة","pan","🍳"]]},
{lv:"A1",title:"الملابس",icon:"shirt",words:[["shirt","قميص","shirt","👕"],["shoe","حذاء","shoe","👞"],["cap","قبعة","cap","🧢"],["watch","ساعة يد","watch","⌚"],["glasses","نظارة","glasses","👓"],["bag","حقيبة","bag","🎒"]]},
{lv:"A1",title:"الأرقام",icon:"numbers",words:[["one","واحد","","1️⃣"],["two","اثنان","","2️⃣"],["three","ثلاثة","","3️⃣"],["four","أربعة","","4️⃣"],["five","خمسة","","5️⃣"],["ten","عشرة","","🔟"]]},
{lv:"A1",title:"الألوان",icon:"palette",words:[["red","أحمر","","🟥"],["blue","أزرق","","🟦"],["green","أخضر","","🟩"],["yellow","أصفر","","🟨"],["white","أبيض","","⬜"],["black","أسود","","⬛"]]},
{lv:"A2",title:"المدرسة",icon:"school",words:[["school","مدرسة","school","🏫"],["book","كتاب","book","📘"],["pencil","قلم رصاص","pencil","✏️"],["eraser","ممحاة","eraser","🧽"],["ruler","مسطرة","ruler","📏"],["sharpener","مبراة","sharpener","✏️"]]},
{lv:"A2",title:"القرطاسية",icon:"notebook",words:[["notebook","دفتر","notebook","📓"],["marker","قلم تحديد","marker","🖊️"],["glue","غراء","glue","🧴"],["stapler","دباسة","stapler","📎"],["paper clip","مشبك ورق","clip","📎"],["folder","ملف","folder","📁"]]},
{lv:"A2",title:"المهن",icon:"doctor",words:[["teacher","معلّم","teacher","👨‍🏫"],["doctor","طبيب","doctor","🩺"],["police officer","شرطي","police","👮"],["firefighter","رجل إطفاء","fire","🚒"],["builder","عامل بناء","builder","👷"],["chef","طبّاخ","chef","👨‍🍳"]]},
{lv:"A2",title:"المواصلات",icon:"bus",words:[["car","سيارة","car","🚗"],["bus","حافلة","bus","🚌"],["train","قطار","train","🚆"],["airplane","طائرة","plane","✈️"],["ship","سفينة","ship","🚢"],["bicycle","دراجة","bike","🚲"]]},
{lv:"A2",title:"الطبيعة",icon:"sun",words:[["sun","شمس","sun","☀️"],["moon","قمر","moon","🌙"],["star","نجمة","star","⭐"],["cloud","سحابة","cloud","☁️"],["mountain","جبل","mountain","⛰️"],["sea","بحر","sea","🌊"]]},
{lv:"A2",title:"الحياة اليومية",icon:"phone",words:[["phone","هاتف","phone","📱"],["camera","كاميرا","camera","📷"],["flashlight","مصباح يدوي","torch","🔦"],["ball","كرة","ball","⚽"],["bottle","زجاجة","bottle","🧴"],["newspaper","جريدة","news","📰"]]},
{lv:"A2",title:"السفر",icon:"passport",words:[["passport","جواز سفر","passport","🛂"],["ticket","تذكرة","ticket","🎫"],["map","خريطة","map","🗺️"],["wallet","محفظة","wallet","👛"],["coin","عملة","coin","🪙"],["envelope","مغلّف","envelope","✉️"]]}
];
const KEY="ep-a1a2-progress-v1";let state=load(),level="A1",current=0,queue=[],qIndex=0,correct=0,errors=0,selected=null,checked=false,root=null;
function load(){try{return JSON.parse(localStorage.getItem(KEY))||{A1:[],A2:[]}}catch{return{A1:[],A2:[]}}}
function save(){localStorage.setItem(KEY,JSON.stringify(state))}
function esc(s){return String(s).replace(/[&<>"']/g,c=>({"&":"&amp;","<":"&lt;",">":"&gt;",'"':"&quot;","'":"&#39;"}[c]))}
function img(w){const [en,ar,key,emoji]=w;return key?'<img src="./img/'+key+'.jpg" alt="'+esc(en)+'" loading="lazy" onerror="this.replaceWith(Object.assign(document.createElement(\'span\'),{className:\'a1a2-fallback\',textContent:'+JSON.stringify(emoji)+'}))">':'<span class="a1a2-fallback">'+emoji+'</span>'}
function open(){root=document.getElementById("a1a2-dialog");if(!root){root=document.createElement("dialog");root.id="a1a2-dialog";root.className="lesson-dialog a1a2-dialog";document.body.append(root)}renderHome();root.showModal()}
function close(){root?.close()}
function renderHome(){
const done=state[level]||[],items=lessons.map((l,i)=>({...l,index:i})).filter(l=>l.lv===level);
root.innerHTML='<div class="a1a2-head"><button class="icon-button" data-action="close" aria-label="إغلاق">✕</button><div><b>دروس A1 وA2 المصوّرة</b><small>90 كلمة • 15 درساً</small></div><span class="a1a2-xp">⭐ '+Number(localStorage.getItem("ep-xp")||0)+'</span></div><div class="a1a2-tabs"><button data-level="A1" class="'+(level==="A1"?"active":"")+'">A1 مبتدئ</button><button data-level="A2" class="'+(level==="A2"?"active":"")+'">A2 أساسي</button></div><div class="a1a2-lessons">'+items.map((l,n)=>{const isDone=done.includes(l.index),unlocked=n===0||done.includes(items[n-1].index);return '<button class="a1a2-lesson '+(isDone?"done":"")+'" data-lesson="'+l.index+'" '+(!unlocked?"disabled":"")+'><span class="a1a2-lesson-icon">'+(isDone?"✓":l.words[0][3])+'</span><span><b>'+l.title+'</b><small>'+(isDone?"أُنجز الدرس":unlocked?"6 كلمات • ابدأ الآن":"أكمل الدرس السابق لفتحه")+'</small></span><strong>'+(unlocked?"←":"🔒")+'</strong></button>'}).join("")+'</div>';
}
function intro(i){current=i;const l=lessons[i];root.innerHTML='<div class="a1a2-head"><button class="icon-button" data-action="home">‹</button><div><b>'+l.title+'</b><small>'+l.lv+' • ست كلمات جديدة</small></div></div><div class="a1a2-word-grid">'+l.words.map(w=>'<button class="a1a2-word" data-speak="'+esc(w[0])+'"><span>'+img(w)+'</span><b dir="ltr">'+esc(w[0])+'</b><small>'+esc(w[1])+'　🔊</small></button>').join("")+'</div><button class="primary-button" data-action="start">ابدأ التمرين</button>'}
function shuffle(a){a=[...a];for(let i=a.length-1;i>0;i--){const j=Math.floor(Math.random()*(i+1));[a[i],a[j]]=[a[j],a[i]]}return a}
function options(q,field){const l=lessons[current],pool=l.words.filter(w=>w[0]!==q[0]).map(w=>w[field]);return shuffle([...shuffle(pool).slice(0,3),q[field]])}
function start(){const l=lessons[current],types=l.np?["hear","see","type","hear","see","type"]:["pic","hear","see","pic","type","hear"];queue=shuffle(l.words).map((w,i)=>({type:types[i],w}));qIndex=0;correct=0;errors=0;show()}
function show(){
if(qIndex>=queue.length){finish();return}
const q=queue[qIndex],w=q.w;selected=null;checked=false;let body="",opts=[];
if(q.type==="pic"){body='<div class="a1a2-prompt-image">'+img(w)+'</div><h3>ما اسم هذه الصورة بالإنجليزية؟</h3>';opts=options(q,0)}
else if(q.type==="hear"){body='<h3>استمع إلى الكلمة واخترها</h3><button class="a1a2-speaker" data-speak="'+esc(w[0])+'">🔊</button>';opts=options(q,0)}
else if(q.type==="see"){body='<h3>ما معنى هذه الكلمة؟</h3><div class="a1a2-word-prompt" dir="ltr">'+esc(w[0])+' <button data-speak="'+esc(w[0])+'">🔊</button></div>';opts=options(q,1)}
else body='<h3>اكتب الكلمة بالإنجليزية</h3><div class="a1a2-arabic">'+esc(w[1])+'</div><input class="a1a2-input" id="a1a2-input" placeholder="Type in English" autocomplete="off" autocapitalize="off" spellcheck="false">';
root.innerHTML='<div class="a1a2-head"><button class="icon-button" data-action="home">✕</button><div class="a1a2-progress"><span style="width:'+Math.round(correct/6*100)+'%"></span></div><small>'+Number(localStorage.getItem("ep-hearts")??5)+' ❤️</small></div><div class="a1a2-question"><p>السؤال '+(qIndex+1)+'</p>'+body+(opts.length?'<div class="a1a2-options">'+opts.map(o=>'<button data-answer="'+esc(o)+'" dir="'+(q.type==="see"?"rtl":"ltr")+'">'+esc(o)+'</button>').join("")+'</div>':'')+'<div class="a1a2-feedback" id="a1a2-feedback"></div><button class="primary-button" id="a1a2-check" disabled>تحقق</button></div>';
const input=root.querySelector("#a1a2-input"),check=root.querySelector("#a1a2-check");
root.querySelectorAll("[data-answer]").forEach(b=>b.addEventListener("click",()=>{if(checked)return;selected=b.dataset.answer;root.querySelectorAll("[data-answer]").forEach(x=>x.classList.toggle("selected",x===b));check.disabled=false}));
input?.addEventListener("input",()=>check.disabled=!input.value.trim());
check.addEventListener("click",()=>act(q,input));
root.querySelectorAll("[data-speak]").forEach(b=>b.addEventListener("click",()=>speak(b.dataset.speak)));
if(q.type==="hear")setTimeout(()=>speak(w[0]),250);
}
function speak(word){try{const u=new SpeechSynthesisUtterance(word);u.lang="en-US";u.rate=.86;speechSynthesis.cancel();speechSynthesis.speak(u)}catch{}}
function norm(s){return String(s).toLowerCase().replace(/\(\.\)/g,"").replace(/[^a-z ]/g,"").replace(/\s+/g," ").trim()}
function act(q,input){
const w=q.w,right=q.type==="see"?w[1]:w[0],given=q.type==="type"?input.value.trim():selected,ok=norm(given)===norm(right),check=root.querySelector("#a1a2-check"),feedback=root.querySelector("#a1a2-feedback");
if(!checked){
checked=true;
root.querySelectorAll("[data-answer]").forEach(b=>{b.disabled=true;if(b.dataset.answer===right)b.classList.add("correct");else if(b.dataset.answer===selected)b.classList.add("wrong")});
if(ok){correct++;addXP(2);feedback.className="a1a2-feedback good";feedback.textContent="ممتاز! إجابة صحيحة 🎉"}
else{errors++;const h=Math.max(0,Number(localStorage.getItem("ep-hearts")??5)-1);localStorage.setItem("ep-hearts",h);window.dispatchEvent(new Event("ep-hearts-updated"));feedback.className="a1a2-feedback bad";feedback.textContent="التصحيح: "+right;queue.push(q)}
if(input)input.disabled=true;
speak(w[0]);check.disabled=false;check.textContent="متابعة";return;
}
qIndex++;show();
}
function addXP(n){const xp=Number(localStorage.getItem("ep-xp")||0)+n;localStorage.setItem("ep-xp",xp);localStorage.setItem("ep-points",xp);window.dispatchEvent(new Event("ep-xp-updated"))}
function finish(){
const done=state[lessons[current].lv]||[];if(!done.includes(current)){done.push(current);state[lessons[current].lv]=done;save();addXP(10)}
const l=lessons[current];root.innerHTML='<div class="a1a2-finish"><div>🏆</div><h2>أنهيت الدرس!</h2><p>إجابات صحيحة: '+correct+' • أخطاء: '+errors+'</p><p>حصلت على '+(10+correct*2)+' XP</p><button class="primary-button" data-action="home">العودة إلى الدروس</button></div>';
}
function handle(e){
const b=e.target.closest("button");if(!b)return;
if(b.dataset.action==="close"){close();return}
if(b.dataset.action==="home"){renderHome();return}
if(b.dataset.action==="start"){start();return}
if(b.dataset.level){level=b.dataset.level;renderHome();return}
if(b.dataset.lesson!==undefined){const i=Number(b.dataset.lesson);if(!b.disabled)intro(i);return}
if(b.dataset.speak){speak(b.dataset.speak)}
}
function init(){
const shell=document.querySelector(".shell");if(!shell)return;
const section=document.createElement("section");section.className="a1a2-entry";section.innerHTML='<div><span class="a1a2-entry-tag">NEW COURSE</span><h2>دروس A1 وA2 المصوّرة</h2><p>15 درساً • 90 كلمة • صور ونطق وتمارين متنوعة</p></div><button type="button" class="a1a2-open" id="a1a2-open">افتح المسار ←</button>';
const heading=document.getElementById("section-heading");shell.insertBefore(section,heading);
document.getElementById("a1a2-open").addEventListener("click",open);
document.body.addEventListener("click",e=>{if(e.target.closest("#a1a2-dialog"))handle(e)});
}
if(document.readyState==="loading")document.addEventListener("DOMContentLoaded",init);else init();
})();
