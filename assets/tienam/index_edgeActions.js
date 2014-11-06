/***********************
* Adobe Edge Animate Composition Actions
*
* Edit this file with caution, being careful to preserve 
* function signatures and comments starting with 'Edge' to maintain the 
* ability to interact with these actions from within Adobe Edge Animate
*
***********************/
(function($, Edge, compId){
var Composition = Edge.Composition, Symbol = Edge.Symbol; // aliases for commonly used Edge classes

   //Edge symbol: 'stage'
   (function(symbolName) {
       
      
      Symbol.bindTriggerAction(compId, symbolName, "Default Timeline", 55, function(sym, e) {
         counter = 0;
         filesDownloaded = 0;
         totalFiles = 1080;
         textObjectID = "";
         rateObjectID = "";
         rate = 0;
         now = 0;
         progressBarObjectID = "";
         for (i = 0; i < document.all.length; i++) {
             if (document.all(i).id.length > 0) {
                 if (document.all(i).id.substring(document.all(i).id.length - 4, document.all(i).id.length) == "Text") {
                     textObjectID = document.all(i).id;
                 }
                 if (document.all(i).id.substring(document.all(i).id.length - 4, document.all(i).id.length) == "rate") {
                     rateObjectID = document.all(i).id;
                 }
                 if (document.all(i).id.substring(document.all(i).id.length - 4, document.all(i).id.length) == "pbar") {
                     progressBarObjectID = document.all(i).id;
                 }
             }
         }
         $("#" + progressBarObjectID).css('clip', 'rect(0px, 0px, 35px, 0px)');
         var cache = window.applicationCache;
         
         cache.addEventListener("cached", function () {
             console.log("All resources for this web app have now been downloaded. You can run this application while not connected to the internet");
             $("#" + textObjectID).html("");
             $("#" + textObjectID).append(document.createTextNode("All resources for this web app have now been downloaded. You can run this application while not connected to the internet"));
             window.open("scene.html", "_self");
         }, false);
         cache.addEventListener("checking", function () {
             console.log("Checking manifest");
             $("#" + textObjectID).html("");
             $("#" + textObjectID).append(document.createTextNode("Checking manifest"));
         }, false);
         cache.addEventListener("downloading", function () {
             console.log("Starting download of cached files");
             $("#" + textObjectID).html("");
             $("#" + textObjectID).append(document.createTextNode("Starting download of cached files"));
         }, false);
         cache.addEventListener("error", function (e) {
             console.log("There was an error in the manifest, downloading cached files or you're offline: " + e);
             $("#" + textObjectID).html("");
             $("#" + textObjectID).append(document.createTextNode("There was an error in the manifest, downloading cached files or you're offline: " + e));
         }, false);
         cache.addEventListener("noupdate", function () {
             console.log("There was no update needed");
             $("#" + textObjectID).html("");
             $("#" + textObjectID).append(document.createTextNode("There was no update needed"));
             window.open("scene.html", "_self");
         }, false);
         
         cache.addEventListener("progress", function (e) {
             console.log("Downloading cached files");
             counter++;
         	 $("#" + textObjectID).html("Downloading cached file : " + e.loaded + " Out of " + e.total + " Files");
         	 rate = e.loaded * (100 / e.total);
         	 now = 325 * (rate / 100);
         	 now = now.toFixed(2);
         	 rate = rate.toFixed(0);
         	 $("#" + rateObjectID).html(rate);
         	 $("#" + progressBarObjectID).css('clip', 'rect(0px, ' + now + 'px, 35px, 0px)');
         }, false);
         
         
         cache.addEventListener("updateready", function () {
             cache.swapCache();
             console.log("Updated cache is ready");
             $("#" + textObjectID).html("");
             $("#" + textObjectID).append(document.createTextNode("Updated cache is ready"));
             window.open("scene.html", "_self");
         }, false);

      });
      //Edge binding end

      Symbol.bindTriggerAction(compId, symbolName, "Default Timeline", 5000, function(sym, e) {
         if (counter == totalFiles || counter == 0) {
             window.open("scene.html", "_self");
         }

      });
      //Edge binding end

   })("stage");
   //Edge symbol end:'stage'

})(jQuery, AdobeEdge, "EDGE-1113726837");