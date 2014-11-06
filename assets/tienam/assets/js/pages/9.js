$(document).ready(function () {     
    
	$('#Menu').bind('touchend', function(event) {  
	    if(menuOpened == false){
           $('#Menu').addClass('visible');
		   $('#Menu1').addClass('visible');
		   $('#Menu2').addClass('visible');
		   $('#Menu3').addClass('visible');
           menuOpened = true ;
		}else{
           document.getElementById('Menu').className='CloseMenu';
		   document.getElementById('Menu1').className='CloseMenu';
		   document.getElementById('Menu2').className='CloseMenu';
		   document.getElementById('Menu3').className='CloseMenu';
		   menuOpened = false ;
        }		
    });
	
	$('#Menu1').bind('touchend', function(event) {            
        window.location = "index-2.html";
    });
    $('#Menu2').bind('touchend', function(event) {            
        window.location = "2.html";
    });
    $('#Menu3').bind('touchend', function(event) {            
        window.location = "9.html";
    });
    $('#Scene_Home').bind('touchend', function(event) {  
        window.location = "index-2.html";
    });
	$('#Scene_Arrow').bind('touchend', function(event) {            
        window.location = "Master.html";
    });

	$('#BG_pixel').addClass('visible');
	$('#Ref').addClass('visible');
	$('#Sat').addClass('visible');
	$('#Study1').addClass('visible');
	
    $('#Scene9_0').addClass('visible');
	$('#Scene9_1').addClass('visible');
	$('#Scene9_2').addClass('visible');
    $('#Scene9_3').addClass('visible');
	$('#Scene9_4').addClass('visible');
	$('#Scene9_5').addClass('visible');
   
    $('#Scene9_1').bind('touchend', function(event) {  
        window.location = "10.html";
    });
	$('#Scene9_2').bind('touchend', function(event) {  
        window.location = "14.html";
    });
	$('#Scene9_3').bind('touchend', function(event) {  
        window.location = "18.html";
    });
	$('#Scene9_4').bind('touchend', function(event) {  
        window.location = "21.html";
    });
	$('#Scene9_5').bind('touchend', function(event) {  
        window.location = "24.html";
    });

	
	
	
	
    document.body.addEventListener('touchstart', function(e) {  //touchstart mousedown
       touchLength = event.touches.length; 
       if (touchLength != 2){
           e.preventDefault();
       }
       moveFlag = 0;
       startX = e.pageX ;
    }, false);

    document.body.addEventListener('touchmove', function(e) { //touchmove mousemove
       moveFlag = 1 ;
       endX = e.pageX ;
    }, false);
    
    document.body.addEventListener('touchend', function(e) { //touchend mouseup
       dR = endX-startX ;
       dL = startX-endX ;
        if ( dR > 40 && touchLength == 1 && moveFlag == 1){
            window.location = "8.html";
        }
        if ( dL > 40 && touchLength == 1 && moveFlag == 1){
            window.location = "10.html";
        }
    }, false);
});