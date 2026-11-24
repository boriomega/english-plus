(()=> {
"use strict";
const KEY="ep-placement-v1";
const banks={
A1:[
["What is the meaning of “apple”? ",["تفاحة","باب","كتاب","نافذة"],0],
["She ___ happy.",["are","is","am","be"],1],
["I ___ water every day.",["drink","drinks","drinking","drank"],0],
["What is the opposite of “big”?",["small","long","fast","new"],0],
["They ___ at home now.",["is","am","are","be"],2]],
A2:[
["Yesterday, we ___ to the market.",["go","went","gone","going"],1],
["There isn't ___ milk in the fridge.",["some","many","any","few"],2],
["This book is ___ than that one.",["interesting","more interesting","most interesting","the interesting"],1],
["She has lived here ___ 2020.",["for","since","during","from"],1],
["If it rains, we ___ at home.",["stay","stayed","will stay","would stayed"],2]],
B1:[
["If I ___ more time, I would travel.",["have","had","will have","am having"],1],
["The meeting was ___ because the manager was ill.",["called off","taken up","put on","looked after"],0],
["Despite ___ tired, he continued working.",["be","being","was","to be"],1],
["She asked me where I ___.",["live","am living","lived","will live"],2],
["The word “reluctant” means:",["unwilling","excited","certain","careless"],0]],
B2:[
["Had I known, I ___ you earlier.",["would call","called","would have called","had called"],2],
["The proposal was rejected on the ___ that it was impractical.",["grounds","floors","reasons of","bases"],0],
["Rarely ___ such a well-researched report.",["we see","do we see","we do see","see we"],1],
["Her argument was persuasive, ___ several flaws.",["although","despite","whereas","because"],1],
["“To mitigate” most nearly means:",["to make less severe","to make more complex","to postpone indefinitely","to prove incorrect"],0]]
};
const levels=["A1","A2","B1","B2"];
let chosen="A1",index=0,score=0;
const el=(tag,attrs={},txt="")=>{const n=document.createElement(tag);Object.entries(attrs).forEach(([k,v])=>n.setAttribute(k,v));if(txt)n.textContent=txt;return n};
const saved=()=>{try{return JSON.parse(localStorage.getItem(KEY)||"null")}catch{return null}};
const save=v=>localStorage.setItem(KEY,JSON.stringify(v));
function panel(){let p=document.getElementById("placement-panel");if(!p){p=el("section",{id:"placement-panel","aria-live":"polite"});document.body.append(p)}return p}
function hideApp(v){document.querySelector(".topbar")?.classList.toggle("placement-muted",v);document.querySelector(".shell")?.classList.toggle("placement-muted",v)}
function btn(label,fn,cls="placement-btn"){const b=el("button",{type:"button",class:cls},label);b.addEventListener("click",fn);return b}
function intro(){hideApp(true);const p=panel();p.innerHTML="";const c=el("div",{class:"placement-card"});c.append(el("div",{class:"placement-mark"},"E+"),el("p",{class:"placement-kicker"},"ENGLISH PLUS"),el("h1",{},"اختر مستواك"),el("p",{class:"placement-copy"},"اختر المستوى الذي تظن أنه يناسبك. سنبدأ باختبار خاص بهذا المستوى للتأكد من اختيارك."));const grid=el("div",{class:"placement-levels"});levels.forEach(l=>{const b=btn(l,()=>{chosen=l;index=0;score=0;question()},"placement-level");grid.append(b)});c.append(grid,el("p",{class:"placement-note"},"إذا لم تجتز الاختبار، سنقترح عليك المستوى السابق حتى تتعلم بثقة."));p.append(c)}
function question(){const p=panel();p.innerHTML="";const q=banks[chosen][index],c=el("div",{class:"placement-card"});c.append(el("div",{class:"placement-topline"},"اختبار المستوى "+chosen),el("div",{class:"placement-progress"}));const bar=el("span");bar.style.width=(index/5*100)+"%";c.querySelector(".placement-progress").append(bar);c.append(el("p",{class:"placement-count"},"السؤال "+(index+1)+" من 5"),el("h2",{},q[0]));const opts=el("div",{class:"placement-options"});q[1].forEach((v,i)=>opts.append(btn(v,()=>{if(i===q[2])score++;index++;index<5?question():result()},"placement-option")));c.append(opts);p.append(c)}
function result(){const passed=score>=4;const ix=levels.indexOf(chosen);const suggested=passed?chosen:levels[Math.max(0,ix-1)];const recommended="A1";const record={level:recommended,selectedLevel:chosen,suggestedLevel:suggested,score,total:5,passed,courseAvailable:chosen==="A1",completedAt:new Date().toISOString()};save(record);hideApp(false);const p=panel();p.innerHTML="";const c=el("div",{class:"placement-card placement-result"});c.append(el("div",{class:"placement-mark"},passed?"✓":"↘"),el("p",{class:"placement-kicker"},"نتيجة الاختبار"),el("h1",{},passed?(chosen==="A1"?"اجتزت اختبار A1":"نتيجة الاختبار: "+chosen):"ابدأ بمسار A1"),el("p",{class:"placement-copy"},"نتيجتك: "+score+" من 5."));
if(passed&&chosen==="A1")c.append(el("p",{class:"placement-note"},"أحسنت! اجتزت اختبار A1 ويمكنك بدء الدروس المتاحة."));
else if(passed)c.append(el("p",{class:"placement-note"},"نتيجتك تشير إلى مستوى "+chosen+". مسار هذا المستوى لم يُنشر بعد؛ يمكنك البدء مؤقتاً بمسار A1 المتاح دون أن نعرض لك دروساً غير مكتملة."));
else c.append(el("p",{class:"placement-note"},"لم تصل إلى درجة الاجتياز المطلوبة (4 من 5). ننصحك بالبدء بمسار A1 المتاح حالياً ثم إعادة الاختبار لاحقاً."));
c.append(btn("الانتقال إلى التطبيق",()=>{p.remove();dashboardStatus(record);document.getElementById("placement-retake")?.classList.remove("hidden")}),btn("اختيار مستوى آخر",intro,"placement-skip"));p.append(c)}
function dashboardStatus(r){const shell=document.querySelector(".shell");if(!shell)return;document.getElementById("placement-status")?.remove();const box=el("div",{id:"placement-status",class:"placement-status"});box.textContent="المستوى الذي اخترته: "+r.selectedLevel+" — المسار المتاح حالياً: "+r.level+" ("+r.score+"/5).";shell.insertBefore(box,shell.querySelector(".progress-card"))}
function init(){const actions=document.querySelector(".top-actions");if(actions&&!document.getElementById("placement-retake")){const b=btn("تغيير المستوى",intro,"placement-retake hidden");b.id="placement-retake";actions.append(b)}const r=saved();if(!r)intro();else{document.getElementById("placement-retake")?.classList.remove("hidden");dashboardStatus(r)}}
if(document.readyState==="loading")document.addEventListener("DOMContentLoaded",init);else init();
})();