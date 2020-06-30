const oriToast = Swal.mixin({
  toast: true,
  position: 'top',
  showConfirmButton: false,
  timer: 2000,
  timerProgressBar: true,
  onOpen: (toast) => {
    toast.addEventListener('mouseenter', Swal.stopTimer);
    toast.addEventListener('mouseleave', Swal.resumeTimer)
  }
});

Toast = {
  success: function (msg) {
    oriToast.fire({
      icon: 'success',
      title: msg
    });
  },
  error: function (msg) {
    oriToast.fire({
      icon: 'error',
      title: msg
    });
  },
  warning: function (msg) {
    console.log(oriToast)
    oriToast.fire({
      icon: 'warning',
      title: msg
    });
  }
};