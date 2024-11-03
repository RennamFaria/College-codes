function main(draw) {
    const canvas = document.querySelector("#c");
    const gl = canvas.getContext('webgl');

    if (!gl) {
        throw new Error('WebGL not supported');
    }

    canvas.addEventListener("mousedown", mouseDown, false);

    function mouseDown(event) {
        const x = event.offsetX;
        const y = event.offsetY;
    
        const normalizedX = (x / canvas.width) * 2 - 1;
        const normalizedY = -((y / canvas.height) * 2 - 1); // Flip Y for WebGL
    
        console.log("Normalized X:", normalizedX);
        console.log("Normalized Y:", normalizedY);
    }

    var vertexShader = createVertexShader(gl);
    var fragmentShader = createFragmentShader(gl);
    
    var program = createProgram(gl, vertexShader, fragmentShader);

    gl.useProgram(program);

    const positionBuffer = gl.createBuffer();
    const colorBuffer = gl.createBuffer();

    const positionLocation = gl.getAttribLocation(program, `position`);
    gl.enableVertexAttribArray(positionLocation);
    gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
    gl.vertexAttribPointer(positionLocation, 2, gl.FLOAT, false, 0, 0);

    const colorLocation = gl.getAttribLocation(program, `color`);
    gl.enableVertexAttribArray(colorLocation);
    gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
    gl.vertexAttribPointer(colorLocation, 3, gl.FLOAT, false, 0, 0);

    gl.clearColor(0.0, 0.0, 0.0, 0.0); // Makes the WebGL background transparent
    gl.clear(gl.COLOR_BUFFER_BIT);

    n = 30;
    const grey = normalizeRGB(33,33,33);
    const greyLight = normalizeRGB(175,178,183);
    const cian = normalizeRGB(5,190,186);
    const orange = normalizeRGB(235,64,17)
    const yellow = normalizeRGB(254,241,180);
    const white = normalizeRGB(255,255,255);
    const black = normalizeRGB(0,0,0);
    const pink = normalizeRGB(255,167,205);
    const red = normalizeRGB(255,0,0);

    switch(draw){
        case 1:         //drawCar
            //body
            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
            setRectangleVertices(gl, -0.7, -0.3, 1.4, 0.35);
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setRectangleColor(gl, [...cian]);
            gl.drawArrays(gl.TRIANGLES, 0, 6);

            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
            setRectangleVertices(gl, -0.4, 0.0, 0.5, 0.3);
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setRectangleColor(gl, [...cian]);
            gl.drawArrays(gl.TRIANGLES, 0, 6);

            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);     //line botton
            setRectangleVertices(gl, -0.7, -0.3, 1.4, 0.02);
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setRectangleColor(gl, [...black]);
            gl.drawArrays(gl.TRIANGLES, 0, 6);

            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
            setRectangleVertices(gl, -0.7, -0.12, 1.4, 0.02);   //line middle
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setRectangleColor(gl, [...grey]);
            gl.drawArrays(gl.TRIANGLES, 0, 6);

            //light front
            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
            setRectangleVertices(gl, -0.72, -0.1, 0.12, 0.08);
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setRectangleColor(gl, [...black]);
            gl.drawArrays(gl.TRIANGLES, 0, 6);
            
            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
            setRectangleVertices(gl, -0.72, -0.08, 0.1, 0.05);
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setRectangleColor(gl, [...orange]);
            gl.drawArrays(gl.TRIANGLES, 0, 6);

            //light back
            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
            setRectangleVertices(gl, 0.62, -0.1, 0.1, 0.08);
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setRectangleColor(gl, [...black]);
            gl.drawArrays(gl.TRIANGLES, 0, 6);
            
            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
            setRectangleVertices(gl, 0.64, -0.08, 0.08, 0.05);
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setRectangleColor(gl, [...orange]);
            gl.drawArrays(gl.TRIANGLES, 0, 6);

            //window
            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
            setRectangleVertices(gl, -0.36, 0.04, 0.42, 0.22);
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setRectangleColor(gl, [...grey]);
            gl.drawArrays(gl.TRIANGLES, 0, 6);

            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
            setRectangleVertices(gl, -0.35, 0.05, 0.4, 0.2);
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setRectangleColor(gl, [...greyLight]);
            gl.drawArrays(gl.TRIANGLES, 0, 6);

            //wheels
            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer); 
            setCircleVertices(gl, n, 0.15, -0.4, -0.3);
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setCircleColor(gl, n, [...grey]);
            gl.drawArrays(gl.TRIANGLES, 0, 3 * n);

            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer); 
            setCircleVertices(gl, n, 0.15, 0.4, -0.3);
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setCircleColor(gl, n, [...grey]);
            gl.drawArrays(gl.TRIANGLES, 0, 3 * n);

            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer); 
            setCircleVertices(gl, n, 0.12, -0.4, -0.3);
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setCircleColor(gl, n, [...greyLight]);
            gl.drawArrays(gl.TRIANGLES, 0, 3 * n);

            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer); 
            setCircleVertices(gl, n, 0.12, 0.4, -0.3);
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setCircleColor(gl, n, [...greyLight]);
            gl.drawArrays(gl.TRIANGLES, 0, 3 * n);

            break;

        case 2:         //drawFlower

            //contorn
            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer); 
            setCircleVertices(gl, n, 0.32, 0.0, 0.45);      
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setCircleColor(gl, n, [...black]);
            gl.drawArrays(gl.TRIANGLES, 0, 3 * n);
            
            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer); 
            setCircleVertices(gl, n, 0.32, 0.4, 0.15);       
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setCircleColor(gl, n, [...black]);
            gl.drawArrays(gl.TRIANGLES, 0, 3 * n);
            
            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer); 
            setCircleVertices(gl, n, 0.32, -0.4, 0.15);       
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setCircleColor(gl, n, [...black]);
            gl.drawArrays(gl.TRIANGLES, 0, 3 * n);
            
            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer); 
            setCircleVertices(gl, n, 0.32, 0.26, -0.35);       
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setCircleColor(gl, n, [...black]);
            gl.drawArrays(gl.TRIANGLES, 0, 3 * n);
            
            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer); 
            setCircleVertices(gl, n, 0.32, -0.26, -0.35);       
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setCircleColor(gl, n, [...black]);
            gl.drawArrays(gl.TRIANGLES, 0, 3 * n);

            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer); 
            setCircleVertices(gl, n, 0.3, 0.0, 0.45);       //up petal
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setCircleColor(gl, n, [...pink]);
            gl.drawArrays(gl.TRIANGLES, 0, 3 * n);

        
            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer); 
            setCircleVertices(gl, n, 0.3, 0.4, 0.15);        //right up petal
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setCircleColor(gl, n, [...pink]);
            gl.drawArrays(gl.TRIANGLES, 0, 3 * n);

        
            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer); 
            setCircleVertices(gl, n, 0.3, -0.4, 0.15);        //left up petal
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setCircleColor(gl, n, [...pink]);
            gl.drawArrays(gl.TRIANGLES, 0, 3 * n);

        
            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer); 
            setCircleVertices(gl, n, 0.3, 0.26, -0.35);        //right down petal
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setCircleColor(gl, n, [...pink]);
            gl.drawArrays(gl.TRIANGLES, 0, 3 * n);

        
            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer); 
            setCircleVertices(gl, n, 0.3, -0.26, -0.35);        //left down petal
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setCircleColor(gl, n, [...pink]);
            gl.drawArrays(gl.TRIANGLES, 0, 3 * n);

            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer); 
            setCircleVertices(gl, n, 0.47, 0.0, 0.0);
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);        //middle contorn
            setCircleColor(gl, n, [...black]);
            gl.drawArrays(gl.TRIANGLES, 0, 3 * n);

            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer); 
            setCircleVertices(gl, n, 0.45, 0.0, 0.0);
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);        //middle
            setCircleColor(gl, n, [...yellow]);
            gl.drawArrays(gl.TRIANGLES, 0, 3 * n);

            break;

        case 3:         //drawClown
            //left hair
            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer); 
            setCircleVertices(gl, n, 0.17, -0.23, 0.3);
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setCircleColor(gl, n, [...orange]);
            gl.drawArrays(gl.TRIANGLES, 0, 3 * n);

            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer); 
            setCircleVertices(gl, n, 0.17, -0.36, 0.14);
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setCircleColor(gl, n, [...orange]);
            gl.drawArrays(gl.TRIANGLES, 0, 3 * n);

            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer); 
            setCircleVertices(gl, n, 0.17, -0.40, 0.30);
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setCircleColor(gl, n, [...orange]);
            gl.drawArrays(gl.TRIANGLES, 0, 3 * n);

            //right hair
            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer); 
            setCircleVertices(gl, n, 0.17, 0.23, 0.3);
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setCircleColor(gl, n, [...orange]);
            gl.drawArrays(gl.TRIANGLES, 0, 3 * n);

            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer); 
            setCircleVertices(gl, n, 0.17, 0.36, 0.14);
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setCircleColor(gl, n, [...orange]);
            gl.drawArrays(gl.TRIANGLES, 0, 3 * n);

            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer); 
            setCircleVertices(gl, n, 0.17, 0.40, 0.30);
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setCircleColor(gl, n, [...orange]);
            gl.drawArrays(gl.TRIANGLES, 0, 3 * n);
            // Face
            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
            setCircleVertices(gl, n, 0.4, 0.0, 0.0);
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setCircleColor(gl, n, [...pink]);
            gl.drawArrays(gl.TRIANGLES, 0, 3 * n);

            // Eyes
            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
            setCircleVertices(gl, n, 0.07, -0.15, 0.15); // Left
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setCircleColor(gl, n, [...white]);
            gl.drawArrays(gl.TRIANGLES, 0, 3 * n);

            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
            setCircleVertices(gl, n, 0.07, 0.15, 0.15); // Right
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setCircleColor(gl, n, [...white]);
            gl.drawArrays(gl.TRIANGLES, 0, 3 * n);

            // Pupils
            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
            setCircleVertices(gl, n, 0.03, -0.15, 0.15); // Left
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setCircleColor(gl, n, [...black]);
            gl.drawArrays(gl.TRIANGLES, 0, 3 * n);

            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
            setCircleVertices(gl, n, 0.03, 0.15, 0.15); // Right
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setCircleColor(gl, n, [...black]);
            gl.drawArrays(gl.TRIANGLES, 0, 3 * n);

            // Nose
            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
            setCircleVertices(gl, n, 0.1, 0.0, 0.05);
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setCircleColor(gl, n, [...red]);
            gl.drawArrays(gl.TRIANGLES, 0, 3 * n);

            // Mouth
            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
            setArcVertices(gl, n, 0.25, 0.0, -0.1, -(Math.PI * 0.0), -(Math.PI * 1));
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setCircleColor(gl, n, [...red]);
            gl.drawArrays(gl.TRIANGLES, 0, 3 * n);

            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
            setArcVertices(gl, n, 0.18, 0.0, -0.13, -(Math.PI * 0.0), -(Math.PI * 1));
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setCircleColor(gl, n, [...white]);
            gl.drawArrays(gl.TRIANGLES, 0, 3 * n);

            // Hat
            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
            setRectangleVertices(gl, -0.25, 0.35, 0.5, 0.05);
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setRectangleColor(gl, [...black]);
            gl.drawArrays(gl.TRIANGLES, 0, 6);

            gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
            setRectangleVertices(gl, -0.2, 0.4, 0.4, 0.3);
            gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
            setRectangleColor(gl, [...cian]);
            gl.drawArrays(gl.TRIANGLES, 0, 6);
 
            break;
    }
}

