<!DOCTYPE html>
<%
	String contextPath = request.getContextPath();	
%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>E-Shope</title>
<link rel="stylesheet" href='<%=contextPath+"/static/css/app.css"%>'>
<link rel="stylesheet" href='<%=contextPath+"/static/css/bootstrap.min.css"%>'>
<script src='<%=contextPath+"/static/js/jquery-1.10.2.min.js"%>'></script>
<script src='<%=contextPath+"/static/js/vue.min.js"%>'></script>
<script src='<%=contextPath+"/static/js/app.js"%>'></script>
</head>
<body>
	<div id="nav_view" class="container-fluid">
	 <br/>

				<img alt="phone" src='<%=contextPath+"/static/images/logo.png"%>'>
	 </div>
	    <br/>
			<table border='10px' class='col-sm-8'>
			<thead>
				<tr>
					<td>Item</td>
					<td>Description</td>
					<td>Price</td>
					<td>Quantity</td>
					<td></td>
					<td></td>
				</tr>
			</thead>
			<tbody>
				<tr v-for='item in allItems'>
					<td><img alt="phone" src='<%=contextPath+"/static/images/pic1.png"%>'></td>
					<td>
						{{ item.name }} <br/>
						<strong>Offers:</strong>
						<span v-if="item.offers.length > 0">
							<li v-for="offer in item.offers">
								{{offer.count}} items for {{offer.price}}$
							</li>
						</span>
						<span v-else>No Offers</span>
					</td>
					<td>{{ item.price }}</td>
					<td><input v-model="item.quantity" type="text" /></td>
					<td><button v-on:click="calculatePrice(item)">Check Out</button></td>
					<td>Total = {{totalAmount}}</td>
				</tr>
			</tbody>
		</table>


		<!--
		<span v-for='item in allItems'>
				<img alt="phone" src='<%=contextPath+"/static/images/pic1.png"%>'>
				<div>Product : {{ item.name }}</div>
				<div>Price : {{ item.price }} $</div>
				<strong>Offers:</strong>
				<span v-if="item.offers.length > 0">
					<li v-for="offer in item.offers">
						{{offer.count}} items for {{offer.price}}$
					</li>
				</span>
				<div v-else>No Offers</div>
				<div> 
					Quantity: <input v-model="item.quantity" type="text" />
					<button v-on:click="calculatePrice(item)">Check Out</button>
				</div> 
				<div>Total = {{totalAmount}}</div>
		</span>
-->
	</div>
<div> All Copy Reserved 2018</div>
</body>
</html>