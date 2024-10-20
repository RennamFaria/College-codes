const canvas = document.querySelector('canvas');
const gl = canvas.getContext('webgl');

if (!gl) {
    throw new Error('WebGL not supported');
}

const mat4 = glMatrix.mat4;     //Use Object destructuring to get mat4

const vertexData = [
    0, 1, 0,  // Top vertex
    -1, -1, 0,  // Bottom-left vertex
    1, -1, 0,  // Bottom-right vertex
];

function randomColor() {
    return [Math.random(), Math.random(), Math.random()];
}

const colorData = [
    ...randomColor(),
    ...randomColor(),
    ...randomColor(),
];

const positionBuffer = gl.createBuffer();       // create buffer
gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(vertexData), gl.STATIC_DRAW);   // load vertexData into buffer

const colorBuffer = gl.createBuffer();
gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(colorData), gl.STATIC_DRAW);

const vertexShader = gl.createShader(gl.VERTEX_SHADER);     // create vertex shader
gl.shaderSource(vertexShader, `
precision mediump float;

attribute vec3 position;
attribute vec3 color;
varying vec3 vColor;

uniform mat4 matrix;

void main() {
    vColor = color;
    gl_Position = matrix * vec4(position, 1);
}
`);
gl.compileShader(vertexShader);

const fragmentShader = gl.createShader(gl.FRAGMENT_SHADER); // create fragment shader
gl.shaderSource(fragmentShader, `
precision mediump float;

varying vec3 vColor;

void main() {
    gl_FragColor = vec4(vColor, 1);
}
`);
gl.compileShader(fragmentShader);

const program = gl.createProgram();         // create program
gl.attachShader(program, vertexShader);     // attach shaders to program
gl.attachShader(program, fragmentShader);
gl.linkProgram(program);

const positionLocation = gl.getAttribLocation(program, 'position');     
gl.enableVertexAttribArray(positionLocation);
gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
gl.vertexAttribPointer(positionLocation, 3, gl.FLOAT, false, 0, 0);  // enable vertex attributes, as default the atributes is disable

const colorLocation = gl.getAttribLocation(program, 'color');
gl.enableVertexAttribArray(colorLocation);
gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
gl.vertexAttribPointer(colorLocation, 3, gl.FLOAT, false, 0, 0);

gl.useProgram(program);

const uniformLocation = {
    matrix: gl.getUniformLocation(program, 'matrix'),
};

const matrix = mat4.create();
mat4.translate(matrix, matrix, [0.0, 0.0, 0.0]);   //change the position to the middle

mat4.scale(matrix, matrix, [0.5, 0.5, 0.5]); // Scale down the triangle

console.log(matrix);

function animate() {
    requestAnimationFrame(animate);
    mat4.rotateZ(matrix, matrix, Math.PI/2 / 70);

    gl.uniformMatrix4fv(uniformLocation.matrix, false, matrix);

    gl.clear(gl.COLOR_BUFFER_BIT);
    gl.drawArrays(gl.TRIANGLES, 0, 3);  //draw
}
gl.clearColor(0.0, 0.0, 0.0, 1.0);
gl.clear(gl.COLOR_BUFFER_BIT);

animate();