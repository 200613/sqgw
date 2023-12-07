/*
 * pickadate.js v3.6.3, 2019/04/03
 * By Amsul, http://amsul.ca
 * Hosted on http://amsul.github.io/pickadate.js
 * Licensed under MIT
 */
!function(b){"function"==typeof define&&define.amd?define("picker",["jquery"],b):"object"==typeof exports?module.exports=b(require("jquery")):this.Picker=b(jQuery)}(function(o){function p(d,e,f,g){function j(){return p._.node("div",p._.node("div",p._.node("div",p._.node("div",c.component.nodes(J.open),L.box),L.wrap),L.frame),L.holder,'tabindex="-1"')}function l(){a.data(e,c).addClass(L.input).val(a.data("value")?c.get("select",K.format):d.value).on("focus."+J.id+" click."+J.id,t(function(h){h.preventDefault(),c.open()},100)).on("mousedown",function(){J.handlingOpen=!0;var h=function(){setTimeout(function(){o(document).off("mouseup",h),J.handlingOpen=!1},0)};o(document).on("mouseup",h)}),K.editable||a.on("keydown."+J.id,H),u(d,{haspopup:!0,expanded:!1,readonly:!1,owns:d.id+"_root"})}function n(){u(c.$root[0],"hidden",!0)}function D(){c.$holder.on({keydown:H,"focus.toOpen":G,blur:function(){a.removeClass(L.target)},focusin:function(h){c.$root.removeClass(L.focused),h.stopPropagation()},"mousedown click":function(h){var i=s(h,d);i!=c.$holder[0]&&(h.stopPropagation(),"mousedown"!=h.type||o(i).is("input, select, textarea, button, option")||(h.preventDefault(),c.$holder.eq(0).focus()))}}).on("click","[data-pick], [data-nav], [data-clear], [data-close]",function(){var h=o(this),i=h.data(),k=h.hasClass(L.navDisabled)||h.hasClass(L.disabled),m=x();m=m&&(m.type||m.href?m:null),(k||m&&!o.contains(c.$root[0],m))&&c.$holder.eq(0).focus(),!k&&i.nav?c.set("highlight",c.component.item.highlight,{nav:i.nav}):!k&&"pick" in i?(c.set("select",i.pick),K.closeOnSelect&&c.close(!0)):i.clear?(c.clear(),K.closeOnClear&&c.close(!0)):i.close&&c.close(!0)})}function E(){var h;!0===K.hiddenName?(h=d.name,d.name=""):(h=["string"==typeof K.hiddenPrefix?K.hiddenPrefix:"","string"==typeof K.hiddenSuffix?K.hiddenSuffix:"_submit"],h=h[0]+d.name+h[1]),c._hidden=o('<input type=hidden name="'+h+'"'+(a.data("value")||d.value?' value="'+c.get("select",K.formatSubmit)+'"':"")+">")[0],a.on("change."+J.id,function(){c._hidden.value=d.value?c.get("select",K.formatSubmit):""})}function F(){I&&B?c.$holder.find("."+L.frame).one("transitionend",function(){c.$holder.eq(0).focus()}):setTimeout(function(){c.$holder.eq(0).focus()},0)}function G(h){h.stopPropagation(),a.addClass(L.target),c.$root.addClass(L.focused),c.open()}function H(h){var i=h.keyCode,k=/^(8|46)$/.test(i);if(27==i){return c.close(!0),!1}(32==i||k||!J.open&&c.component.key[i])&&(h.preventDefault(),h.stopPropagation(),k?c.clear().close():c.open())}if(!d){return p}var I=!1,J={id:d.id||"P"+Math.abs(~~(Math.random()*new Date)),handlingOpen:!1},K=f?o.extend(!0,{},f.defaults,g):g||{},L=o.extend({},p.klasses(),K.klass),a=o(d),b=function(){return this.start()},c=b.prototype={constructor:b,$node:a,start:function(){return J&&J.start?c:(J.methods={},J.start=!0,J.open=!1,J.type=d.type,d.autofocus=d==x(),d.readOnly=!K.editable,d.id=d.id||J.id,"text"!=d.type&&(d.type="text"),c.component=new f(c,K),c.$root=o('<div class="'+L.picker+'" id="'+d.id+'_root" />'),n(),c.$holder=o(j()).appendTo(c.$root),D(),K.formatSubmit&&E(),l(),K.containerHidden?o(K.containerHidden).append(c._hidden):a.after(c._hidden),K.container?o(K.container).append(c.$root):a.after(c.$root),c.on({start:c.component.onStart,render:c.component.onRender,stop:c.component.onStop,open:c.component.onOpen,close:c.component.onClose,set:c.component.onSet}).on({start:K.onStart,render:K.onRender,stop:K.onStop,open:K.onOpen,close:K.onClose,set:K.onSet}),I=q(c.$holder[0]),d.autofocus&&c.open(),c.trigger("start").trigger("render"))},render:function(h){return h?(c.$holder=o(j()),D(),c.$root.html(c.$holder)):c.$root.find("."+L.box).html(c.component.nodes(J.open)),c.trigger("render")},stop:function(){return J.start?(c.close(),c._hidden&&c._hidden.parentNode.removeChild(c._hidden),c.$root.remove(),a.removeClass(L.input).removeData(e),setTimeout(function(){a.off("."+J.id)},0),d.type=J.type,d.readOnly=!1,c.trigger("stop"),J.methods={},J.start=!1,c):c},open:function(h){return J.open?c:(a.addClass(L.active),u(d,"expanded",!0),setTimeout(function(){c.$root.addClass(L.opened),u(c.$root[0],"hidden",!1)},0),!1!==h&&(J.open=!0,I&&o("body").css("overflow","hidden").css("padding-right","+="+r()),F(),z.on("click."+J.id+" focusin."+J.id,function(i){if(!J.handlingOpen){var k=s(i,d);i.isSimulated||k==d||k==document||3==i.which||c.close(k===c.$holder[0])}}).on("keydown."+J.id,function(i){var k=i.keyCode,m=c.component.key[k],C=s(i,d);27==k?c.close(!0):C!=c.$holder[0]||!m&&13!=k?o.contains(c.$root[0],C)&&13==k&&(i.preventDefault(),C.click()):(i.preventDefault(),m?p._.trigger(c.component.key.go,c,[p._.trigger(m)]):c.$root.find("."+L.highlighted).hasClass(L.disabled)||(c.set("select",c.component.item.highlight),K.closeOnSelect&&c.close(!0)))})),c.trigger("open"))},close:function(h){return h&&(K.editable?d.focus():(c.$holder.off("focus.toOpen").focus(),setTimeout(function(){c.$holder.on("focus.toOpen",G)},0))),a.removeClass(L.active),u(d,"expanded",!1),setTimeout(function(){c.$root.removeClass(L.opened+" "+L.focused),u(c.$root[0],"hidden",!0)},0),J.open?(J.open=!1,I&&o("body").css("overflow","").css("padding-right","-="+r()),z.off("."+J.id),c.trigger("close")):c},clear:function(h){return c.set("clear",null,h)},set:function(i,k,m){var C,M,N=o.isPlainObject(i),O=N?i:{};if(m=N&&o.isPlainObject(k)?k:m||{},i){N||(O[i]=k);for(C in O){M=O[C],C in c.component.item&&(void 0===M&&(M=null),c.component.set(C,M,m)),"select"!=C&&"clear"!=C||!K.updateInput||a.val("clear"==C?"":c.get(C,K.format)).trigger("change")}c.render()}return m.muted?c:c.trigger("set",O)},get:function(h,i){if(h=h||"value",null!=J[h]){return J[h]}if("valueSubmit"==h){if(c._hidden){return c._hidden.value}h="value"}if("value"==h){return d.value}if(h in c.component.item){if("string"==typeof i){var k=c.component.get(h);return k?p._.trigger(c.component.formats.toString,c.component,[i,k]):""}return c.component.get(h)}},on:function(i,k,m){var C,M,N=o.isPlainObject(i),O=N?i:{};if(i){N||(O[i]=k);for(C in O){M=O[C],m&&(C="_"+C),J.methods[C]=J.methods[C]||[],J.methods[C].push(M)}}return c},off:function(){var h,i,k=arguments;for(h=0,namesCount=k.length;h<namesCount;h+=1){(i=k[h]) in J.methods&&delete J.methods[i]}return c},trigger:function(h,i){var k=function(m){var C=J.methods[m];C&&C.map(function(M){p._.trigger(M,c,[i])})};return k("_"+h),k(h),c}};return new b}function q(d){var e,f="position";return d.currentStyle?e=d.currentStyle[f]:window.getComputedStyle&&(e=getComputedStyle(d)[f]),"fixed"==e}function r(){if(A.height()<=y.height()){return 0}var a=o('<div style="visibility:hidden;width:100px" />').appendTo("body"),f=a[0].offsetWidth;a.css("overflow","scroll");var g=o('<div style="width:100%" />').appendTo(a),h=g[0].offsetWidth;return a.remove(),f-h}function s(d,e){var f=[];return d.path&&(f=d.path),d.originalEvent&&d.originalEvent.path&&(f=d.originalEvent.path),f&&f.length>0?e&&f.indexOf(e)>=0?e:f[0]:d.target}function t(e,f,g){var h;return function(){var a=this,b=arguments,c=function(){h=null,g||e.apply(a,b)},d=g&&!h;clearTimeout(h),h=setTimeout(c,f),d&&e.apply(a,b)}}function u(a,f,g){if(o.isPlainObject(f)){for(var h in f){v(a,h,f[h])}}else{v(a,f,g)}}function v(d,e,f){d.setAttribute(("role"==e?"":"aria-")+e,f)}function w(a,f){o.isPlainObject(a)||(a={attribute:f}),f="";for(var g in a){var h=("role"==g?"":"aria-")+g;f+=null==a[g]?"":h+'="'+a[g]+'"'}return f}function x(){try{return document.activeElement}catch(b){}}var y=o(window),z=o(document),A=o(document.documentElement),B=null!=document.documentElement.style.transition;return p.klasses=function(b){return b=b||"picker",{picker:b,opened:b+"--opened",focused:b+"--focused",input:b+"__input",active:b+"__input--active",target:b+"__input--target",holder:b+"__holder",frame:b+"__frame",wrap:b+"__wrap",box:b+"__box"}},p._={group:function(b){for(var f,g="",h=p._.trigger(b.min,b);h<=p._.trigger(b.max,b,[h]);h+=b.i){f=p._.trigger(b.item,b,[h]),g+=p._.node(b.node,f[0],f[1],f[2])}return g},node:function(a,f,g,h){return f?(f=o.isArray(f)?f.join(""):f,g=g?' class="'+g+'"':"",h=h?" "+h:"","<"+a+g+h+">"+f+"</"+a+">"):""},lead:function(b){return(b<10?"0":"")+b},trigger:function(d,e,f){return"function"==typeof d?d.apply(e,f||[]):d},digits:function(b){return/\d/.test(b[1])?2:1},isDate:function(b){return{}.toString.call(b).indexOf("Date")>-1&&this.isInteger(b.getDate())},isInteger:function(b){return{}.toString.call(b).indexOf("Number")>-1&&b%1==0},ariaAttr:w},p.extend=function(a,b){o.fn[a]=function(c,d){var h=this.data(a);return"picker"==c?h:h&&"string"==typeof c?p._.trigger(h[c],h,[d]):this.each(function(){o(this).data(a)||new p(this,a,b,c)})},o.fn[a].defaults=b.defaults},p});