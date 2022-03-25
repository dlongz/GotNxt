/**
 * 
 */

let geocoder;
let map;

function initMap() {
	geocoder = new google.maps.Geocoder();
	codeAddress()
}

function codeAddress() {
	let address = document.getElementById('address').innerHTML;
	geocoder.geocode({ 'address': address }, function(results, status) {
		if (status == 'OK') {
			map = new google.maps.Map(document.getElementById('map'), {
				center: results[0].geometry.location,
				zoom: 16
			});
			let marker = new google.maps.Marker({
				map: map,
				position: results[0].geometry.location
			});
		} else {
			alert('Geocode was not successful for the following reason: ' + status);
		}
	});
}








