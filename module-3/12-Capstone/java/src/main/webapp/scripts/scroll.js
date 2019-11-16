window.onscroll = function() { growShrinkLogo(); }
var header = null;
var heading = null;
var lastScroll = 0;

function growShrinkLogo() {
	if( header == null ) {
		header = document.getElementsByTagName("header")[0];
	}
	if( heading == null ) {
		heading = document.getElementsByClassName("park-name")[0];
	}
	var scroll = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop || 0;
	
	if( lastScroll < scroll && scroll > 150 ) {
		addClass(header, "scrolled");
		addClass(heading, "scrolled");
	} else if( lastScroll > scroll && scroll < 45 ) {
		removeClass(header, "scrolled");
		removeClass(heading, "scrolled");
	}
	lastScroll = scroll;
}

function getClasses(element) {
	if( element == null ) return null;
	return element.className.split(" ");
}
function hasClass(element, clazz) {
	var classes = getClasses(element);
	if( classes == null ) return null;
	return classes.includes(clazz);
}
function addClass(element, clazz) {
	if( hasClass(element) === null || hasClass(element, clazz) === true ) return;
	element.className = element.className+" "+clazz;
	element.className = element.className.trim();
}
function removeClass(element, clazz) {
	var classes = getClasses(element);
	if( classes == null ) return;
	for( var index in classes ) {
		if( classes[index] == clazz ) {
			classes.splice(index);
		}
	}
	element.className = classes.join(" ");
}