function createVertexShader(gl) {
    var vertexShader = gl.createShader(gl.VERTEX_SHADER);     // create vertex shader
    gl.shaderSource(vertexShader, `
    attribute vec2 position;
    attribute vec3 color;
    varying vec3 vColor;

    void main() {
        gl_Position = vec4(position,0.0,1.0);
        vColor = color;
    }
    `);
    gl.compileShader(vertexShader);

    const sucess = gl.getShaderParameter(vertexShader, gl.COMPILE_STATUS);
    if(sucess){
        return vertexShader;
    }

    console.log(gl.getShaderInfoLog(vertexShader));
    gl.deleteShader(vertexShader);
}

function createFragmentShader(gl) {
    var fragmentShader = gl.createShader(gl.FRAGMENT_SHADER); // create fragment shader
    gl.shaderSource(fragmentShader, `
    precision mediump float;

    varying vec3 vColor;        

    void main() {
        gl_FragColor = vec4(vColor,1.0);
    }
    `);
    gl.compileShader(fragmentShader);

    const sucess = gl.getShaderParameter(fragmentShader, gl.COMPILE_STATUS);
    if(sucess){
        return fragmentShader;
    }

    console.log(gl.getShaderInfoLog(fragmentShader));
    gl.deleteShader(fragmentShader);
}

function createProgram(gl, vertexShader, fragmentShader) {
    var program = gl.createProgram();
    gl.attachShader(program, vertexShader);
    gl.attachShader(program, fragmentShader);
    gl.linkProgram(program);

    const success = gl.getProgramParameter(program, gl.LINK_STATUS);
    if (success) {
        return program;
    }

    console.log(gl.getProgramInfoLog(program));
    gl.deleteProgram(program);
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
    console.log(center);
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