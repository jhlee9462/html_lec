function sum() {
	let xhr = new XMLHttpRequest();
	let url = "sumTest.jsp?" + getParameter();
	
	xhr.onreadystatechange = function () {
		if (xhr.status === 200 && xhr.readyState === 4) {
			document.getElementById("display").innerHTML = xhr.responseText;
		}
	}
	
	xhr.open("get", url, true);
	xhr.send(null);
}

function getParameter() {
	let base = document.getElementById("base").value;
	let height = document.getElementById("height").value;
	return "base=" + base + "&height=" + height;
}