<%--
  Created by IntelliJ IDEA.
  User: db2
  Date: 15/03/15
  Time: 03:14 PM
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Views/menu/css/normalize.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Views/menu/css/style.css">
<link href='http://fonts.googleapis.com/css?family=PT+Sans:400,700' rel='stylesheet' type='text/css'>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script>
    $(function() {
        var pull 		= $('#pull');
        menu 		= $('nav ul');
        menuHeight	= menu.height();

        $(pull).on('click', function(e) {
            e.preventDefault();
            menu.slideToggle();
        });

        $(window).resize(function(){
            var w = $(window).width();
            if(w > 320 && menu.is(':hidden')) {
                menu.removeAttr('style');
            }
        });
    });
</script>
