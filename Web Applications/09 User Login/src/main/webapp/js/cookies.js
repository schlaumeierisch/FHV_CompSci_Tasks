// browsers have problems with dates after 2038-01-19 04:14:07
document.cookie = `lastView=${window.location.pathname};path=/;expires=Tue, 19 Jan 2038 04:14:07 GMT;`;