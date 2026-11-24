(()=>{"use strict";
const KEY="ep-auto-next";
const $=id=>document.getElementById(id);
let timer=null;
function clearAdvance(){if(timer!==null){clearTimeout(timer);timer=null}}
function scheduleAdvance(){
 clearAdvance();
 const next=$("next");
 if(localStorage.getItem(KEY)==="false"||!next||next.disabled)return;
 timer=setTimeout(()=>{timer=null;const current=$("next");if(localStorage.getItem(KEY)!=="false"&&current&&!current.disabled)current.click()},5000);
}
function appleBite(event){
 const button=event.target.closest("#lesson-list .path-node[data-open]");
 if(!button||!button.querySelector('use[href$="#apple"]'))return;
 const lesson=Number(button.dataset.open);
 if(!Number.isInteger(lesson))return;
 event.preventDefault();event.stopImmediatePropagation();
 button.classList.remove("biting");void button.offsetWidth;button.classList.add("biting");
 setTimeout(()=>{button.classList.remove("biting");if(typeof window.openLesson==="function")window.openLesson(lesson)},460);
}
function init(){
 const dialog=$("settings-dialog"),toggle=$("open-settings"),close=$("close-settings"),check=$("auto-next");
 if(!dialog||!toggle||!check)return;
 check.checked=localStorage.getItem(KEY)!=="false";
 toggle.addEventListener("click",()=>dialog.showModal());
 close?.addEventListener("click",()=>dialog.close());
 check.addEventListener("change",()=>{localStorage.setItem(KEY,String(check.checked));if(!check.checked)clearAdvance()});
 document.addEventListener("click",e=>{if(e.target.closest("#next"))clearAdvance()},true);
 const content=$("lesson-content");
 $("lesson-list")?.addEventListener("click",appleBite,true);
 if(content){
  const observer=new MutationObserver(()=>{
   const next=$("next");
   if(next&&!next.disabled)scheduleAdvance();
   else clearAdvance();
  });
  observer.observe(content,{subtree:true,childList:true,attributes:true,attributeFilter:["disabled"]});
 }
}
if(document.readyState==="loading")document.addEventListener("DOMContentLoaded",init);else init();
})();