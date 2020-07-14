# OrderService
This Microservice is resposnible to Create Order and Retrieve existinfg Orders
#Preethi
#Laxman

Request and Response:

{
	"id": "f58df4e8-8412-76ee-3cd9-2eba95a21d21",
	"name": "orderManagement",
	"description": "",
	"order": [
		"d01945a9-e4c5-6d6d-81a0-77fb0ec2e570",
		"8909d4cb-9540-a90a-a84b-50f3a8c74fe3"
	],
	"folders": [],
	"folders_order": [],
	"timestamp": 1593092192797,
	"owner": "2579253",
	"public": false,
	"requests": [
		{
			"id": "8909d4cb-9540-a90a-a84b-50f3a8c74fe3",
			"headers": "",
			"headerData": [],
			"url": "http://localhost:8081/OrderService/getOrders/1",
			"queryParams": [],
			"pathVariables": {},
			"pathVariableData": [],
			"preRequestScript": null,
			"method": "GET",
			"collectionId": "f58df4e8-8412-76ee-3cd9-2eba95a21d21",
			"data": null,
			"dataMode": "params",
			"name": "http://localhost:8081/OrderService/getOrders/1",
			"description": "",
			"descriptionFormat": "html",
			"time": 1593092209414,
			"version": 2,
			"responses": [],
			"tests": null,
			"currentHelper": "normal",
			"helperAttributes": {}
		},
		{
			"id": "d01945a9-e4c5-6d6d-81a0-77fb0ec2e570",
			"headers": "Content-Type: application/json\n",
			"headerData": [
				{
					"key": "Content-Type",
					"value": "application/json",
					"description": "",
					"enabled": true
				}
			],
			"url": "http://localhost:8081/OrderService/createNewOrder",
			"queryParams": [],
			"pathVariables": {},
			"pathVariableData": [],
			"preRequestScript": null,
			"method": "POST",
			"collectionId": "f58df4e8-8412-76ee-3cd9-2eba95a21d21",
			"data": [],
			"dataMode": "raw",
			"name": "http://localhost:8081/OrderService/createNewOrder",
			"description": "",
			"descriptionFormat": "html",
			"time": 1593092197373,
			"version": 2,
			"responses": [],
			"tests": null,
			"currentHelper": "normal",
			"helperAttributes": {},
			"rawModeData": "{\n\t\"customerName\":\"Laxman\",\n\t\"shippingAddress\":\"hyderabad\",\n\t\"total\":1234.5,\n\t\"orderItems\":[{\n\t\t\"productCode\":\"1234\",\n\t\t\"productName\":\"Lenovolaptop\",\n\t\t\"quantity\":2},\n\t\t{\n\t\t\"productCode\":\"12345\",\n\t\t\"productName\":\"DellLaptop\",\n\t\t\"quantity\":2}\n\t\t]\n}"
		}
	]
}
