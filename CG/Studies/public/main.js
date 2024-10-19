const canvas = document.querySelector('canvas');
const gl = canvas.getContext('webgl');

if (!gl) {
    throw new Error('WebGL not supported');
}

// vertexData = [...]

// create buffer
// load vertexData into buffer

// create vertex shader
// create fragment shader
// create program
// attach shaders to program

// enable vertex attributes

// draw

const vertexData = [
    0, 1, 0,
    1, -1, 0,
    -1, -1, 0,
];

const buffer = gl.createBuffer();       // create buffer
gl.bindBuffer(gl.ARRAY_BUFFER, buffer);
gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(vertexData), gl.STATIC_DRAW);   // load vertexData into buffer

const vertexShader = gl.createShader(gl.VERTEX_SHADER);     // create vertex shader
gl.shaderSource(vertexShader, `
attribute vec3 position;
void main() {
    gl_Position = vec4(position, 1);
}
`);
gl.compileShader(vertexShader);

const fragmentShader = gl.createShader(gl.FRAGMENT_SHADER); // create fragment shader
gl.shaderSource(fragmentShader, `
void main() {
    gl_FragColor = vec4(1, 0, 0, 1);
}
`);
gl.compileShader(fragmentShader);

const program = gl.createProgram();         // create program
gl.attachShader(program, vertexShader);     // attach shaders to program
gl.attachShader(program, fragmentShader);
gl.linkProgram(program);

const positionLocation = gl.getAttribLocation(program, `position`);     
gl.enableVertexAttribArray(positionLocation);
gl.vertexAttribPointer(positionLocation, 3, gl.FLOAT, false, 0, 0);  // enable vertex attributes, as default the atributes is disable

gl.useProgram(program);
gl.drawArrays(gl.TRIANGLES, 0, 3);  //draw