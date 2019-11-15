window.onscroll = function() { growShrinkLogo(); }
var logo = null;
var normalSize = true;

function growShrinkLogo() {
	if( logo == null ) {
		logo = document.getElementById("logo");
	}
	var scroll = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop || 0;
	
	if( normalSize && scroll > 100 ) {
		logo.style.width = '50%';
		normalSize = false;
	}
	if( !normalSize && scroll < 25 ) {
		logo.style.width = '100%';
		normalSize = true;
	}
}