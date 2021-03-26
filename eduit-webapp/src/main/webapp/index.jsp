<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<html>

	<header>
		<title>EducactionIt - JSWSEB</title>
	</header>
	<body>
		<h1>Clase11 - JSWEB</h1>
	</body>
	
	<!-- 
		quiero mostrar los valores del 
		1 - 10		  
	-->
		
	<!-- contenido estático -->
	<h3>Bloque estático</h3>
	<ul>
		<li>1</li>
 		<li>2</li>
 		<li>3</li>
 		<li>4</li>
 		<li>5</li>
 		<li>6</li>
 		<li>7</li>
 		<li>8</li>
 		<li>9</li>
 		<li>10</li>
	</ul>
	
	<h3>Bloque dinámico</h3>
	<!-- contenido dinámico -->
	<ul>
		<%
			//codigo java
			int valores = 10;
			for(int i=1; i<=valores;i++) {
				out.print("<li>"+i+"</li>");
			}
		%>
	</ul>
	
	<%
		List<String> paises = new ArrayList<>();
		paises.add("Argentina");
		paises.add("Paraguay");
		paises.add("Brasil");		
	%>
	
	<select>
	<%
		for(String pais : paises) {
			out.print("<option>"+pais+"</option>");
		}
	%>
	</select>
	
	<a href="<%=request.getContextPath()%>/login.jsp">Ir Login</a>
</html>