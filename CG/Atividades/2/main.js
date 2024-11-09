function main(draw) {
    const canvas = document.querySelector("#c");
    const gl = canvas.getContext('webgl');

    if (!gl) {
        throw new Error('WebGL not supported');
    }

    let startPoint = null;
    let startPoints = [];

    let modeDraw = 'r';             // Mode for drawing lines or triangles
    let modeLineCharacter = 'k';    // Mode for changing color or thickness
    let size = 5.0;

    const vertexShaderSource = `
        attribute vec2 position;
        uniform mat4 matrix;
        uniform float size;

        void main() {
            gl_Position = matrix * vec4(position, 0, 1);
            gl_PointSize = size; // Use uniform size for point size
        }
    `;

    const fragmentShaderSource = `
        precision mediump float;
        uniform vec3 vColor;

        void main() {
            gl_FragColor = vec4(vColor, 1.0);
        }
    `;

    // Load shaders
    const vertexShader = createShader(gl, gl.VERTEX_SHADER, vertexShaderSource);
    const fragmentShader = createShader(gl, gl.FRAGMENT_SHADER, fragmentShaderSource);
    const program = createProgram(gl, vertexShader, fragmentShader);
    gl.useProgram(program);

    const positionBuffer = gl.createBuffer();
    const positionLocation = gl.getAttribLocation(program, 'position');
    gl.enableVertexAttribArray(positionLocation);
    gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
    gl.vertexAttribPointer(positionLocation, 2, gl.FLOAT, false, 0, 0);

    gl.clearColor(0.0, 0.0, 0.0, 0.0); // Transparent background
    gl.clear(gl.COLOR_BUFFER_BIT);

    // Set thickness of line
    const matrixUniformLocation = gl.getUniformLocation(program, 'matrix');
    const colorUniformLocation = gl.getUniformLocation(program, 'vColor');
    const sizeLocation = gl.getUniformLocation(program, 'size');
    gl.uniform1f(sizeLocation, size);

    const matrix = [
        2 / canvas.width, 0, 0, 0,
        0, -2 / canvas.height, 0, 0,
        0, 0, 0, 0,
        -1, 1, 0, 1
    ];
    gl.uniformMatrix4fv(matrixUniformLocation, false, matrix);

    let positionVector = [canvas.width / 2, canvas.height / 2];
    gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
    gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(positionVector), gl.STATIC_DRAW);

    let colorVector = [0.0, 0.0, 0.0];
    gl.uniform3fv(colorUniformLocation, colorVector);

    canvas.addEventListener("mousedown", mouseClick, false);

    function mouseClick(event) {
        const x = event.offsetX;
        const y = event.offsetY;

        if (modeDraw === 'r') {
            if (!startPoint) {
                startPoint = [x, y]; // First points
            } else {
                drawLine(startPoint[0], startPoint[1], x, y);
                startPoint = null; // Reset
            }
        }
        else if (modeDraw === 't') {
            startPoints.push([x, y]); // Save first, second and third point
    
            if (startPoints.length === 3) { // draw triangle
                drawTriangle(startPoints);
                startPoints = [];           // Reset
            }
        } 
    }

    function drawTriangle(points) {
        const vertices = new Float32Array(points.flat());
    
        gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
        gl.bufferData(gl.ARRAY_BUFFER, vertices, gl.STATIC_DRAW);
    
        gl.clear(gl.COLOR_BUFFER_BIT);
        gl.drawArrays(gl.TRIANGLES, 0, vertices.length / 2); // Draws triangle with 3 points
    }
    

    document.body.addEventListener("keydown", keyDown, false);

    function keyDown(event) {
        console.log("key = " + event.key);

        // Handle mode and draw selection
        switch (event.key) {
            case 'k':
                modeLineCharacter = 'k'; // Mode changing color
                break;
            case 'e':
                modeLineCharacter = 'e'; // Mode changing thickness
                break;
            case 'r':
                modeDraw = 'r';         // Mode drawing lines
                break;
            case 't':
                modeDraw = 't';         // Mode drawing triangles
                break;
        }

        // Update color or thickness
        switch (modeLineCharacter) {
            case 'k': // Color mode
                switch(event.key){
                    case "0":
                        colorVector = normalizeRGB(0,0,0);   //black
                        console.log("black");
                        break;
                    case "1":
                        colorVector = normalizeRGB(147,147,230);   //light blue
                        console.log("light blue");
                        break;
                    case "2":
                        colorVector = normalizeRGB(39,39,204);   //blue
                        console.log("blue");
                        break;
                    case "3":
                        colorVector = normalizeRGB(49,184,0);   //green
                        console.log("green");
                        break;
                    case "4":
                        colorVector = normalizeRGB(252,245,15);   //yellow
                        console.log("yellow");
                        break;
                    case "5":
                        colorVector = normalizeRGB(255,8,8);   //red
                        console.log("red");
                        break;
                    case "6":
                        colorVector = normalizeRGB(132,59,163);   //magenta
                        console.log("magenta");
                        break;
                    case "7":
                        colorVector = normalizeRGB(249,119,148);   //pink
                        console.log("pink");
                        break;
                    case "8":
                        colorVector = normalizeRGB(255,99,8);   //orange
                        console.log("orange");
                        break;
                    case "9":
                        colorVector = normalizeRGB(172,175,179);   //light grey
                        console.log("light grey");
                        break;
                    default:
                        console.log("Invalid color key!");
                        break;
                }
                if (colorVector) {
                    gl.uniform3fv(colorUniformLocation, colorVector);
                }
                break;

            case 'e': // Thickness mode
                switch (event.key) {
                    case '1':
                        size = 1.0;
                        break;
                    case '2':
                        size = 2.0;
                        break;
                    case '3':
                        size = 3.0;
                        break;
                    case '4':
                        size = 4.0;
                        break;
                    case '5':
                        size = 5.0;
                        break;
                    case '6':
                        size = 6.0;
                        break;
                    case '7':
                        size = 7.0;
                        break;
                    case '8':
                        size = 8.0;
                        break;
                    case '9':
                        size = 9.0;
                        break;
                    default:
                        size = null;
                }
                if (size) {
                    gl.uniform1f(sizeLocation, size);
                    console.log("thickness = ", size);
                }
                break;
        }
    }

    function drawLine(x0, y0, x1, y1) {
        const points = bresenham(x0, y0, x1, y1);
        const vertices = new Float32Array(points.flat());

        gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
        gl.bufferData(gl.ARRAY_BUFFER, vertices, gl.STATIC_DRAW);

        gl.clear(gl.COLOR_BUFFER_BIT);
        gl.drawArrays(gl.POINTS, 0, vertices.length / 2);
    }

    function bresenham(x0, y0, x1, y1) {
        const points = [];
        const dx = Math.abs(x1 - x0);
        const dy = Math.abs(y1 - y0);
        const sx = x0 < x1 ? 1 : -1;
        const sy = y0 < y1 ? 1 : -1;
        let err = dx - dy;

        while (true) {
            points.push([x0, y0]);
            if (x0 === x1 && y0 === y1) break;
            const err2 = err * 2;
            if (err2 > -dy) {
                err -= dy;
                x0 += sx;
            }
            if (err2 < dx) {
                err += dx;
                y0 += sy;
            }
        }
        return points;
    }
}

function createShader(gl, type, source) {
    const shader = gl.createShader(type);
    gl.shaderSource(shader, source);
    gl.compileShader(shader);

    if (gl.getShaderParameter(shader, gl.COMPILE_STATUS)) {
        return shader;
    }

    console.error(gl.getShaderInfoLog(shader));
    gl.deleteShader(shader);
}

function createProgram(gl, vertexShader, fragmentShader) {
    const program = gl.createProgram();
    gl.attachShader(program, vertexShader);
    gl.attachShader(program, fragmentShader);
    gl.linkProgram(program);

    if (gl.getProgramParameter(program, gl.LINK_STATUS)) {
        return program;
    }

    console.error(gl.getProgramInfoLog(program));
    gl.deleteProgram(program);
}

function normalizeRGB(red, green, blue) {
    return [red / 255, green / 255, blue / 255];
}

main();
