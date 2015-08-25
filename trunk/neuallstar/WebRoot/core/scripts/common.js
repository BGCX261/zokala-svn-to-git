function nextstep(nowstep){ 
	document.getElementById("step_"+nowstep).style.display="none"; 
	document.getElementById("step_"+(nowstep+1)).style.display=""; 
}
function laststep(nowstep){
	document.getElementById("step_"+nowstep).style.display="none";
	document.getElementById("step_"+(nowstep-1)).style.display="";
}
function hide_dis(id) {
	document.getElementById(id).style.display = (document.getElementById(id).style.display == "none") ? "" : "none";
}