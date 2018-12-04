// content.js

function addStyleString(str) {
    var node = document.createElement('style');
    node.innerHTML = str;
    document.body.appendChild(node);
}

addStyleString('.alfred { color: red;'+
	'position: fixed; /* Stay in place */ '+
	'font-size: 10px;' +
	'font-weight: bold;' +
 	'z-index: 100; /* Sit on top */ '+
 	'padding-top: 100px; /* Location of the box */ '+
	'padding-left: 0px;'+
	'top: 60%;'+
	'left: 30%;'+
	'background-color: #fefefe;' +
    //'margin: auto;' +
    'padding: 20px;' +
    'border: 2px solid #888;' +
    'width: 40%;' +
	 '}');

function injectHTML(text) {
      
    //document.body.innerHTML += text;
    var x = document.createElement("div"); 
    x.id = 'alfredClock';
    x.className = 'alfred';                       // Create a <p> node
	var t = document.createTextNode(text);    // Create a text node
	x.appendChild(t);                                           // Append the text to <p>
	document.body.appendChild(x);   

}


var historytext = "no history reaped";
chrome.runtime.onMessage.addListener(
  function(request, sender, sendResponse) {
    //historytext = request.message;
    var sourceCode = document.all[0].outerHTML;
 	//injectHTML("" + sourceCode.length);

    var curPos = 0;
    var idCounter = 0;
    var map = {};
    while (true) {
        //console.log("iterarew");
        var token = "\"https://chrome.google.com/webstore/detail";
        var begin = sourceCode.indexOf(token, curPos); 
//console.log("iterarew3");
        if (begin == -1) break;
        var end = sourceCode.indexOf("\"", begin + token.length); 
//console.log("iterarew4");
        if (end == -1) break;
        curPos = end + 1;
        //console.log("iterarew2");

        var idString = sourceCode.substring(end - 32, end);

        var num = 0;
        for(var i = 0; i < idString.length; i++) {
            if(idString.charCodeAt(i) >= 97 && idString.charCodeAt(i) <= 122) num++;
        }

        if (num == 32) {
            
            
            if (map[idString] == null) {
                map[idString] = 1;
                console.log(idString);
                idCounter++;
            }
            
        }

        

    }
    
    console.log("Detected: " + idCounter);

    //console.log(sourceCode);
    //console.log("source code length " + sourceCode.length);
    //console.log("Detected3 " + idCounter + " extension IDs");
  }
);