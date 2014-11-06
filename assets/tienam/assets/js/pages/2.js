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
	
	$('#Ref').addClass('visible');
	$('#Study1').addClass('visible');
	
    $('#Scene2_0').addClass('visible');
	$('#Scene2_1').addClass('visible');
	$('#Scene2_2').addClass('visible');
    $('#Scene2_3').addClass('visible');
	

    
    $('#PopArea1').bind('touchend', function(event) {      
       $('#slide2_popup1').addClass('visible'); 
       $('#background_transparent').addClass('visible');
       $('#background_Frame1').addClass('visible');
       return false;
     });
     $('#slide2_popup1').bind('touchend', function(event) {  
       $('#background_transparent').click();
      });
        
     $('#background_transparent').bind('touchend', function(event) {  
         document.getElementById('slide2_popup1').className='reset_slide2_popup1';
         document.getElementById('background_transparent').className='resetBackground_Transparent';
         document.getElementById('background_Frame1').className='reset_background_Frame1';
      });
      $('#background_Frame1').bind('touchend', function(event) {  
        $('#background_transparent').click();
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
            window.location = "1.html";
        }
        if ( dL > 40 && touchLength == 1 && moveFlag == 1){
            window.location = "3.html";
        }
    }, false);
});