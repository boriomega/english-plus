(()=>{"use strict";
const $=id=>document.getElementById(id);
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
 if(dialog&&toggle&&check){
  check.checked=true;check.disabled=true;
  toggle.addEventListener("click",()=>dialog.showModal());
  close?.addEventListener("click",()=>dialog.close());
 }
 $("lesson-list")?.addEventListener("click",appleBite,true);
}
if(document.readyState==="loading")document.addEventListener("DOMContentLoaded",init);else init();
})();