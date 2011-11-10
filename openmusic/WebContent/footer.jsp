<div id="rodape"></div>
<!--RODAPÉ-->

<script type="text/javascript">
	$(function() {

		//multiple elemenets
		$('.scroll_musicas').slimScroll({
			height : '195px',
			width : '317px'
		});
		
		$('.scroll_amigos').slimScroll({
			height : '195px',
			width : '317px'
		});

	});

	$(document).ready(function() {

		$('.box').limit('210', '.contador');

	});
</script>
</body>
</html>