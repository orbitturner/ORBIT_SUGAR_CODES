<!DOCTYPE html>
<html>

<head>

<title> Animated Web page title •&nbsp;</title>

<script type="text/javascript">

var titleText = document.title;

function titleMarquee() {

 titleText = titleText.substring(1, titleText.length) + titleText.substring(0, 1);
 document.title = titleText;
 setTimeout("titleMarquee()", 450);
 }

</script>

</head>

<body onload="titleMarquee()">

<h1>Animated/Scrolling Web page Title</h1>

<p>Have a look at the Page title. Its scrolling ....</p>

</body>
</html>