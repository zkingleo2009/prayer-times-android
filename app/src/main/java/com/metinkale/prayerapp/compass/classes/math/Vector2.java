package com.metinkale.prayerapp.compass.classes.math;

/**
 * ****************************************************************************
 * Copyright 2011 See AUTHORS file.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ****************************************************************************
 */

import java.io.Serializable;

/**
 * Encapsulates a 2D vector. Allows chaining methods by returning a reference to
 * itself
 *
 * @author badlogicgames@gmail.com
 */
public class Vector2 implements Serializable {
    public static final Vector2 tmp2 = new Vector2();
    public static final Vector2 tmp3 = new Vector2();
    public static final Vector2 X = new Vector2(1, 0);
    public static final Vector2 Y = new Vector2(0, 1);
    public static final Vector2 Zero = new Vector2(0, 0);
    private static final long serialVersionUID = 913902788239530931L;
    /**
     * Static temporary vector. Use with care! Use only when sure other code
     * will not also use this.
     *
     * @see #tmp()
     */
    private static final Vector2 tmp = new Vector2();
    public float x;

    public float y;

    private Vector2() {
    }

    /**
     * Constructs a vector with the given components
     *
     * @param x The x-component
     * @param y The y-component
     */
    private Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructs a vector from the given vector
     *
     * @param v The vector
     */
    private Vector2(Vector2 v) {
        set(v);
    }

    public Vector2 cpy() {
        return new Vector2(this);
    }

