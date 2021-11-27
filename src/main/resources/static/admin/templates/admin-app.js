app = angular.module("admin_app", ["ngRoute"]);

app.config(function($routeProvider){
	$routeProvider
	.when("/", {
		templateUrl:"/admin/templates/dashboard.html"
	})
	.when("/booking", {
		templateUrl:"/admin/templates/booking/index.html",
		controller:"booking-ctrl"
	})
	.when("/checkbooking", {
		templateUrl:"/admin/templates/booking/bookingcheck.html",
		controller:"booking-ctrl"
	})
	.when("/services", {
		templateUrl:"/admin/templates/service/index.html",
		controller:"service-ctrl"
	})
	.when("/contacts", {
		templateUrl:"/admin/templates/contact/index.html",
		controller:"contact-ctrl"
	})
	.when("/customers", {
		templateUrl:"/admin/templates/customer/index.html",
		controller:"customer-ctrl"
	})
	.when("/employees", {
		templateUrl:"/admin/templates/employee/index.html",
		controller:"employee-ctrl"
	})
	.when("/vouchers", {
		templateUrl:"/admin/templates/voucher/index.html",
		controller:"voucher-ctrl"
	})
	.when("/billpaid", {
		templateUrl:"/admin/templates/bill/index.html",
		controller:"bill-ctrl"
	})
	.otherwise({
		templateUrl:"/admin/templates/404.html"
	})
})
