class Solution {
    static class Event {
        long y, x1, x2;
        int type;
        Event(long y, long x1, long x2, int type) {
            this.y = y;
            this.x1 = x1;
            this.x2 = x2;
            this.type = type;
        }
    }

    static class SegmentTree {
        int n;
        long[] cover, len;
        long[] xs;

        SegmentTree(long[] xs) {
            this.xs = xs;
            this.n = xs.length - 1;
            cover = new long[4 * n];
            len = new long[4 * n];
        }

        void update(int node, int l, int r, int ql, int qr, int val) {
            if (ql >= r || qr <= l) return;
            if (ql <= l && r <= qr) {
                cover[node] += val;
            } else {
                int mid = (l + r) / 2;
                update(node * 2, l, mid, ql, qr, val);
                update(node * 2 + 1, mid, r, ql, qr, val);
            }
            if (cover[node] > 0) {
                len[node] = xs[r] - xs[l];
            } else if (l + 1 == r) {
                len[node] = 0;
            } else {
                len[node] = len[node * 2] + len[node * 2 + 1];
            }
        }

        long query() {
            return len[1];
        }
    }
    public double separateSquares(int[][] squares) {
         List<Event> events = new ArrayList<>();
        Set<Long> xSet = new HashSet<>();

        for (int[] s : squares) {
            long x = s[0], y = s[1], l = s[2];
            events.add(new Event(y, x, x + l, 1));
            events.add(new Event(y + l, x, x + l, -1));
            xSet.add(x);
            xSet.add(x + l);
        }

        long[] xs = xSet.stream().sorted().mapToLong(Long::longValue).toArray();
        Map<Long, Integer> xIndex = new HashMap<>();
        for (int i = 0; i < xs.length; i++) xIndex.put(xs[i], i);

        events.sort(Comparator.comparingLong(e -> e.y));
        SegmentTree st = new SegmentTree(xs);

        double totalArea = 0;
        long prevY = events.get(0).y;

        for (Event e : events) {
            long dy = e.y - prevY;
            totalArea += st.query() * dy;
            st.update(1, 0, st.n, xIndex.get(e.x1), xIndex.get(e.x2), e.type);
            prevY = e.y;
        }

        double half = totalArea / 2.0;
        st = new SegmentTree(xs);
        prevY = events.get(0).y;
        double area = 0;

        for (Event e : events) {
            long dy = e.y - prevY;
            double add = st.query() * dy;
            if (area + add >= half) {
                return prevY + (half - area) / st.query();
            }
            area += add;
            st.update(1, 0, st.n, xIndex.get(e.x1), xIndex.get(e.x2), e.type);
            prevY = e.y;
        }

        return prevY;
    }
}