    float len() {
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public float len2() {
        return (x * x) + (y * y);
    }

    /**
     * Sets this vector from the given vector
     *
     * @param v The vector
     * @return This vector for chaining
     */
    Vector2 set(Vector2 v) {
        x = v.x;
        y = v.y;
        return this;
    }

    /**
     * Sets the components of this vector
     *
     * @param x The x-component
     * @param y The y-component
     * @return This vector for chaining
     */
    Vector2 set(float x, float y) {
        this.x = x;
        this.y = y;
        return this;
    }

    /**
     * Substracts the given vector from this vector.
     *
     * @param v The vector
     * @return This vector for chaining
     */
    public Vector2 sub(Vector2 v) {
        x -= v.x;
        y -= v.y;
        return this;
    }

    /**
     * Normalizes this vector
     *
     * @return This vector for chaining
     */
    public Vector2 nor() {
        float len = len();
        if (len != 0) {
            x /= len;
            y /= len;
        }
        return this;
    }

    /**
     * Adds the given vector to this vector
     *
     * @param v The vector
     * @return This vector for chaining
     */
    Vector2 add(Vector2 v) {
        x += v.x;
        y += v.y;
        return this;
    }

    /**
     * Adds the given components to this vector
     *
     * @param x The x-component
     * @param y The y-component
     * @return This vector for chaining
     */
    public Vector2 add(float x, float y) {
        this.x += x;
        this.y += y;
        return this;
    }

    /**
     * @param v The other vector
     * @return The dot product between this and the other vector
     */
    public float dot(Vector2 v) {
        return (x * v.x) + (y * v.y);
    }

    /**
     * Multiplies this vector by a scalar
     *
     * @param scalar The scalar
     * @return This vector for chaining
     */
    Vector2 mul(float scalar) {
        x *= scalar;
        y *= scalar;
        return this;
    }

    /**
     * Multiplies this vector by a scalar
     *
     * @return This vector for chaining
     */
    Vector2 mul(float x, float y) {
        this.x *= x;
        this.y *= y;
        return this;
    }

    public Vector2 div(float value) {
        return mul(1 / value);
    }

    public Vector2 div(float vx, float vy) {
        return mul(1 / vx, 1 / vy);
    }

    public Vector2 div(Vector2 other) {
        return mul(1 / other.x, 1 / other.y);
    }

    /**
     * @param v The other vector
     * @return the distance between this and the other vector
     */
    public float dst(Vector2 v) {
        float x_d = v.x - x;
        float y_d = v.y - y;
        return (float) Math.sqrt((x_d * x_d) + (y_d * y_d));
    }

    /**
     * @param x The x-component of the other vector
     * @param y The y-component of the other vector
     * @return the distance between this and the other vector
     */
    public float dst(float x, float y) {
        float x_d = x - this.x;
        float y_d = y - this.y;
        return (float) Math.sqrt((x_d * x_d) + (y_d * y_d));
    }

    /**
     * @param v The other vector
     * @return the squared distance between this and the other vector
     */
    public float dst2(Vector2 v) {
        float x_d = v.x - x;
        float y_d = v.y - y;
        return (x_d * x_d) + (y_d * y_d);
    }

    /**
     * @param x The x-component of the other vector
     * @param y The y-component of the other vector
     * @return the squared distance between this and the other vector
     */
    public float dst2(float x, float y) {
        float x_d = x - this.x;
        float y_d = y - this.y;
        return (x_d * x_d) + (y_d * y_d);
    }

    @Override
    public String toString() {
        return "[" + x + ":" + y + "]";
    }

    /**
     * Substracts the other vector from this vector.
     *
     * @param x The x-component of the other vector
     * @param y The y-component of the other vector
     * @return This vector for chaining
     */
    public Vector2 sub(float x, float y) {
        this.x -= x;
        this.y -= y;
        return this;
    }

    /**
     * NEVER EVER SAVE THIS REFERENCE! Do not use this unless you are aware of
     * the side-effects, e.g. other methods might call this as well.
     *
     * @return a temporary copy of this vector. Use with care as this is backed
     * by a single static Vector2 instance. v1.tmp().add( v2.tmp() )
     * will not work!
     */
    Vector2 tmp() {
        return tmp.set(this);
    }

    /**
     * Multiplies this vector by the given matrix
     *
     * @param mat the matrix
     * @return this vector
     */
    public Vector2 mul(Matrix3 mat) {
        float x = (this.x * mat.val[0]) + (y * mat.val[3]) + mat.val[6];
        float y = (this.x * mat.val[1]) + (this.y * mat.val[4]) + mat.val[7];
        this.x = x;
        this.y = y;
        return this;
    }

    /**
     * Calculates the 2D cross product between this and the given vector.
     *
     * @param v the other vector
     * @return the cross product
     */
    public float crs(Vector2 v) {
        return (x * v.y) - (y * v.x);
    }

    /**
     * Calculates the 2D cross product between this and the given vector.
     *
     * @param x the x-coordinate of the other vector
     * @param y the y-coordinate of the other vector
     * @return the cross product
     */
    public float crs(float x, float y) {
        return (this.x * y) - (this.y * x);
    }

    /**
     * @return the angle in degrees of this vector (point) relative to the
     * x-axis. Angles are counter-clockwise and between 0 and 360.
     */
    public float angle() {
        float angle = (float) Math.atan2(y, x) * MathUtils.radiansToDegrees;
        if (angle < 0) {
            angle += 360;
        }
        return angle;
    }

    /**
     * Sets the angle of the vector.
     *
     * @param angle The angle to set.
     */
    public void setAngle(float angle) {
        set(len(), 0f);
        rotate(angle);
    }

    /**
     * Rotates the Vector2 by the given angle, counter-clockwise.
     *
     * @param degrees the angle in degrees
     */
    Vector2 rotate(float degrees) {
        float rad = degrees * MathUtils.degreesToRadians;
        float cos = (float) Math.cos(rad);
        float sin = (float) Math.sin(rad);

        float newX = (x * cos) - (y * sin);
        float newY = (x * sin) + (y * cos);

        x = newX;
        y = newY;

        return this;
    }

    /**
     * Linearly interpolates between this vector and the target vector by alpha
     * which is in the range [0,1]. The result is stored in this vector.
     *
     * @param target The target vector
     * @param alpha  The interpolation coefficient
     * @return This vector for chaining.
     */
    public Vector2 lerp(Vector2 target, float alpha) {
        Vector2 r = mul(1.0f - alpha);
        r.add(target.tmp().mul(alpha));
        return r;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = (prime * result) + NumberUtils.floatToIntBits(x);
        result = (prime * result) + NumberUtils.floatToIntBits(y);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Vector2 other = (Vector2) obj;
        if (NumberUtils.floatToIntBits(x) != NumberUtils.floatToIntBits(other.x)) {
            return false;
        }
        return NumberUtils.floatToIntBits(y) == NumberUtils.floatToIntBits(other.y);
    }

    /**
     * Compares this vector with the other vector, using the supplied epsilon
     * for fuzzy equality testing.
     *
     * @param obj
     * @param epsilon
     * @return whether the vectors are the same.
     */
    public boolean epsilonEquals(Vector2 obj, float epsilon) {
        if (obj == null) {
            return false;
        }
        if (Math.abs(obj.x - x) > epsilon) {
            return false;
        }
        return Math.abs(obj.y - y) <= epsilon;
    }
}