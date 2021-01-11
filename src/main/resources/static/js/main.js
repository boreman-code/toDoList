$(function(){

    // Show adding task form
    $('#show-add-task-form').click(function() {
        $('#adding-form').css('display', 'flex');
    });

    // Closing adding task form
    $('#adding-form').click(function(event) {
        if(event.target === this) {
            $(this).css('display', 'none');
        }
    });
});