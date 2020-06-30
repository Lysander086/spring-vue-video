const Toast = Swal.mixin({
  toast: true,
  position: 'top',
  showConfirmButton: false,
  timer: 1500,
  timerProgressBar: true,
  onOpen: (toast) => {
    toast.addEventListener('mouseenter', Swal.stopTimer);
    toast.addEventListener('mouseleave', Swal.resumeTimer)
  }
});

myToast = {
  success: function (msg) {
    Toast.fire({
      icon: 'success',
      title: msg
    });
  },
  error: function (msg) {
    console.info(Toast)
    Toast.fire({
      icon: 'error',
      title: msg
    });
  },
  warning: function (msg) {
    console.info(Toast)
    Toast.fire({
      icon: 'warning',
      title: msg
    });
  }
};