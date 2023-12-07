<%@page import="java.util.Map"%>
<%Map<String, String> planInfoCount = (Map<String, String>) request.getAttribute("planInfoCount"); %>
<script>
	//Set new default font family and font color to mimic Bootstrap's default styling
			Chart.defaults.global.defaultFontFamily = 'Nunito',
			'-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#858796';

	// Pie Chart Example
	var ctx = document.getElementById("myPieChart_Plan");
	var myPieChart = new Chart(ctx, {
		type : 'doughnut',
		data : {
			labels : [ "Non-subscription", "Gold", "Silver", "Bronze"],
			datasets : [ {
				data : [ 
					  <%=planInfoCount.get("1")%>
					, <%=planInfoCount.get("2")%>
					, <%=planInfoCount.get("3")%>
					, <%=planInfoCount.get("4")%>
					],
				backgroundColor : [ '#4e73df','#f6c23e','#36b9cc','#1cc88a'],
				hoverBackgroundColor : [ '#2e59d9','#fd7e14' , '#2c9faf','#17a673' ],
				hoverBorderColor : "rgba(234, 236, 244, 1)",
			} ],
		},
		options : {
			maintainAspectRatio : false,
			tooltips : {
				backgroundColor : "rgb(255,255,255)",
				bodyFontColor : "#858796",
				borderColor : '#dddfeb',
				borderWidth : 1,
				xPadding : 15,
				yPadding : 15,
				displayColors : false,
				caretPadding : 10,
			},
			legend : {
				display : false
			},
			cutoutPercentage : 80,
		},
	});
</script>
