function openWindow(path) {
   let img = new Image();
   img.src = path;

   img.onload = function () {
      // adding 15px/40px so there are no scrollbars visible
      let newWindow = window.open("", "_blank", `width=${img.width + 15}, height=${img.height + 40}`);
      newWindow.document.write("<img src=" + path + "><br>");
      newWindow.document.write("<button onclick='self.close()'>Close</button>")
   };
}
