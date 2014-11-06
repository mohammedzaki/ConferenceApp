/**
 * Adobe Edge: symbol definitions
 */
(function($, Edge, compId){
//images folder
var im='images/';

var fonts = {};
var opts = {};
var resources = [
];
var symbols = {
"stage": {
    version: "3.0.0",
    minimumCompatibleVersion: "3.0.0",
    build: "3.0.0.322",
    baseState: "Base State",
    scaleToFit: "none",
    centerStage: "none",
    initialState: "Base State",
    gpuAccelerate: false,
    resizeInstances: false,
    content: {
            dom: [
            {
                id: '_1',
                type: 'image',
                rect: ['0px', '0px','1024px','748px','auto', 'auto'],
                fill: ["rgba(0,0,0,0)",im+"loader1.png",'0px','0px']
            },
            {
                id: '_6',
                type: 'image',
                rect: ['0px', '0px','1024px','163px','auto', 'auto'],
                fill: ["rgba(0,0,0,0)",im+"loader6.png",'0px','0px']
            },
            {
                id: 'TextCopy',
                type: 'text',
                rect: ['192px', '21px','auto','38px','auto', 'auto'],
                text: "Cashing Presentation Elements Progress : -",
                align: "center",
                font: ['Arial, Helvetica, sans-serif', 31, "rgba(255,255,255,1.00)", "900", "none", "normal"]
            },
            {
                id: '_32',
                type: 'image',
                rect: ['687px', '643px','337px','105px','auto', 'auto'],
                fill: ["rgba(0,0,0,0)",im+"loader3.png",'0px','0px']
            },
            {
                id: '_73',
                type: 'image',
                rect: ['253px', '308px','517px','131px','auto', 'auto'],
                fill: ["rgba(0,0,0,0)",im+"loader7.png",'0px','0px']
            },
            {
                id: '_44',
                type: 'image',
                rect: ['445px', '429px','133px','46px','auto', 'auto'],
                fill: ["rgba(0,0,0,0)",im+"loader4.png",'0px','0px']
            },
            {
                id: '_83',
                type: 'image',
                rect: ['255px', '319px','488px','101px','auto', 'auto'],
                fill: ["rgba(0,0,0,0)",im+"loader8.png",'0px','0px']
            },
            {
                id: '_115',
                type: 'image',
                rect: ['311px', '356px','329px','35px','auto', 'auto'],
                fill: ["rgba(0,0,0,0)",im+"loader10.png",'0px','0px']
            },
            {
                id: 'rate',
                type: 'text',
                rect: ['641px', '356px','41px','36px','auto', 'auto'],
                text: "00",
                font: ['Arial, Helvetica, sans-serif', 28, "rgba(35,139,163,1.00)", "600", "none", ""],
                transform: [[],[],[],['0.96','0.96']]
            },
            {
                id: 'Text2',
                type: 'text',
                rect: ['680px', '356px','30px','36px','auto', 'auto'],
                text: "%",
                font: ['Times New Roman, Times, serif', 28, "rgba(35,139,163,1.00)", "600", "none", ""],
                transform: [[],[],[],['0.96','0.96']]
            },
            {
                id: 'pbar',
                type: 'image',
                rect: ['313px', '356px','325px','34px','auto', 'auto'],
                fill: ["rgba(0,0,0,0)",im+"loader11.png",'0px','0px']
            },
            {
                id: 'Text',
                type: 'text',
                rect: ['192px', '85px','639px','38px','auto', 'auto'],
                text: "Wait while Loading Presentation Elements",
                align: "center",
                font: ['Arial, Helvetica, sans-serif', 22, "rgba(255,255,255,1)", "900", "none", "normal"]
            }],
            symbolInstances: [

            ]
        },
    states: {
        "Base State": {
            "${__32}": [
                ["style", "top", '748px'],
                ["style", "left", '687px']
            ],
            "${__83}": [
                ["style", "top", '319px'],
                ["style", "opacity", '0'],
                ["style", "left", '255px']
            ],
            "${__115}": [
                ["style", "top", '356px'],
                ["style", "opacity", '0'],
                ["style", "left", '311px']
            ],
            "${_rate}": [
                ["transform", "scaleX", '0.96'],
                ["style", "font-weight", '600'],
                ["style", "left", '641px'],
                ["style", "font-size", '28px'],
                ["style", "top", '356px'],
                ["transform", "scaleY", '0.96'],
                ["style", "opacity", '0'],
                ["style", "height", '36px'],
                ["style", "font-family", 'Arial, Helvetica, sans-serif'],
                ["color", "color", 'rgba(35,139,163,1.00)'],
                ["style", "width", '41px']
            ],
            "${_Text2}": [
                ["transform", "rotateZ", '0deg'],
                ["transform", "scaleX", '0.96'],
                ["style", "font-weight", '600'],
                ["style", "left", '680px'],
                ["style", "font-size", '28px'],
                ["style", "top", '356px'],
                ["style", "opacity", '0'],
                ["transform", "scaleY", '0.96'],
                ["transform", "skewX", '0deg'],
                ["style", "height", '36px'],
                ["style", "font-family", 'Times New Roman, Times, serif'],
                ["style", "width", '30px'],
                ["color", "color", 'rgba(35,139,163,1)']
            ],
            "${__44}": [
                ["style", "top", '429px'],
                ["style", "opacity", '0'],
                ["style", "left", '445px']
            ],
            "${__1}": [
                ["style", "top", '0px'],
                ["style", "opacity", '0'],
                ["style", "left", '0px'],
                ["style", "height", '748px']
            ],
            "${_Text}": [
                ["style", "top", '85px'],
                ["style", "height", '38px'],
                ["style", "opacity", '0'],
                ["style", "left", '192px'],
                ["style", "width", '639px']
            ],
            "${_pbar}": [
                ["style", "top", '356px'],
                ["style", "opacity", '0'],
                ["style", "left", '313px'],
                ["style", "width", '325px']
            ],
            "${_Stage}": [
                ["color", "background-color", 'rgba(255,255,255,1)'],
                ["style", "width", '1024px'],
                ["style", "height", '748px'],
                ["style", "overflow", 'hidden']
            ],
            "${__73}": [
                ["style", "top", '308px'],
                ["style", "opacity", '0'],
                ["style", "left", '253px']
            ],
            "${_TextCopy}": [
                ["color", "color", 'rgba(255,255,255,1.00)'],
                ["style", "font-weight", '900'],
                ["style", "left", '192px'],
                ["style", "font-size", '31px'],
                ["style", "top", '21px'],
                ["style", "text-align", 'center'],
                ["style", "height", '38px'],
                ["style", "font-family", 'Arial, Helvetica, sans-serif'],
                ["style", "opacity", '0']
            ],
            "${__6}": [
                ["style", "left", '0px'],
                ["style", "top", '-163px']
            ]
        }
    },
    timelines: {
        "Default Timeline": {
            fromState: "Base State",
            toState: "",
            duration: 5000,
            autoPlay: true,
            timeline: [
                { id: "eid49", tween: [ "style", "${_Text2}", "opacity", '1', { fromValue: '0'}], position: 750, duration: 500 },
                { id: "eid19", tween: [ "style", "${__32}", "top", '643px', { fromValue: '748px'}], position: 1000, duration: 500 },
                { id: "eid47", tween: [ "style", "${__73}", "opacity", '1', { fromValue: '0'}], position: 750, duration: 500 },
                { id: "eid11", tween: [ "style", "${__6}", "top", '0px', { fromValue: '-163px'}], position: 55, duration: 695 },
                { id: "eid45", tween: [ "style", "${_rate}", "opacity", '1', { fromValue: '0'}], position: 750, duration: 500 },
                { id: "eid77", tween: [ "style", "${_pbar}", "opacity", '1', { fromValue: '0.000000'}], position: 750, duration: 500 },
                { id: "eid57", tween: [ "style", "${__1}", "opacity", '1', { fromValue: '0.000000'}], position: 0, duration: 500 },
                { id: "eid53", tween: [ "style", "${__115}", "opacity", '1', { fromValue: '0'}], position: 750, duration: 500 },
                { id: "eid81", tween: [ "style", "${_Text}", "opacity", '1', { fromValue: '0.000000'}], position: 1000, duration: 250 },
                { id: "eid14", tween: [ "style", "${_TextCopy}", "opacity", '1', { fromValue: '0'}], position: 750, duration: 500 },
                { id: "eid51", tween: [ "style", "${__44}", "opacity", '1', { fromValue: '0'}], position: 750, duration: 500 },
                { id: "eid43", tween: [ "style", "${__83}", "opacity", '1', { fromValue: '0'}], position: 750, duration: 500 }            ]
        }
    }
}
};


Edge.registerCompositionDefn(compId, symbols, fonts, resources, opts);

/**
 * Adobe Edge DOM Ready Event Handler
 */
$(window).ready(function() {
     Edge.launchComposition(compId);
});
})(jQuery, AdobeEdge, "EDGE-1113726837");
