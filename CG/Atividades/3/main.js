function main(draw) {
    const canvas = document.querySelector("#c");
    const gl = canvas.getContext('webgl');

    if (!gl) {
        throw new Error('WebGL not supported');
    }

	const vertexShaderSource = `
        attribute vec2 position;
      
      	uniform mat4 matrix;

        void main() {
            gl_Position = matrix * vec4(position, 0, 1);
            gl_PointSize = 5.0; // Use uniform size for point size
        }
    `;

    const fragmentShaderSource = `
        precision mediump float;
        uniform vec3 color;

        void main() {
            gl_FragColor = vec4(color, 1.0);
        }
    `;

    canvas.addEventListener("mousedown", mouseDown, false);

    function mouseDown(event) {
        const x = event.offsetX;
        const y = event.offsetY;
    
        const normalizedX = (x / canvas.width) * 2 - 1;
        const normalizedY = -((y / canvas.height) * 2 - 1); // Flip Y for WebGL
    
        console.log("Normalized X:", normalizedX);
        console.log("Normalized Y:", normalizedY);
    }

    // Creating and Loading shaders
    const vertexShader = createShader(gl, gl.VERTEX_SHADER, vertexShaderSource);
    const fragmentShader = createShader(gl, gl.FRAGMENT_SHADER, fragmentShaderSource);
    const program = createProgram(gl, vertexShader, fragmentShader);
    gl.useProgram(program);

    const positionBuffer = gl.createBuffer();
    const positionLocation = gl.getAttribLocation(program, 'position');
    gl.enableVertexAttribArray(positionLocation);
    gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
    gl.vertexAttribPointer(positionLocation, 2, gl.FLOAT, false, 0, 0);

	// Seting the atributes in ShaderSource
	const matrixUniformLocation = gl.getUniformLocation(program, `matrix`);
    const colorUniformLocation = gl.getUniformLocation(program, `color`);
    
	// Create matrix 
    const matrix = mat4.create();
    mat4.scale(matrix, matrix, [0.25, 0.25, 1.0]);
    gl.uniformMatrix4fv(matrixUniformLocation, false, matrix);
  
    gl.viewport(0, 0, canvas.width, canvas.height);

    gl.clearColor(0.0, 0.0, 0.0, 0.0); // Transparent background
    gl.clear(gl.COLOR_BUFFER_BIT);

    gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
    
    let colorVector = [Math.random(),Math.random(),Math.random()];
    gl.uniform3fv(colorUniformLocation,colorVector);
  
	// Atributes of transformation
    // let theta = 0.0;
    // let tx = 0.0;
    // let ty = 0.0;
    // let scaleX = 1.0;
    // let scaleY = 1.0;
    // let tx_step = 0.01;
    // let ty_step = 0.02;


    n = 30;
    const greyVector = normalizeRGB(33,33,33);
    const greyLightVector = normalizeRGB(175,178,183);
    const cianVector = normalizeRGB(5,190,186);
    const orangeVector = normalizeRGB(235,64,17)
    const yellowVector = normalizeRGB(254,241,180);
    const whiteVector = normalizeRGB(255,255,255);
    const blackVector = normalizeRGB(0,0,0);
    const pinkVector = normalizeRGB(255,167,205);
    const redVector = normalizeRGB(255,0,0);

    const modelMatrix = mat4.create();

    function drawCar() {
        //body
        drawShape(gl, 'rectangle', positionBuffer, colorUniformLocation, matrixUniformLocation, cianVector, modelMatrix, -0.7, -0.3, 1.4, 0.35);
        drawShape(gl, 'rectangle', positionBuffer, colorUniformLocation, matrixUniformLocation, cianVector, modelMatrix, -0.4, 0.0, 0.5, 0.3);
        
        // Lines
        drawShape(gl, 'rectangle', positionBuffer, colorUniformLocation, matrixUniformLocation, blackVector, modelMatrix, -0.7, -0.3, 1.4, 0.02);
        drawShape(gl, 'rectangle', positionBuffer, colorUniformLocation, matrixUniformLocation, greyVector, modelMatrix, -0.7, -0.12, 1.4, 0.02);
        
        // Lights
        drawShape(gl, 'rectangle', positionBuffer, colorUniformLocation, matrixUniformLocation, blackVector, modelMatrix, -0.72, -0.1, 0.12, 0.08);
        drawShape(gl, 'rectangle', positionBuffer, colorUniformLocation, matrixUniformLocation, orangeVector, modelMatrix, -0.72, -0.08, 0.1, 0.05);
        drawShape(gl, 'rectangle', positionBuffer, colorUniformLocation, matrixUniformLocation, blackVector, modelMatrix, 0.62, -0.1, 0.1, 0.08);
        drawShape(gl, 'rectangle', positionBuffer, colorUniformLocation, matrixUniformLocation, orangeVector, modelMatrix, 0.64, -0.08, 0.08, 0.05);
        
        // Windows
        drawShape(gl, 'rectangle', positionBuffer, colorUniformLocation, matrixUniformLocation, greyVector, modelMatrix, -0.36, 0.04, 0.42, 0.22);
        drawShape(gl, 'rectangle', positionBuffer, colorUniformLocation, matrixUniformLocation, greyLightVector, modelMatrix, -0.35, 0.05, 0.4, 0.2);
        
        // Wheels
        drawShape(gl, 'circle', positionBuffer, colorUniformLocation, matrixUniformLocation, greyVector, modelMatrix, n, 0.15, -0.4, -0.3);
        drawShape(gl, 'circle', positionBuffer, colorUniformLocation, matrixUniformLocation, greyVector, modelMatrix, n, 0.15, 0.4, -0.3);
        drawShape(gl, 'circle', positionBuffer, colorUniformLocation, matrixUniformLocation, greyLightVector, modelMatrix, n, 0.12, -0.4, -0.3);
        drawShape(gl, 'circle', positionBuffer, colorUniformLocation, matrixUniformLocation, greyLightVector, modelMatrix, n, 0.12, 0.4, -0.3);
    }

    function drawFlower() {
        // Contour circles
        drawShape(gl, 'circle', positionBuffer, colorUniformLocation, matrixUniformLocation, blackVector, modelMatrix, n, 0.32, 0.0, 0.45);
        drawShape(gl, 'circle', positionBuffer, colorUniformLocation, matrixUniformLocation, blackVector, modelMatrix, n, 0.32, 0.4, 0.15);
        drawShape(gl, 'circle', positionBuffer, colorUniformLocation, matrixUniformLocation, blackVector, modelMatrix, n, 0.32, -0.4, 0.15);
        drawShape(gl, 'circle', positionBuffer, colorUniformLocation, matrixUniformLocation, blackVector, modelMatrix, n, 0.32, 0.26, -0.35);
        drawShape(gl, 'circle', positionBuffer, colorUniformLocation, matrixUniformLocation, blackVector, modelMatrix, n, 0.32, -0.26, -0.35);
        
        // Petals
        drawShape(gl, 'circle', positionBuffer, colorUniformLocation, matrixUniformLocation, pinkVector, modelMatrix, n, 0.3, 0.0, 0.45);
        drawShape(gl, 'circle', positionBuffer, colorUniformLocation, matrixUniformLocation, pinkVector, modelMatrix, n, 0.3, 0.4, 0.15);
        drawShape(gl, 'circle', positionBuffer, colorUniformLocation, matrixUniformLocation, pinkVector, modelMatrix, n, 0.3, -0.4, 0.15);
        drawShape(gl, 'circle', positionBuffer, colorUniformLocation, matrixUniformLocation, pinkVector, modelMatrix, n, 0.3, 0.26, -0.35);
        drawShape(gl, 'circle', positionBuffer, colorUniformLocation, matrixUniformLocation, pinkVector, modelMatrix, n, 0.3, -0.26, -0.35);
        
        // Center
        drawShape(gl, 'circle', positionBuffer, colorUniformLocation, matrixUniformLocation, blackVector, modelMatrix, n, 0.47, 0.0, 0.0);
        drawShape(gl, 'circle', positionBuffer, colorUniformLocation, matrixUniformLocation, yellowVector, modelMatrix, n, 0.45, 0.0, 0.0);
        
    }
    
    function drawClown() {
        drawShape(gl, 'circle', positionBuffer, colorUniformLocation, matrixUniformLocation, orangeVector, modelMatrix, n, 0.17, -0.23, 0.3);
        drawShape(gl, 'circle', positionBuffer, colorUniformLocation, matrixUniformLocation, orangeVector, modelMatrix, n, 0.17, -0.36, 0.14);
        drawShape(gl, 'circle', positionBuffer, colorUniformLocation, matrixUniformLocation, orangeVector, modelMatrix, n, 0.17, -0.40, 0.30);
        
        // Right hair
        drawShape(gl, 'circle', positionBuffer, colorUniformLocation, matrixUniformLocation, orangeVector, modelMatrix, n, 0.17, 0.23, 0.3);
        drawShape(gl, 'circle', positionBuffer, colorUniformLocation, matrixUniformLocation, orangeVector, modelMatrix, n, 0.17, 0.36, 0.14);
        drawShape(gl, 'circle', positionBuffer, colorUniformLocation, matrixUniformLocation, orangeVector, modelMatrix, n, 0.17, 0.40, 0.30);
        
        // Head
        drawShape(gl, 'circle', positionBuffer, colorUniformLocation, matrixUniformLocation, pinkVector, modelMatrix, n, 0.4, 0.0, 0.0);
        
        // Eyes
        drawShape(gl, 'circle', positionBuffer, colorUniformLocation, matrixUniformLocation, whiteVector, modelMatrix, n, 0.07, -0.15, 0.15);
        drawShape(gl, 'circle', positionBuffer, colorUniformLocation, matrixUniformLocation, whiteVector, modelMatrix, n, 0.07, 0.15, 0.15);
        
        // Pupils
        drawShape(gl, 'circle', positionBuffer, colorUniformLocation, matrixUniformLocation, blackVector, modelMatrix, n, 0.03, -0.15, 0.15);
        drawShape(gl, 'circle', positionBuffer, colorUniformLocation, matrixUniformLocation, blackVector, modelMatrix, n, 0.03, 0.15, 0.15);
        
        // Nose
        drawShape(gl, 'circle', positionBuffer, colorUniformLocation, matrixUniformLocation, redVector, modelMatrix, n, 0.1, 0.0, 0.05);
        
        // Mouth
        drawShape(gl, 'arc', positionBuffer, colorUniformLocation, matrixUniformLocation, redVector, modelMatrix, n, 0.25, 0.0, -0.1, -(Math.PI * 0.0), -(Math.PI * 1));
        drawShape(gl, 'arc', positionBuffer, colorUniformLocation, matrixUniformLocation, whiteVector, modelMatrix, n, 0.18, 0.0, -0.13, -(Math.PI * 0.0), -(Math.PI * 1));
        
        // Hat
        drawShape(gl, 'rectangle', positionBuffer, colorUniformLocation, matrixUniformLocation, blackVector, modelMatrix, -0.25, 0.35, 0.5, 0.05);
        drawShape(gl, 'rectangle', positionBuffer, colorUniformLocation, matrixUniformLocation, cianVector, modelMatrix, -0.2, 0.4, 0.4, 0.3);
            
    }

    function animateCar(tx, ty, tx_step, ty_step, theta = 0.0, scaleX = 1.0, scaleY = 1.0) {
        
        if (tx_step > 1) {
            tx = -tx;
            tx_step = -tx_step;
        }
        tx_step += 0.01;
        
        // Create the model matrix and apply the transformations
        mat4.translate(modelMatrix, modelMatrix, [tx, ty, 0.0]);
        mat4.rotateZ(modelMatrix, modelMatrix, degToRad(theta));
        mat4.scale(modelMatrix, modelMatrix, [scaleX, scaleY, 1.0]);
        
        // Pass the updated modelMatrix to the shader and draw the car
        gl.uniformMatrix4fv(matrixUniformLocation, false, modelMatrix);
        drawCar();
        
        // Request the next frame
        requestAnimationFrame(() => animateCar(tx, ty, tx_step, ty_step, theta, scaleX, scaleY));
    }

    function animateFlower(tx, ty, tx_step, ty_step, theta = 0.0, scaleX = 1.0, scaleY = 1.0) {
        // Create the model matrix and apply the transformations
        mat4.translate(modelMatrix, modelMatrix, [tx, ty, 0.0]);
        mat4.rotateZ(modelMatrix, modelMatrix, degToRad(theta));
        mat4.scale(modelMatrix, modelMatrix, [scaleX, scaleY, 1.0]);
        
        // Pass the updated modelMatrix to the shader and draw the car
        gl.uniformMatrix4fv(matrixUniformLocation, false, modelMatrix);
        drawFlower();
        
        // Request the next frame
        requestAnimationFrame(() => animateFlower(tx, ty, tx_step, ty_step, theta, scaleX, scaleY));
    }
    
    function animateClown(tx, ty, tx_step, ty_step, theta = 0.0, scaleX = 1.0, scaleY = 1.0) {

        if (tx_step > 1) {
            tx = -tx;
            tx_step = -tx_step;
        }
        tx_step += 0.03;
        
        if (ty_step > 1) {
            ty = -ty;
            ty_step = -ty_step;
        }
        ty_step += 0.02;
        
        // Create the model matrix and apply the transformations
        mat4.translate(modelMatrix, modelMatrix, [tx, ty, 0.0]);
        mat4.rotateZ(modelMatrix, modelMatrix, degToRad(theta));
        mat4.scale(modelMatrix, modelMatrix, [scaleX, scaleY, 1.0]);
        
        // Pass the updated modelMatrix to the shader and draw the car
        gl.uniformMatrix4fv(matrixUniformLocation, false, modelMatrix);
        drawClown();
        
        // Request the next frame
        requestAnimationFrame(() => animateClown(tx, ty, tx_step, ty_step, theta, scaleX, scaleY));
    }

    switch(draw){
        case 1:
            animateCar(-0.03, 0.0, 0.0, 0.0);
            break;
        case 2: 
            animateFlower(0.0, 0.0, 0.0, 0.0, 1.5);
            break;d
        case 3:
            animateClown(-0.015, -0.03, 0.0, 0.0, 0.0);
            break;
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

function drawShape(gl, shapeType, positionBuffer, colorUniformLocation, matrixUniformLocation, colorVector, modelMatrix, ...params) {
    gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
    gl.uniform3fv(colorUniformLocation, colorVector);

    // Apply the model matrix transformation
    gl.uniformMatrix4fv(matrixUniformLocation, false, modelMatrix);

    if (shapeType === 'rectangle') {
        setRectangleVertices(gl, ...params);
        gl.drawArrays(gl.TRIANGLES, 0, 6);
    } else if (shapeType === 'circle') {
        const [n, radius, centerX, centerY] = params;
        setCircleVertices(gl, n, radius, centerX, centerY);
        gl.drawArrays(gl.TRIANGLES, 0, 3 * n);
    } else if (shapeType === 'arc') {
        const [n, radius, centerX, centerY, startAngle, endAngle] = params;
        setArcVertices(gl, n, radius, centerX, centerY, startAngle, endAngle);
        gl.drawArrays(gl.TRIANGLES, 0, 3 * n);
    }
}

function setRectangleVertices(gl, x, y, width, height) {
    var x1 = x;
    var x2 = x + width;
    var y1 = y;
    var y2 = y + height;
    gl.bufferData(gl.ARRAY_BUFFER, new Float32Array([
        x1, y1,
        x2, y1,
        x1, y2,
        x1, y2,
        x2, y1,
        x2, y2,
    ]), gl.STATIC_DRAW);
}

function setRectangleColor(gl, color) {
    colorData = [];
    for (let triangle = 0; triangle < 2; triangle++) {
        for (let vertex = 0; vertex < 3; vertex++)
            colorData.push(...color);
    }
    gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(colorData), gl.STATIC_DRAW);
}

function setCircleVertices(gl, n, radius, x, y) {
    let center = [x, y];
    // console.log(center);
    let vertexData = [];
    for (let i = 0; i < n; i++) {
        vertexData.push(...center);
        vertexData.push(x + radius * Math.cos(i * (2 * Math.PI) / n), y + radius * Math.sin(i * (2 * Math.PI) / n));
        vertexData.push(x + radius * Math.cos((i + 1) * (2 * Math.PI) / n), y + radius * Math.sin((i + 1) * (2 * Math.PI) / n));
    }
    gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(vertexData), gl.STATIC_DRAW);
}

