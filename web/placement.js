(()=> {
"use strict";
const KEY="ep-placement-v1";
const questions=[
{q:"What is the meaning of “apple”?",a:["تفاحة","باب","كتاب","نافذة"],c:0},
{q:"Choose the correct sentence.",a:["She are happy.","She is happy.","She am happy.","She be happy."],c:1},
{q:"“I get up at seven.” What does it mean?",a:["أذهب للنوم في السابعة","أستيقظ في السابعة","أصل في السابعة","أدرس سبع ساعات"],c:1},
{q:"We ___ to school every day.",a:["go","goes","going","gone"],c:0},
{q:"Choose the best response: “Would you like some tea?”",a:["Yes, please.","I am tea.","At Monday.","It is mine."],c:0},
{q:"“The train was delayed because of heavy rain.” Why was it late?",a:["A technical problem","Heavy rain","A busy station","A lost ticket"],c:1},
{q:"If I ___ more time, I would learn another language.",a:["have","had","will have","am having"],c:1},
{q:"Which word is closest in meaning to “reliable”?",a:["Trustworthy","Expensive","Careless","Temporary"],c:0},
{q:"Despite ___ tired, she finished the project.",a:["be","being","was","to be"],c:1},
{q:"The report, ___ was published yesterday, contains new findings.",a:["who","where","which","whose"],c:2},
{q:"Had they known about the traffic, they ___ earlier.",a:["leave","will leave","would have left","had leave"],c:2},
{q:"What does “The proposal was rejected on the grounds that it was impractical” mean?",a:["قُبل لأنه سهل التنفيذ","رُفض لأنه غير عملي","تأجل بسبب نقص المال","عُدّل بعد النقاش"],c:1}
];
const levels=["A1","A2","B1","B2"];
let index=0,score=0,answers=[];
const el=(tag,attrs={},text="")=>{const n=document.createElement(tag);Object.entries(attrs).forEach(([k,v])=>n.setAttribute(k,v));if(text)n.textContent=text;return n};
function saved(){try{return JSON.parse(localStorage.getItem(KEY)||"null")}catch{return null}}
function save(v){localStorage.setItem(KEY,JSON.stringify(v))}
function panel(){let p=document.getElementById("placement-panel");if(!p){p=el("section",{id:"placement-panel","aria-live":"polite"});document.body.append(p)}return p}
function shellHidden(v){document.querySelector(".topbar").classList.toggle("placement-muted",v);document.querySelector(".shell").classList.toggle("placement-muted",v)}
function button(label,fn,cls="placement-btn"){const b=el("button",{type:"button",class:cls},label);b.addEventListener("click",fn);return b}
function intro(){shellHidden(true);const p=panel();p.innerHTML="";const card=el("div",{class:"placement-card"});card.append(el("div",{class:"placement-mark"},"E+"),el("p",{class:"placement-kicker"},"ENGLISH PLUS"),el("h1",{},"لنبدأ من مستواك الحقيقي"),el("p",{class:"placement-copy"},"أجب عن 12 سؤالاً متدرجاً في المفردات والقواعد والفهم. اختر الإجابة الأنسب؛ يمكنك إعادة الاختبار لاحقاً."),el("div",{class:"placement-facts"},"12 سؤالاً  •  نحو 3–5 دقائق  •  دون مؤقت"),button("ابدأ اختبار تحديد المستوى",()=>{index=0;score=0;answers=[];question()}),button("تخطَّ الاختبار وابدأ من A1",()=>finish("A1",true),"placement-skip"));p.append(card)}
function question(){const p=panel();p.innerHTML="";const q=questions[index],card=el("div",{class:"placement-card"});card.append(el("div",{class:"placement-topline"},"اختبار تحديد المستوى"),el("div",{class:"placement-progress"}));const bar=el("span");bar.style.width=(index/questions.length*100)+"%";card.querySelector(".placement-progress").append(bar);card.append(el("p",{class:"placement-count"},"السؤال "+(index+1)+" من "+questions.length),el("h2",{},q.q));const opts=el("div",{class:"placement-options"});q.a.forEach((v,i)=>{const b=button(v,()=>{answers[index]=i;if(i===q.c)score++;index++;index<questions.length?question():result()},"placement-option");opts.append(b)});card.append(opts);p.append(card)}
function result(){let n=score<=3?0:score<=6?1:score<=9?2:3;finish(levels[n],false)}
function finish(level,skipped){const record={level,score:skipped?0:score,total:questions.length,skipped,completedAt:new Date().toISOString()};save(record);shellHidden(false);const p=panel();p.innerHTML="";const card=el("div",{class:"placement-card placement-result"});card.append(el("div",{class:"placement-mark"},"✓"),el("p",{class:"placement-kicker"},"نتيجة تحديد المستوى"),el("h1",{},skipped?"اخترت البداية من A1":"مستواك المقترح هو "+level),el("p",{class:"placement-copy"},skipped?"يمكنك التقدم خطوة بخطوة وإعادة الاختبار في أي وقت.":"أجبت إجابة صحيحة عن "+score+" من "+questions.length+" أسئلة."));
if(!skipped&&level!=="A1")card.append(el("p",{class:"placement-note"},"ملاحظة: دروس A2 وB1 وB2 قيد الإعداد حالياً. لن نفتح مساراً فارغاً؛ ستبقى دروس A1 المتاحة ظاهرة إلى أن يكتمل محتوى مستواك."));
else card.append(el("p",{class:"placement-note"},"يمكنك الآن البدء بالدروس المتاحة، وستُفتح الدروس بالتتابع بعد اجتياز السابق."));
card.append(button("الانتقال إلى التطبيق",()=>{p.remove();document.getElementById("placement-retake")?.classList.remove("hidden");dashboardStatus(record)}),button("إعادة الاختبار",()=>{index=0;score=0;answers=[];question()},"placement-skip"));p.append(card)}
function dashboardStatus(record){if(!record)return;const shell=document.querySelector(".shell");if(!shell||document.getElementById("placement-status"))return;const box=el("div",{id:"placement-status",class:"placement-status"});box.textContent=record.skipped?"مسارك الحالي: A1 — يمكنك إعادة اختبار تحديد المستوى.":record.level==="A1"?"نتيجة تحديد المستوى: A1 — ابدأ بالدروس المتاحة.":"نتيجتك المقترحة: "+record.level+" — محتوى هذا المستوى قيد الإعداد؛ الدروس المتاحة حالياً هي A1.";shell.insertBefore(box,shell.querySelector(".progress-card"));}
function init(){const actions=document.querySelector(".top-actions");if(actions&&!document.getElementById("placement-retake")){const b=button("تحديد المستوى",()=>intro(),"placement-retake hidden");b.id="placement-retake";actions.append(b)}const record=saved();if(!record)intro();else{document.getElementById("placement-retake")?.classList.remove("hidden");dashboardStatus(record)}}
if(document.readyState==="loading")document.addEventListener("DOMContentLoaded",init);else init();
})();