/**
 * Created by usuario on 23/03/2015.
 */

$(document).ready(function() {
    $("input").change(
        function(){
            $(this).css({'background-color' : '#F0F086'});
        });

    $("textarea").change(
        function(){
            $(this).css({'background-color' : '#F0F086'});
        });

    $("radiobutton").change(
        function(){
            $(this).css({'background-color' : '#F0F086'});
        });

    $("label").change(
        function(){
            $(this).css({'background-color' : '#F0F086'});
        });

    $('#nid').numeric();
    $('#folio').numeric();
    $('#Nid').numeric();
    $('#avanceFisico').numeric({integerPlaces:3});
    $('#importeInversion').numeric({ decimalPlaces: 2 });
    $('#Longitud').numeric({ decimalPlaces: 6 });


    $(".numeric").numeric();
    $(".integer").numeric(false, function() { alert("Integers only"); this.value = ""; this.focus(); });
    $(".positive").numeric({ negative: false }, function() { alert("No negative values"); this.value = ""; this.focus(); });
    $(".positive-integer").numeric({ decimal: false, negative: false }, function() { alert("Positive integers only"); this.value = ""; this.focus(); });

    $("#remove").click(
        function(e)
        {
            e.preventDefault();
            $(".numeric,.integer,.positive,.positive-integer,.decimal-2-places").removeNumeric();
        }
    );


});