function setCircleColor(gl, n, color) {
    colorData = [];
    for (let triangle = 0; triangle < n; triangle++) {
        for (let vertex = 0; vertex < 3; vertex++)
            colorData.push(...color);
    }
    gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(colorData), gl.STATIC_DRAW);
}

function setArcVertices(gl, n, radius, centerX, centerY, startAngle, endAngle) {
    const angleStep = (endAngle - startAngle) / n;
    const vertices = [];

    for (let i = 0; i < n; i++) {
        const angle1 = startAngle + i * angleStep;
        const angle2 = startAngle + (i + 1) * angleStep;

        // Center of the arc
        vertices.push(centerX, centerY);
        
        // First point on arc
        vertices.push(centerX + radius * Math.cos(angle1), centerY + radius * Math.sin(angle1));
        
        // Second point on arc
        vertices.push(centerX + radius * Math.cos(angle2), centerY + radius * Math.sin(angle2));
    }

    gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(vertices), gl.STATIC_DRAW);
}


function normalizeRGB(red, green, blue){
    return [(red/255), (green/255), (blue/255)];
}

function radToDeg(r) {
    return r * 180 / Math.PI;
}

function degToRad(d) {
    return d * Math.PI / 180;
}

function drawCar() {
    console.log('Drawing car');
    main(1);
}

function drawFlower() {
    console.log('Drawing flower');
    main(2);
}

function drawClown() {
    console.log('Drawing clown');
  main(3);
}

main();