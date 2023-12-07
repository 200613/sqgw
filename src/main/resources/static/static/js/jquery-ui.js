/* jQuery UI - v1.13.2 - 2022-08-04
* http://jqueryui.com
* Includes: widget.js, position.js, keycode.js, unique-id.js, widgets/autocomplete.js, widgets/menu.js
* Copyright jQuery Foundation and other contributors; Licensed MIT */
(function(a){if(typeof define==="function"&&define.amd){define(["jquery"],a)}else{a(jQuery)}})(function(a){a.ui=a.ui||{};var f=a.ui.version="1.13.2";
/*
 * jQuery UI Widget 1.13.2
 * http://jqueryui.com
 *
 * Copyright jQuery Foundation and other contributors
 * Released under the MIT license.
 * http://jquery.org/license
 */
var l=0;var h=Array.prototype.hasOwnProperty;var j=Array.prototype.slice;a.cleanData=(function(m){return function(o){var p,n,q;for(q=0;(n=o[q])!=null;q++){p=a._data(n,"events");if(p&&p.remove){a(n).triggerHandler("remove")}}m(o)}})(a.cleanData);a.widget=function(r,m,t){var p,o,n;var u={};var s=r.split(".")[0];r=r.split(".")[1];var q=s+"-"+r;if(!t){t=m;m=a.Widget}if(Array.isArray(t)){t=a.extend.apply(null,[{}].concat(t))}a.expr.pseudos[q.toLowerCase()]=function(v){return !!a.data(v,q)};a[s]=a[s]||{};p=a[s][r];o=a[s][r]=function(w,v){if(!this||!this._createWidget){return new o(w,v)}if(arguments.length){this._createWidget(w,v)}};a.extend(o,p,{version:t.version,_proto:a.extend({},t),_childConstructors:[]});n=new m();n.options=a.widget.extend({},n.options);a.each(t,function(v,w){if(typeof w!=="function"){u[v]=w;return}u[v]=(function(){function x(){return m.prototype[v].apply(this,arguments)}function y(z){return m.prototype[v].apply(this,z)}return function(){var z=this._super;var A=this._superApply;var B;this._super=x;this._superApply=y;B=w.apply(this,arguments);this._super=z;this._superApply=A;return B}})()});o.prototype=a.widget.extend(n,{widgetEventPrefix:p?(n.widgetEventPrefix||r):r},u,{constructor:o,namespace:s,widgetName:r,widgetFullName:q});if(p){a.each(p._childConstructors,function(x,v){var w=v.prototype;a.widget(w.namespace+"."+w.widgetName,o,v._proto)});delete p._childConstructors}else{m._childConstructors.push(o)}a.widget.bridge(r,o);return o};a.widget.extend=function(q){var m=j.call(arguments,1);var n=0;var o=m.length;var p;var r;for(;n<o;n++){for(p in m[n]){r=m[n][p];if(h.call(m[n],p)&&r!==undefined){if(a.isPlainObject(r)){q[p]=a.isPlainObject(q[p])?a.widget.extend({},q[p],r):a.widget.extend({},r)}else{q[p]=r}}}}return q};a.widget.bridge=function(n,o){var m=o.prototype.widgetFullName||n;a.fn[n]=function(r){var q=typeof r==="string";var p=j.call(arguments,1);var s=this;if(q){if(!this.length&&r==="instance"){s=undefined}else{this.each(function(){var u;var t=a.data(this,m);if(r==="instance"){s=t;return false}if(!t){return a.error("cannot call methods on "+n+" prior to initialization; attempted to call method '"+r+"'")}if(typeof t[r]!=="function"||r.charAt(0)==="_"){return a.error("no such method '"+r+"' for "+n+" widget instance")}u=t[r].apply(t,p);if(u!==t&&u!==undefined){s=u&&u.jquery?s.pushStack(u.get()):u;return false}})}}else{if(p.length){r=a.widget.extend.apply(null,[r].concat(p))}this.each(function(){var t=a.data(this,m);if(t){t.option(r||{});if(t._init){t._init()}}else{a.data(this,m,new o(r,this))}})}return s}};a.Widget=function(){};a.Widget._childConstructors=[];a.Widget.prototype={widgetName:"widget",widgetEventPrefix:"",defaultElement:"<div>",options:{classes:{},disabled:false,create:null},_createWidget:function(n,m){m=a(m||this.defaultElement||this)[0];this.element=a(m);this.uuid=l++;this.eventNamespace="."+this.widgetName+this.uuid;this.bindings=a();this.hoverable=a();this.focusable=a();this.classesElementLookup={};if(m!==this){a.data(m,this.widgetFullName,this);this._on(true,this.element,{remove:function(o){if(o.target===m){this.destroy()}}});this.document=a(m.style?m.ownerDocument:m.document||m);this.window=a(this.document[0].defaultView||this.document[0].parentWindow)}this.options=a.widget.extend({},this.options,this._getCreateOptions(),n);this._create();if(this.options.disabled){this._setOptionDisabled(this.options.disabled)}this._trigger("create",null,this._getCreateEventData());this._init()},_getCreateOptions:function(){return{}},_getCreateEventData:a.noop,_create:a.noop,_init:a.noop,destroy:function(){var m=this;this._destroy();a.each(this.classesElementLookup,function(n,o){m._removeClass(o,n)});this.element.off(this.eventNamespace).removeData(this.widgetFullName);this.widget().off(this.eventNamespace).removeAttr("aria-disabled");this.bindings.off(this.eventNamespace)},_destroy:a.noop,widget:function(){return this.element},option:function(o,r){var p=o;var q;var m;var n;if(arguments.length===0){return a.widget.extend({},this.options)}if(typeof o==="string"){p={};q=o.split(".");o=q.shift();if(q.length){m=p[o]=a.widget.extend({},this.options[o]);for(n=0;n<q.length-1;n++){m[q[n]]=m[q[n]]||{};m=m[q[n]]}o=q.pop();if(arguments.length===1){return m[o]===undefined?null:m[o]}m[o]=r}else{if(arguments.length===1){return this.options[o]===undefined?null:this.options[o]}p[o]=r}}this._setOptions(p);return this},_setOptions:function(n){var m;for(m in n){this._setOption(m,n[m])}return this},_setOption:function(m,n){if(m==="classes"){this._setOptionClasses(n)}this.options[m]=n;if(m==="disabled"){this._setOptionDisabled(n)}return this},_setOptionClasses:function(p){var m,o,n;for(m in p){n=this.classesElementLookup[m];if(p[m]===this.options.classes[m]||!n||!n.length){continue}o=a(n.get());this._removeClass(n,m);o.addClass(this._classes({element:o,keys:m,classes:p,add:true}))}},_setOptionDisabled:function(m){this._toggleClass(this.widget(),this.widgetFullName+"-disabled",null,!!m);if(m){this._removeClass(this.hoverable,null,"ui-state-hover");this._removeClass(this.focusable,null,"ui-state-focus")}},enable:function(){return this._setOptions({disabled:false})},disable:function(){return this._setOptions({disabled:true})},_classes:function(o){var n=[];var q=this;o=a.extend({element:this.element,classes:this.options.classes||{}},o);function m(){var r=[];o.element.each(function(s,t){var u=a.map(q.classesElementLookup,function(v){return v}).some(function(v){return v.is(t)});if(!u){r.push(t)}});q._on(a(r),{remove:"_untrackClassesElement"})}function p(s,r){var t,u;for(u=0;u<s.length;u++){t=q.classesElementLookup[s[u]]||a();if(o.add){m();t=a(a.uniqueSort(t.get().concat(o.element.get())))}else{t=a(t.not(o.element).get())}q.classesElementLookup[s[u]]=t;n.push(s[u]);if(r&&o.classes[s[u]]){n.push(o.classes[s[u]])}}}if(o.keys){p(o.keys.match(/\S+/g)||[],true)}if(o.extra){p(o.extra.match(/\S+/g)||[])}return n.join(" ")},_untrackClassesElement:function(m){var n=this;a.each(n.classesElementLookup,function(o,p){if(a.inArray(m.target,p)!==-1){n.classesElementLookup[o]=a(p.not(m.target).get())}});this._off(a(m.target))},_removeClass:function(m,o,n){return this._toggleClass(m,o,n,false)},_addClass:function(m,o,n){return this._toggleClass(m,o,n,true)},_toggleClass:function(n,p,o,m){m=(typeof m==="boolean")?m:o;var r=(typeof n==="string"||n===null),q={extra:r?p:o,keys:r?n:p,element:r?this.element:n,add:m};q.element.toggleClass(this._classes(q),m);return this},_on:function(q,n,o){var m;var p=this;if(typeof q!=="boolean"){o=n;n=q;q=false}if(!o){o=n;n=this.element;m=this.widget()}else{n=m=a(n);this.bindings=this.bindings.add(n)}a.each(o,function(r,t){function u(){if(!q&&(p.options.disabled===true||a(this).hasClass("ui-state-disabled"))){return}return(typeof t==="string"?p[t]:t).apply(p,arguments)}if(typeof t!=="string"){u.guid=t.guid=t.guid||u.guid||a.guid++}var v=r.match(/^([\w:-]*)\s*(.*)$/);var s=v[1]+p.eventNamespace;var w=v[2];if(w){m.on(s,w,u)}else{n.on(s,u)}})},_off:function(m,n){n=(n||"").split(" ").join(this.eventNamespace+" ")+this.eventNamespace;m.off(n);this.bindings=a(this.bindings.not(m).get());this.focusable=a(this.focusable.not(m).get());this.hoverable=a(this.hoverable.not(m).get())},_delay:function(n,m){function o(){return(typeof n==="string"?p[n]:n).apply(p,arguments)}var p=this;return setTimeout(o,m||0)},_hoverable:function(m){this.hoverable=this.hoverable.add(m);this._on(m,{mouseenter:function(n){this._addClass(a(n.currentTarget),null,"ui-state-hover")},mouseleave:function(n){this._removeClass(a(n.currentTarget),null,"ui-state-hover")}})},_focusable:function(m){this.focusable=this.focusable.add(m);this._on(m,{focusin:function(n){this._addClass(a(n.currentTarget),null,"ui-state-focus")},focusout:function(n){this._removeClass(a(n.currentTarget),null,"ui-state-focus")}})},_trigger:function(r,o,n){var q,p;var m=this.options[r];n=n||{};o=a.Event(o);o.type=(r===this.widgetEventPrefix?r:this.widgetEventPrefix+r).toLowerCase();o.target=this.element[0];p=o.originalEvent;if(p){for(q in p){if(!(q in o)){o[q]=p[q]}}}this.element.trigger(o,n);return !(typeof m==="function"&&m.apply(this.element[0],[o].concat(n))===false||o.isDefaultPrevented())}};a.each({show:"fadeIn",hide:"fadeOut"},function(n,m){a.Widget.prototype["_"+n]=function(q,s,o){if(typeof s==="string"){s={effect:s}}var r;var p=!s?n:s===true||typeof s==="number"?m:s.effect||m;s=s||{};if(typeof s==="number"){s={duration:s}}else{if(s===true){s={}}}r=!a.isEmptyObject(s);s.complete=o;if(s.delay){q.delay(s.delay)}if(r&&a.effects&&a.effects.effect[p]){q[n](s)}else{if(p!==n&&q[p]){q[p](s.duration,s.easing,o)}else{q.queue(function(t){a(this)[n]();if(o){o.call(q[0])}t()})}}}});var g=a.widget;
/*
 * jQuery UI Position 1.13.2
 * http://jqueryui.com
 *
 * Copyright jQuery Foundation and other contributors
 * Released under the MIT license.
 * http://jquery.org/license
 *
 * http://api.jqueryui.com/position/
 */
(function(){var o,s=Math.max,n=Math.abs,u=/left|center|right/,y=/top|center|bottom/,v=/[\+\-]\d+(\.[\d]+)?%?/,x=/^\w+/,w=/%$/,m=a.fn.position;function q(A,B,z){return[parseFloat(A[0])*(w.test(A[0])?B/100:1),parseFloat(A[1])*(w.test(A[1])?z/100:1)]}function t(z,A){return parseInt(a.css(z,A),10)||0}function r(z){return z!=null&&z===z.window}function p(z){var A=z[0];if(A.nodeType===9){return{width:z.width(),height:z.height(),offset:{top:0,left:0}}}if(r(A)){return{width:z.width(),height:z.height(),offset:{top:z.scrollTop(),left:z.scrollLeft()}}}if(A.preventDefault){return{width:0,height:0,offset:{top:A.pageY,left:A.pageX}}}return{width:z.outerWidth(),height:z.outerHeight(),offset:z.offset()}}a.position={scrollbarWidth:function(){if(o!==undefined){return o}var B,C,z=a("<div style='display:block;position:absolute;width:200px;height:200px;overflow:hidden;'><div style='height:300px;width:auto;'></div></div>"),A=z.children()[0];a("body").append(z);B=A.offsetWidth;z.css("overflow","scroll");C=A.offsetWidth;if(B===C){C=z[0].clientWidth}z.remove();return(o=B-C)},getScrollInfo:function(D){var B=D.isWindow||D.isDocument?"":D.element.css("overflow-x"),C=D.isWindow||D.isDocument?"":D.element.css("overflow-y"),z=B==="scroll"||(B==="auto"&&D.width<D.element[0].scrollWidth),A=C==="scroll"||(C==="auto"&&D.height<D.element[0].scrollHeight);return{width:A?a.position.scrollbarWidth():0,height:z?a.position.scrollbarWidth():0}},getWithinInfo:function(z){var D=a(z||window),C=r(D[0]),B=!!D[0]&&D[0].nodeType===9,A=!C&&!B;return{element:D,isWindow:C,isDocument:B,offset:A?a(z).offset():{left:0,top:0},scrollLeft:D.scrollLeft(),scrollTop:D.scrollTop(),width:D.outerWidth(),height:D.outerHeight()}}};a.fn.position=function(E){if(!E||!E.of){return m.apply(this,arguments)}E=a.extend({},E);var z,J,H,I,A,C,G=typeof E.of==="string"?a(document).find(E.of):a(E.of),K=a.position.getWithinInfo(E.within),F=a.position.getScrollInfo(K),B=(E.collision||"flip").split(" "),D={};C=p(G);if(G[0].preventDefault){E.at="left top"}J=C.width;H=C.height;I=C.offset;A=a.extend({},I);a.each(["my","at"],function(){var M=(E[this]||"").split(" "),L,N;if(M.length===1){M=u.test(M[0])?M.concat(["center"]):y.test(M[0])?["center"].concat(M):["center","center"]}M[0]=u.test(M[0])?M[0]:"center";M[1]=y.test(M[1])?M[1]:"center";L=v.exec(M[0]);N=v.exec(M[1]);D[this]=[L?L[0]:0,N?N[0]:0];E[this]=[x.exec(M[0])[0],x.exec(M[1])[0]]});if(B.length===1){B[1]=B[0]}if(E.at[0]==="right"){A.left+=J}else{if(E.at[0]==="center"){A.left+=J/2}}if(E.at[1]==="bottom"){A.top+=H}else{if(E.at[1]==="center"){A.top+=H/2}}z=q(D.at,J,H);A.left+=z[0];A.top+=z[1];return this.each(function(){var M,V,O=a(this),Q=O.outerWidth(),P=O.outerHeight(),R=t(this,"marginLeft"),S=t(this,"marginTop"),N=Q+R+t(this,"marginRight")+F.width,L=P+S+t(this,"marginBottom")+F.height,U=a.extend({},A),T=q(D.my,O.outerWidth(),O.outerHeight());if(E.my[0]==="right"){U.left-=Q}else{if(E.my[0]==="center"){U.left-=Q/2}}if(E.my[1]==="bottom"){U.top-=P}else{if(E.my[1]==="center"){U.top-=P/2}}U.left+=T[0];U.top+=T[1];M={marginLeft:R,marginTop:S};a.each(["left","top"],function(X,W){if(a.ui.position[B[X]]){a.ui.position[B[X]][W](U,{targetWidth:J,targetHeight:H,elemWidth:Q,elemHeight:P,collisionPosition:M,collisionWidth:N,collisionHeight:L,offset:[z[0]+T[0],z[1]+T[1]],my:E.my,at:E.at,within:K,elem:O})}});if(E.using){V=function(Z){var Y=I.left-U.left,aa=Y+J-Q,ab=I.top-U.top,W=ab+H-P,X={target:{element:G,left:I.left,top:I.top,width:J,height:H},element:{element:O,left:U.left,top:U.top,width:Q,height:P},horizontal:aa<0?"left":Y>0?"right":"center",vertical:W<0?"top":ab>0?"bottom":"middle"};if(J<Q&&n(Y+aa)<J){X.horizontal="center"}if(H<P&&n(ab+W)<H){X.vertical="middle"}if(s(n(Y),n(aa))>s(n(ab),n(W))){X.important="horizontal"}else{X.important="vertical"}E.using.call(this,Z,X)}}O.offset(a.extend(U,{using:V}))})};a.ui.position={fit:{left:function(F,A){var G=A.within,H=G.isWindow?G.scrollLeft:G.offset.left,C=G.width,z=F.left-A.collisionPosition.marginLeft,D=H-z,E=z+A.collisionWidth-C-H,B;if(A.collisionWidth>C){if(D>0&&E<=0){B=F.left+D+A.collisionWidth-C-H;F.left+=D-B}else{if(E>0&&D<=0){F.left=H}else{if(D>E){F.left=H+C-A.collisionWidth}else{F.left=H}}}}else{if(D>0){F.left+=D}else{if(E>0){F.left-=E}else{F.left=s(F.left-z,F.left)}}}},top:function(F,A){var G=A.within,H=G.isWindow?G.scrollTop:G.offset.top,C=A.within.height,z=F.top-A.collisionPosition.marginTop,E=H-z,D=z+A.collisionHeight-C-H,B;if(A.collisionHeight>C){if(E>0&&D<=0){B=F.top+E+A.collisionHeight-C-H;F.top+=E-B}else{if(D>0&&E<=0){F.top=H}else{if(E>D){F.top=H+C-A.collisionHeight}else{F.top=H}}}}else{if(E>0){F.top+=E}else{if(D>0){F.top-=D}else{F.top=s(F.top-z,F.top)}}}}},flip:{left:function(K,B){var L=B.within,M=L.offset.left+L.scrollLeft,H=L.width,G=L.isWindow?L.scrollLeft:L.offset.left,A=K.left-B.collisionPosition.marginLeft,I=A-G,J=A+B.collisionWidth-H-G,C=B.my[0]==="left"?-B.elemWidth:B.my[0]==="right"?B.elemWidth:0,z=B.at[0]==="left"?B.targetWidth:B.at[0]==="right"?-B.targetWidth:0,F=-2*B.offset[0],E,D;if(I<0){E=K.left+C+z+F+B.collisionWidth-H-M;if(E<0||E<n(I)){K.left+=C+z+F}}else{if(J>0){D=K.left-B.collisionPosition.marginLeft+C+z+F-G;if(D>0||n(D)<J){K.left+=C+z+F}}}},top:function(K,B){var M=B.within,N=M.offset.top+M.scrollTop,H=M.height,G=M.isWindow?M.scrollTop:M.offset.top,A=K.top-B.collisionPosition.marginTop,J=A-G,I=A+B.collisionHeight-H-G,L=B.my[1]==="top",C=L?-B.elemHeight:B.my[1]==="bottom"?B.elemHeight:0,z=B.at[1]==="top"?B.targetHeight:B.at[1]==="bottom"?-B.targetHeight:0,F=-2*B.offset[1],E,D;if(J<0){D=K.top+C+z+F+B.collisionHeight-H-N;if(D<0||D<n(J)){K.top+=C+z+F}}else{if(I>0){E=K.top-B.collisionPosition.marginTop+C+z+F-G;if(E>0||n(E)<I){K.top+=C+z+F}}}}},flipfit:{left:function(){a.ui.position.flip.left.apply(this,arguments);a.ui.position.fit.left.apply(this,arguments)},top:function(){a.ui.position.flip.top.apply(this,arguments);a.ui.position.fit.top.apply(this,arguments)}}}})();var c=a.ui.position;
/*
 * jQuery UI Keycode 1.13.2
 * http://jqueryui.com
 *
 * Copyright jQuery Foundation and other contributors
 * Released under the MIT license.
 * http://jquery.org/license
 */
var b=a.ui.keyCode={BACKSPACE:8,COMMA:188,DELETE:46,DOWN:40,END:35,ENTER:13,ESCAPE:27,HOME:36,LEFT:37,PAGE_DOWN:34,PAGE_UP:33,PERIOD:190,RIGHT:39,SPACE:32,TAB:9,UP:38};
/*
 * jQuery UI Unique ID 1.13.2
 * http://jqueryui.com
 *
 * Copyright jQuery Foundation and other contributors
 * Released under the MIT license.
 * http://jquery.org/license
 */
var e=a.fn.extend({uniqueId:(function(){var m=0;return function(){return this.each(function(){if(!this.id){this.id="ui-id-"+(++m)}})}})(),removeUniqueId:function(){return this.each(function(){if(/^ui-id-\d+$/.test(this.id)){a(this).removeAttr("id")}})}});var d=a.ui.safeActiveElement=function(n){var m;try{m=n.activeElement}catch(o){m=n.body}if(!m){m=n.body}if(!m.nodeName){m=n.body}return m};
/*
 * jQuery UI Menu 1.13.2
 * http://jqueryui.com
 *
 * Copyright jQuery Foundation and other contributors
 * Released under the MIT license.
 * http://jquery.org/license
 */
var k=a.widget("ui.menu",{version:"1.13.2",defaultElement:"<ul>",delay:300,options:{icons:{submenu:"ui-icon-caret-1-e"},items:"> *",menus:"ul",position:{my:"left top",at:"right top"},role:"menu",blur:null,focus:null,select:null},_create:function(){this.activeMenu=this.element;this.mouseHandled=false;this.lastMousePosition={x:null,y:null};this.element.uniqueId().attr({role:this.options.role,tabIndex:0});this._addClass("ui-menu","ui-widget ui-widget-content");this._on({"mousedown .ui-menu-item":function(m){m.preventDefault();this._activateItem(m)},"click .ui-menu-item":function(n){var o=a(n.target);var m=a(a.ui.safeActiveElement(this.document[0]));if(!this.mouseHandled&&o.not(".ui-state-disabled").length){this.select(n);if(!n.isPropagationStopped()){this.mouseHandled=true}if(o.has(".ui-menu").length){this.expand(n)}else{if(!this.element.is(":focus")&&m.closest(".ui-menu").length){this.element.trigger("focus",[true]);if(this.active&&this.active.parents(".ui-menu").length===1){clearTimeout(this.timer)}}}}},"mouseenter .ui-menu-item":"_activateItem","mousemove .ui-menu-item":"_activateItem",mouseleave:"collapseAll","mouseleave .ui-menu":"collapseAll",focus:function(m,o){var n=this.active||this._menuItems().first();if(!o){this.focus(m,n)}},blur:function(m){this._delay(function(){var n=!a.contains(this.element[0],a.ui.safeActiveElement(this.document[0]));if(n){this.collapseAll(m)}})},keydown:"_keydown"});this.refresh();this._on(this.document,{click:function(m){if(this._closeOnDocumentClick(m)){this.collapseAll(m,true)}this.mouseHandled=false}})},_activateItem:function(n){if(this.previousFilter){return}if(n.clientX===this.lastMousePosition.x&&n.clientY===this.lastMousePosition.y){return}this.lastMousePosition={x:n.clientX,y:n.clientY};var m=a(n.target).closest(".ui-menu-item"),o=a(n.currentTarget);if(m[0]!==o[0]){return}if(o.is(".ui-state-active")){return}this._removeClass(o.siblings().children(".ui-state-active"),null,"ui-state-active");this.focus(n,o)},_destroy:function(){var m=this.element.find(".ui-menu-item").removeAttr("role aria-disabled"),n=m.children(".ui-menu-item-wrapper").removeUniqueId().removeAttr("tabIndex role aria-haspopup");this.element.removeAttr("aria-activedescendant").find(".ui-menu").addBack().removeAttr("role aria-labelledby aria-expanded aria-hidden aria-disabled tabIndex").removeUniqueId().show();n.children().each(function(){var o=a(this);if(o.data("ui-menu-submenu-caret")){o.remove()}})},_keydown:function(n){var o,p,m,r,q=true;switch(n.keyCode){case a.ui.keyCode.PAGE_UP:this.previousPage(n);break;case a.ui.keyCode.PAGE_DOWN:this.nextPage(n);break;case a.ui.keyCode.HOME:this._move("first","first",n);break;case a.ui.keyCode.END:this._move("last","last",n);break;case a.ui.keyCode.UP:this.previous(n);break;case a.ui.keyCode.DOWN:this.next(n);break;case a.ui.keyCode.LEFT:this.collapse(n);break;case a.ui.keyCode.RIGHT:if(this.active&&!this.active.is(".ui-state-disabled")){this.expand(n)}break;case a.ui.keyCode.ENTER:case a.ui.keyCode.SPACE:this._activate(n);break;case a.ui.keyCode.ESCAPE:this.collapse(n);break;default:q=false;p=this.previousFilter||"";r=false;m=n.keyCode>=96&&n.keyCode<=105?(n.keyCode-96).toString():String.fromCharCode(n.keyCode);clearTimeout(this.filterTimer);if(m===p){r=true}else{m=p+m}o=this._filterMenuItems(m);o=r&&o.index(this.active.next())!==-1?this.active.nextAll(".ui-menu-item"):o;if(!o.length){m=String.fromCharCode(n.keyCode);o=this._filterMenuItems(m)}if(o.length){this.focus(n,o);this.previousFilter=m;this.filterTimer=this._delay(function(){delete this.previousFilter},1000)}else{delete this.previousFilter}}if(q){n.preventDefault()}},_activate:function(m){if(this.active&&!this.active.is(".ui-state-disabled")){if(this.active.children("[aria-haspopup='true']").length){this.expand(m)}else{this.select(m)}}},refresh:function(){var o,n,q,p,r,t=this,m=this.options.icons.submenu,s=this.element.find(this.options.menus);this._toggleClass("ui-menu-icons",null,!!this.element.find(".ui-icon").length);q=s.filter(":not(.ui-menu)").hide().attr({role:this.options.role,"aria-hidden":"true","aria-expanded":"false"}).each(function(){var v=a(this),u=v.prev(),w=a("<span>").data("ui-menu-submenu-caret",true);t._addClass(w,"ui-menu-icon","ui-icon "+m);u.attr("aria-haspopup","true").prepend(w);v.attr("aria-labelledby",u.attr("id"))});this._addClass(q,"ui-menu","ui-widget ui-widget-content ui-front");o=s.add(this.element);n=o.find(this.options.items);n.not(".ui-menu-item").each(function(){var u=a(this);if(t._isDivider(u)){t._addClass(u,"ui-menu-divider","ui-widget-content")}});p=n.not(".ui-menu-item, .ui-menu-divider");r=p.children().not(".ui-menu").uniqueId().attr({tabIndex:-1,role:this._itemRole()});this._addClass(p,"ui-menu-item")._addClass(r,"ui-menu-item-wrapper");n.filter(".ui-state-disabled").attr("aria-disabled","true");if(this.active&&!a.contains(this.element[0],this.active[0])){this.blur()}},_itemRole:function(){return{menu:"menuitem",listbox:"option"}[this.options.role]},_setOption:function(n,o){if(n==="icons"){var m=this.element.find(".ui-menu-icon");this._removeClass(m,null,this.options.icons.submenu)._addClass(m,null,o.submenu)}this._super(n,o)},_setOptionDisabled:function(m){this._super(m);this.element.attr("aria-disabled",String(m));this._toggleClass(null,"ui-state-disabled",!!m)},focus:function(n,p){var q,o,m;this.blur(n,n&&n.type==="focus");this._scrollIntoView(p);this.active=p.first();o=this.active.children(".ui-menu-item-wrapper");this._addClass(o,null,"ui-state-active");if(this.options.role){this.element.attr("aria-activedescendant",o.attr("id"))}m=this.active.parent().closest(".ui-menu-item").children(".ui-menu-item-wrapper");this._addClass(m,null,"ui-state-active");if(n&&n.type==="keydown"){this._close()}else{this.timer=this._delay(function(){this._close()},this.delay)}q=p.children(".ui-menu");if(q.length&&n&&(/^mouse/.test(n.type))){this._startOpening(q)}this.activeMenu=p.parent();this._trigger("focus",n,{item:p})},_scrollIntoView:function(o){var m,r,q,s,n,p;if(this._hasScroll()){m=parseFloat(a.css(this.activeMenu[0],"borderTopWidth"))||0;r=parseFloat(a.css(this.activeMenu[0],"paddingTop"))||0;q=o.offset().top-this.activeMenu.offset().top-m-r;s=this.activeMenu.scrollTop();n=this.activeMenu.height();p=o.outerHeight();if(q<0){this.activeMenu.scrollTop(s+q)}else{if(q+p>n){this.activeMenu.scrollTop(s+q-n+p)}}}},blur:function(m,n){if(!n){clearTimeout(this.timer)}if(!this.active){return}this._removeClass(this.active.children(".ui-menu-item-wrapper"),null,"ui-state-active");this._trigger("blur",m,{item:this.active});this.active=null},_startOpening:function(m){clearTimeout(this.timer);if(m.attr("aria-hidden")!=="true"){return}this.timer=this._delay(function(){this._close();this._open(m)},this.delay)},_open:function(n){var m=a.extend({of:this.active},this.options.position);clearTimeout(this.timer);this.element.find(".ui-menu").not(n.parents(".ui-menu")).hide().attr("aria-hidden","true");n.show().removeAttr("aria-hidden").attr("aria-expanded","true").position(m)},collapseAll:function(n,m){clearTimeout(this.timer);this.timer=this._delay(function(){var o=m?this.element:a(n&&n.target).closest(this.element.find(".ui-menu"));if(!o.length){o=this.element}this._close(o);this.blur(n);this._removeClass(o.find(".ui-state-active"),null,"ui-state-active");this.activeMenu=o},m?0:this.delay)},_close:function(m){if(!m){m=this.active?this.active.parent():this.element}m.find(".ui-menu").hide().attr("aria-hidden","true").attr("aria-expanded","false")},_closeOnDocumentClick:function(m){return !a(m.target).closest(".ui-menu").length},_isDivider:function(m){return !/[^\-\u2014\u2013\s]/.test(m.text())},collapse:function(m){var n=this.active&&this.active.parent().closest(".ui-menu-item",this.element);if(n&&n.length){this._close();this.focus(m,n)}},expand:function(m){var n=this.active&&this._menuItems(this.active.children(".ui-menu")).first();if(n&&n.length){this._open(n.parent());this._delay(function(){this.focus(m,n)})}},next:function(m){this._move("next","first",m)},previous:function(m){this._move("prev","last",m)},isFirstItem:function(){return this.active&&!this.active.prevAll(".ui-menu-item").length},isLastItem:function(){return this.active&&!this.active.nextAll(".ui-menu-item").length},_menuItems:function(m){return(m||this.element).find(this.options.items).filter(".ui-menu-item")},_move:function(m,o,n){var p;if(this.active){if(m==="first"||m==="last"){p=this.active[m==="first"?"prevAll":"nextAll"](".ui-menu-item").last()}else{p=this.active[m+"All"](".ui-menu-item").first()}}if(!p||!p.length||!this.active){p=this._menuItems(this.activeMenu)[o]()}this.focus(n,p)},nextPage:function(n){var p,m,o;if(!this.active){this.next(n);return}if(this.isLastItem()){return}if(this._hasScroll()){m=this.active.offset().top;o=this.element.innerHeight();if(a.fn.jquery.indexOf("3.2.")===0){o+=this.element[0].offsetHeight-this.element.outerHeight()}this.active.nextAll(".ui-menu-item").each(function(){p=a(this);return p.offset().top-m-o<0});this.focus(n,p)}else{this.focus(n,this._menuItems(this.activeMenu)[!this.active?"first":"last"]())}},previousPage:function(n){var p,m,o;if(!this.active){this.next(n);return}if(this.isFirstItem()){return}if(this._hasScroll()){m=this.active.offset().top;o=this.element.innerHeight();if(a.fn.jquery.indexOf("3.2.")===0){o+=this.element[0].offsetHeight-this.element.outerHeight()}this.active.prevAll(".ui-menu-item").each(function(){p=a(this);return p.offset().top-m+o>0});this.focus(n,p)}else{this.focus(n,this._menuItems(this.activeMenu).first())}},_hasScroll:function(){return this.element.outerHeight()<this.element.prop("scrollHeight")},select:function(m){this.active=this.active||a(m.target).closest(".ui-menu-item");var n={item:this.active};if(!this.active.has(".ui-menu").length){this.collapseAll(m,true)}this._trigger("select",m,n)},_filterMenuItems:function(m){var n=m.replace(/[\-\[\]{}()*+?.,\\\^$|#\s]/g,"\\$&"),o=new RegExp("^"+n,"i");return this.activeMenu.find(this.options.items).filter(".ui-menu-item").filter(function(){return o.test(String.prototype.trim.call(a(this).children(".ui-menu-item-wrapper").text()))})}});
/*
 * jQuery UI Autocomplete 1.13.2
 * http://jqueryui.com
 *
 * Copyright jQuery Foundation and other contributors
 * Released under the MIT license.
 * http://jquery.org/license
 */
a.widget("ui.autocomplete",{version:"1.13.2",defaultElement:"<input>",options:{appendTo:null,autoFocus:false,delay:300,minLength:1,position:{my:"left top",at:"left bottom",collision:"none"},source:null,change:null,close:null,focus:null,open:null,response:null,search:null,select:null},requestIndex:0,pending:0,liveRegionTimer:null,_create:function(){var q,r,p,o=this.element[0].nodeName.toLowerCase(),n=o==="textarea",m=o==="input";this.isMultiLine=n||!m&&this._isContentEditable(this.element);this.valueMethod=this.element[n||m?"val":"text"];this.isNewMenu=true;this._addClass("ui-autocomplete-input");this.element.attr("autocomplete","off");this._on(this.element,{keydown:function(s){if(this.element.prop("readOnly")){q=true;p=true;r=true;return}q=false;p=false;r=false;var t=a.ui.keyCode;switch(s.keyCode){case t.PAGE_UP:q=true;this._move("previousPage",s);break;case t.PAGE_DOWN:q=true;this._move("nextPage",s);break;case t.UP:q=true;this._keyEvent("previous",s);break;case t.DOWN:q=true;this._keyEvent("next",s);break;case t.ENTER:if(this.menu.active){q=true;s.preventDefault();this.menu.select(s)}break;case t.TAB:if(this.menu.active){this.menu.select(s)}break;case t.ESCAPE:if(this.menu.element.is(":visible")){if(!this.isMultiLine){this._value(this.term)}this.close(s);s.preventDefault()}break;default:r=true;this._searchTimeout(s);break}},keypress:function(s){if(q){q=false;if(!this.isMultiLine||this.menu.element.is(":visible")){s.preventDefault()}return}if(r){return}var t=a.ui.keyCode;switch(s.keyCode){case t.PAGE_UP:this._move("previousPage",s);break;case t.PAGE_DOWN:this._move("nextPage",s);break;case t.UP:this._keyEvent("previous",s);break;case t.DOWN:this._keyEvent("next",s);break}},input:function(s){if(p){p=false;s.preventDefault();return}this._searchTimeout(s)},focus:function(){this.selectedItem=null;this.previous=this._value()},blur:function(s){clearTimeout(this.searching);this.close(s);this._change(s)}});this._initSource();this.menu=a("<ul>").appendTo(this._appendTo()).menu({role:null}).hide().attr({unselectable:"on"}).menu("instance");this._addClass(this.menu.element,"ui-autocomplete","ui-front");this._on(this.menu.element,{mousedown:function(s){s.preventDefault()},menufocus:function(s,v){var u,t;if(this.isNewMenu){this.isNewMenu=false;if(s.originalEvent&&/^mouse/.test(s.originalEvent.type)){this.menu.blur();this.document.one("mousemove",function(){a(s.target).trigger(s.originalEvent)});return}}t=v.item.data("ui-autocomplete-item");if(false!==this._trigger("focus",s,{item:t})){if(s.originalEvent&&/^key/.test(s.originalEvent.type)){this._value(t.value)}}u=v.item.attr("aria-label")||t.value;if(u&&String.prototype.trim.call(u).length){clearTimeout(this.liveRegionTimer);this.liveRegionTimer=this._delay(function(){this.liveRegion.html(a("<div>").text(u))},100)}},menuselect:function(s,v){var t=v.item.data("ui-autocomplete-item"),u=this.previous;if(this.element[0]!==a.ui.safeActiveElement(this.document[0])){this.element.trigger("focus");this.previous=u;this._delay(function(){this.previous=u;this.selectedItem=t})}if(false!==this._trigger("select",s,{item:t})){this._value(t.value)}this.term=this._value();this.close(s);this.selectedItem=t}});this.liveRegion=a("<div>",{role:"status","aria-live":"assertive","aria-relevant":"additions"}).appendTo(this.document[0].body);this._addClass(this.liveRegion,null,"ui-helper-hidden-accessible");this._on(this.window,{beforeunload:function(){this.element.removeAttr("autocomplete")}})},_destroy:function(){clearTimeout(this.searching);this.element.removeAttr("autocomplete");this.menu.element.remove();this.liveRegion.remove()},_setOption:function(m,n){this._super(m,n);if(m==="source"){this._initSource()}if(m==="appendTo"){this.menu.element.appendTo(this._appendTo())}if(m==="disabled"&&n&&this.xhr){this.xhr.abort()}},_isEventTargetInWidget:function(m){var n=this.menu.element[0];return m.target===this.element[0]||m.target===n||a.contains(n,m.target)},_closeOnClickOutside:function(m){if(!this._isEventTargetInWidget(m)){this.close()}},_appendTo:function(){var m=this.options.appendTo;if(m){m=m.jquery||m.nodeType?a(m):this.document.find(m).eq(0)}if(!m||!m[0]){m=this.element.closest(".ui-front, dialog")}if(!m.length){m=this.document[0].body}return m},_initSource:function(){var m,o,n=this;if(Array.isArray(this.options.source)){m=this.options.source;this.source=function(p,q){q(a.ui.autocomplete.filter(m,p.term))}}else{if(typeof this.options.source==="string"){o=this.options.source;this.source=function(p,q){if(n.xhr){n.xhr.abort()}n.xhr=a.ajax({url:o,data:p,dataType:"json",success:function(r){q(r)},error:function(){q([])}})}}else{this.source=this.options.source}}},_searchTimeout:function(m){clearTimeout(this.searching);this.searching=this._delay(function(){var n=this.term===this._value(),o=this.menu.element.is(":visible"),p=m.altKey||m.ctrlKey||m.metaKey||m.shiftKey;if(!n||(n&&!o&&!p)){this.selectedItem=null;this.search(null,m)}},this.options.delay)},search:function(n,m){n=n!=null?n:this._value();this.term=this._value();if(n.length<this.options.minLength){return this.close(m)}if(this._trigger("search",m)===false){return}return this._search(n)},_search:function(m){this.pending++;this._addClass("ui-autocomplete-loading");this.cancelSearch=false;this.source({term:m},this._response())},_response:function(){var m=++this.requestIndex;return function(n){if(m===this.requestIndex){this.__response(n)}this.pending--;if(!this.pending){this._removeClass("ui-autocomplete-loading")}}.bind(this)},__response:function(m){if(m){m=this._normalize(m)}this._trigger("response",null,{content:m});if(!this.options.disabled&&m&&m.length&&!this.cancelSearch){this._suggest(m);this._trigger("open")}else{this._close()}},close:function(m){this.cancelSearch=true;this._close(m)},_close:function(m){this._off(this.document,"mousedown");if(this.menu.element.is(":visible")){this.menu.element.hide();this.menu.blur();this.isNewMenu=true;this._trigger("close",m)}},_change:function(m){if(this.previous!==this._value()){this._trigger("change",m,{item:this.selectedItem})}},_normalize:function(m){if(m.length&&m[0].label&&m[0].value){return m}return a.map(m,function(n){if(typeof n==="string"){return{label:n,value:n}}return a.extend({},n,{label:n.label||n.value,value:n.value||n.label})})},_suggest:function(m){var n=this.menu.element.empty();this._renderMenu(n,m);this.isNewMenu=true;this.menu.refresh();n.show();this._resizeMenu();n.position(a.extend({of:this.element},this.options.position));if(this.options.autoFocus){this.menu.next()}this._on(this.document,{mousedown:"_closeOnClickOutside"})},_resizeMenu:function(){var m=this.menu.element;m.outerWidth(Math.max(m.width("").outerWidth()+1,this.element.outerWidth()))},_renderMenu:function(o,m){var n=this;a.each(m,function(p,q){n._renderItemData(o,q)})},_renderItemData:function(n,m){return this._renderItem(n,m).data("ui-autocomplete-item",m)},_renderItem:function(n,m){return a("<li>").append(a("<div>").text(m.label)).appendTo(n)},_move:function(m,n){if(!this.menu.element.is(":visible")){this.search(null,n);return}if(this.menu.isFirstItem()&&/^previous/.test(m)||this.menu.isLastItem()&&/^next/.test(m)){if(!this.isMultiLine){this._value(this.term)}this.menu.blur();return}this.menu[m](n)},widget:function(){return this.menu.element},_value:function(){return this.valueMethod.apply(this.element,arguments)},_keyEvent:function(n,m){if(!this.isMultiLine||this.menu.element.is(":visible")){this._move(n,m);m.preventDefault()}},_isContentEditable:function(n){if(!n.length){return false}var m=n.prop("contentEditable");if(m==="inherit"){return this._isContentEditable(n.parent())}return m==="true"}});a.extend(a.ui.autocomplete,{escapeRegex:function(m){return m.replace(/[\-\[\]{}()*+?.,\\\^$|#\s]/g,"\\$&")},filter:function(m,o){var n=new RegExp(a.ui.autocomplete.escapeRegex(o),"i");return a.grep(m,function(p){return n.test(p.label||p.value||p)})}});a.widget("ui.autocomplete",a.ui.autocomplete,{options:{messages:{noResults:"No search results.",results:function(m){return m+(m>1?" results are":" result is")+" available, use up and down arrow keys to navigate."}}},__response:function(m){var n;this._superApply(arguments);if(this.options.disabled||this.cancelSearch){return}if(m&&m.length){n=this.options.messages.results(m.length)}else{n=this.options.messages.noResults}clearTimeout(this.liveRegionTimer);this.liveRegionTimer=this._delay(function(){this.liveRegion.html(a("<div>").text(n))},100)}});var i=a.ui.autocomplete});